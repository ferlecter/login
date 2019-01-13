package br.com.login.usuario;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import static java.util.Collections.emptyList;
import java.util.HashSet;
import java.util.Set;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger log = Logger.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = null;
        try {

            usuario = usuarioRepository.findByUsername(username);
            if (usuario == null) {
                throw new UsernameNotFoundException(username);
            }
            User u = new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, emptyList());
            System.out.println(u.getUsername());
            //return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
            return u;
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }
    }

    public UserDetails loadByUserNameAndPassWord(String username, String password) throws UsernameNotFoundException {
        Usuario usuario = null;
        try {

            usuario = usuarioRepository.findByUsernameAndPassword(username, password);
            if (usuario == null) {
                throw new UsernameNotFoundException(username);
            }
            return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }
    }

    public UserDetails loadByEmail(String email) throws UsernameNotFoundException {
        Usuario usuario = null;
        
        try {
            usuario = usuarioRepository.findByEmail(email);

            if (usuario == null) {
                throw new UsernameNotFoundException("Email nao localizado : " + email);
            }
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getPerfil()));

            return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthorities);
            
        } catch (UsernameNotFoundException e) {
            log.error("Erro ao buscar ", e);
            throw new UsernameNotFoundException("Email nao localizado : " + email);
        }

    }

}
