package java8.lambda;

interface MyFunc {
    int func(int n);
}

public class _05_VarCapture {

    public static void main(String args[]) {
        int num = 10;
        MyFunc myLambda = (n) -> {
            // OK
            int v = num + n;
            //      num++; 
            return v;
        };
        //  num = 9; 
    }

}
