import org.junit.jupiter.api.*;
import org.teststackoverflow.SignUp;

public class HeaderTest extends BaseClass {

    String urlSignUpValid = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f";
    String urlSignUpInvalid = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%";

    @Test
    public void urlNegativeTest(){
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertNotEquals(urlSignUpInvalid, url);
    }

    @Test
    public void urlPositiveTest(){
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(urlSignUpValid, url);
    }

}
