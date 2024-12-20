/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class SignUpAdapter implements AuthInterface {
    private SignUp signUp;

    public SignUpAdapter(SignUp signUp) {
        this.signUp = signUp;
    }

    @Override
    public void displayForm() {
        signUp.setVisible(true);
    }

    
}
