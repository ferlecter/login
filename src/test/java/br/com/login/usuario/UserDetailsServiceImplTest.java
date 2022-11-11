package br.com.login.usuario;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {
    @Mock
    private UserDetailsService userDetailsService;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Before
    public void setup() {
        userDetailsService = new UserDetailsServiceImpl(usuarioRepository);
    }

    @Test
    public void testLoadUserByUsername() {
        Usuario usuario = getUser();
        when(usuarioRepository.findByUsername("a@a.com.br")).thenReturn(usuario);
        UserDetails u = userDetailsService.loadUserByUsername("a@a.com.br");

        Assert.assertTrue(u.isEnabled());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserNull() {
        doThrow(new UsernameNotFoundException("Usuario não encontrado"))
                .when(usuarioRepository).findByUsername("a@a.com.br");

        Assert.assertEquals(userDetailsService.loadUserByUsername("a@a.com.br"), "Usuario não encontrado");
    }

    private Usuario getUser() {
        Usuario usuario = new Usuario();

        usuario.setPassword("123");
        usuario.setPerfil("A");
        usuario.setEmail("a@a.com.br");
        usuario.setUsername("aaa");
        usuario.setId(1);

        return usuario;
    }
}