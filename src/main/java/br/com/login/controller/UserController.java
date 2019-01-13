package br.com.login.controller;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernando
 */
@RestController
@RequestMapping("/users")
public class UserController {
private Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(user.getPassword()));
        usuarioRepository.save(user);
    }

    @PostMapping("/cadastroUsuario")
    public void CadastroUsuario(@RequestBody Usuario usuario) {
        try {
           usuarioRepository.save(usuario); 
        } catch (Exception e) {
            log.error("Erro ao salvar usuario ",e);
        }
        
    }

    @PostMapping("/alterarUsurio")
    public void alterarUsuario(@RequestBody Usuario usuario) {
        Usuario user;
       // user = (Usuario) usuarioRepository.findById(usuario.getId().longValue());

    }

}
