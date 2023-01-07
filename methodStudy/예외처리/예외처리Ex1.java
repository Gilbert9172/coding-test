package 예외처리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class 예외처리Ex1 {

    public void a() {
        b();
    }

    private void b() {
        c();
    }

    private void c() throws CustomException {
        System.out.println("method c()");
    }

}

class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
