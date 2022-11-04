package br.com.login.security;

import br.com.login.usuario.Login;

public class AccountCredentials {

    private boolean success;
    private Login usuario;

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
