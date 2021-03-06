package string;

import java.io.*;

import utils.BinaryFile;

public class _12_Format_Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            // Test by displaying this class file:
            System.out.println(format(BinaryFile.read("_112_Hex.class")));
        } else {
            System.out.println(format(BinaryFile.read(new File(args[0]))));
        }
    }

}