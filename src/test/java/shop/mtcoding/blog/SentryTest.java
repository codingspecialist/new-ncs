package shop.mtcoding.blog;

import io.sentry.Sentry;
import org.junit.jupiter.api.Test;

public class SentryTest {

    @Test
    public void msg_test(){
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            System.out.println("111111111111111");
            Sentry.captureException(e);
            System.out.println("22222222222222222");
        }
    }
}
