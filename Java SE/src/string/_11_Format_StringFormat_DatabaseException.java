package string;

@SuppressWarnings("serial")
public class _11_Format_StringFormat_DatabaseException extends Exception {

    public _11_Format_StringFormat_DatabaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new _11_Format_StringFormat_DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}