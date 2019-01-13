/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.login.repository;

import br.com.login.model.Usuario;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author fernando
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryIT {

    @Autowired
    UsuarioRepository usuarioRepository;

//    public UsuarioRepositoryIT() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of findByUsername method, of class UsuarioRepository.
//     */
//    @Test
//    public void testFindByUsername() {
//        System.out.println("findByUsername");
//        String username = "";
//        UsuarioRepository instance = new UsuarioRepositoryImpl();
//        Usuario expResult = null;
//        Usuario result = instance.findByUsername(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByUsernameAndPassword method, of class UsuarioRepository.
//     */
//    @Test
//    public void testFindByUsernameAndPassword() {
//        System.out.println("findByUsernameAndPassword");
//        String username = "";
//        String password = "";
//        UsuarioRepository instance = new UsuarioRepositoryImpl();
//        Usuario expResult = null;
//        Usuario result = instance.findByUsernameAndPassword(username, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class UsuarioRepositoryImpl implements UsuarioRepository {
//
//        public Usuario findByUsername(String username) {
//            return null;
//        }
//
//        public Usuario findByUsernameAndPassword(String username, String password) {
//            return null;
//        }
//    }
//    
    @Test
    public void testFindAll() {
        // Get all the people
        List<Usuario> people = usuarioRepository.findAll();

        assertEquals(4, people.size());
    }

}
