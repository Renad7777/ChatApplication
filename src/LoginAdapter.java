/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class LoginAdapter implements AuthInterface {
    private Login login;

    public LoginAdapter(Login login) {
        this.login = login;
    }

    @Override
    public void displayForm() {
        login.setVisible(true);
    }

}
