import org.junit.jupiter.api.*;
import org.teststackoverflow.SignUp;

public class HeaderTest extends BaseClass {

    String urlSignUpValid = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f";
    String urlSignUpInvalid = "https://stackoverflow.com/users/login?ssrc=head";

    @Test
    public void urlPositiveTestCheckIfCorrectPageIsOpenedAfterClickingSignUp() {
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(urlSignUpValid, url);
    }

    @Test
    public void checkWithTitleThatCorrectPageIsOpenedAfterClickingSignUp() {
        SignUp signUp = header.clickSignUpButton();
        String title = signUp.getTitle();
        Assertions.assertEquals("Join the Stack Overflow community", title);
    }

    @Test
    public void urlNegativeTestCheckIfCorrectPageIsOpenedAfterClickingSignUp() {
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertNotEquals(urlSignUpInvalid, url);
    }
}
