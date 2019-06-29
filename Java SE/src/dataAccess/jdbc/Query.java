/**
 *  @author Yunxiang He
 *  @date   06/23/2019
 */

package dataAccess.jdbc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javaSe.foundation.io.FileUtil;

public class Query {

    private static final String DIRECTORY = "temp";

    private static class CalculateRefundRequest {
        private String asin;
        private String remark;

        public CalculateRefundRequest(String asin, String remark) {
            this.asin = asin;
            this.remark = remark;
        }

        @Override
        public String toString() {
            return "Asin: " + asin + " remark:" + remark + "\n";
        }
    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        try (Connection connection = DbUtil.getConnection()) {
            try (PreparedStatement pstm = connection.prepareStatement("SELECT asin FROM protected_offer_listings")) {
                ResultSet rs = pstm.executeQuery();
                int k = 0;
                while (rs.next()) {
                    map.computeIfAbsent(k++ % 10, ArrayList<String>::new).add(rs.getString("asin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for (List<String> asins : map.values()) {
            executor.execute(new CCC(asins));
        }
        executor.shutdown();
    }

    public static class CCC implements Runnable {
        private List<String> asins;

        public CCC(List<String> asins) {
            this.asins = asins;
        }

        public void run() {
            Path file = FileUtil.createIfAbsent(DIRECTORY, "calculateRefundForAffectedPurchaseIds" + " " + Thread.currentThread().getName() + ".txt");
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {
                try (Connection connection = DbUtil.getConnection()) {
                    for (String affectedAsin : asins) {
                        List<CalculateRefundRequest> list = query(affectedAsin);
                        for (CalculateRefundRequest calculateRefundRequest : list)
                            bufferedWriter.write(calculateRefundRequest.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<CalculateRefundRequest> query(String asin) {
        List<CalculateRefundRequest> list = new ArrayList<>();
        try (PreparedStatement pstm = DbUtil.getConnection().prepareStatement("SELECT asin, remark FROM protected_line_items where asin = ?")) {
            pstm.setString(1, asin);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new CalculateRefundRequest(asin, rs.getString("remark")));
            }
            throw new SQLException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
