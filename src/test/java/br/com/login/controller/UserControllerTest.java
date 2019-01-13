package br.com.login.controller;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author fernando
 */
public class UserControllerTest {

    public UserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of signUp method, of class UserController.
     */
    @Test
    public void testSignUp() {
        System.out.println("signUp");
        Usuario user = new Usuario();

        user.setPassword("123");
        user.setId(1);
        user.setEmail("discolaser@gmail.com");
        user.setEnable(true);
        user.setPerfil("A");

//        UserController instance = new UserController(new BCryptPasswordEncoder());
//        instance.signUp(user);
//        instance.signUp(user);

// TODO review the generated test code and remove the default call to fail.
    }

}
