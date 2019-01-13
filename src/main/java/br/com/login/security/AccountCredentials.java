package br.com.login.security;

import br.com.login.usuario.Login;

/**
 *
 * @author fernando
 */
public class AccountCredentials {

    private boolean success;
    private String message;
    private Login usuario;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
