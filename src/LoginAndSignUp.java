


public class LoginAndSignUp {


    public static void main(String[] args) {
        
        
User originalUser = new User("John Doe", "john@example.com", "123456");
        User clonedUser = originalUser.clone();
        System.out.println("Original User: " + originalUser);
        System.out.println("Cloned User: " + clonedUser);
        Login loginFrame =  new Login();
        
        // Adapter Example
        AuthInterface loginAdapter = new LoginAdapter(loginFrame);
        SignUp signUpFrame = null;
        AuthInterface signUpAdapter = new SignUpAdapter(signUpFrame);
        // Display Login Form
        loginAdapter.displayForm();

    }
    
}
