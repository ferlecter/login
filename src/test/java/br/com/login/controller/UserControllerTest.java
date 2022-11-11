package br.com.login.controller;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Logger log;
    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
    }

    @Before
    public void setUp() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void testSignUp() {
        System.out.println("signUp");
        ResponseEntity r = ResponseEntity.ok().build();
        Usuario usuario = getUser();
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        assertEquals(userController.signUp(usuario), r);

    }

    @Test
    public void testSignupException() {
        Usuario usuario = new Usuario();
        ResponseEntity r = ResponseEntity.badRequest().build();
        assertEquals(userController.signUp(usuario), r);

    }


    private Usuario getUser() {
        Usuario usuario = new Usuario();

        usuario.setPassword("123");
        usuario.setId(1);
        usuario.setEmail("discolaser@gmail.com");
        usuario.setEnable(true);
        usuario.setPerfil("A");

        return usuario;
    }

}
