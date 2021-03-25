package tt.com.pl.test;

import tt.com.pl.test.validator.ValidatorExecutor;

public class Main {

    public static void main(String[] args) {

        Test test =  new Test();
        test.setName("Mateusz");

        ValidatorExecutor.valid(test);

        System.out.println("Działa");

    }
}
