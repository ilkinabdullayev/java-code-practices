package info.ilkinabdullayev.basic.lesson1;

public class LambdaApp {


    public static void main(String[] args) {
        LambdaApp lambdaApp = new LambdaApp();

        int result = lambdaApp.fancyMethod(3, 4, new Anonim() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        });


        int result2 = lambdaApp.fancyMethod(3, 4, (a, b) -> a + b);

        System.out.println("Result:" + result);
        System.out.println("Result2:" + result2);
    }


    public int fancyMethod(int a, int b, Anonim anonim) {
        return 2 * anonim.sum(a, b);
    }

}

