package utilities;

public class TestData {
    public static final String heading = "Login Form";
    public static final String[] labelUsernameAndPassword = {"Please enter your username",
                                                             "Please enter your password"};
    public static final String forgotPasswordLinkText = "Forgot Password?";
    public static final String[] validCredentials = {"TechGlobal",
                                                     "Test1234"};
    public static final String massageAfterSuccessfulLogin = "You are logged in";
    public static final String loginFormURL = "https://techglobal-training.netlify.app/frontend/login-form";
    public static final String resetPasswordText = "Reset Password";
    public static final String forgetPasswordMessage =
            "Enter your email address and we'll send you a link to reset your password.";
    public static final String submitButton = "SUBMIT";
    public static final String validEmail = "johndoe@gmail.com";
    public static final String conformationMessage = "A link to reset your password has been sent to your email address.";
    public static final String[] invalidUsernameValidPassword = {"john",
                                                                 "Test1234"};
    public static final String errorInvalidUsernameMessage = "Invalid Username entered!";
    public static final String errorInvalidPasswordMessage = "Invalid Password entered!";
    public static final String[] validUsernameInvalidPassword = {"TechGlobal",
                                                                 "1234"};
    public static final String[] invalidCredentials = {"john",
                                                       "1234"};
}
