package br.com.login.controller;

import br.com.login.model.Usuario;
import br.com.login.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger log = LogManager.getLogger(UserController.class);
    private static final String LOG_ERRO = "UC001E";

    @Autowired
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody Usuario user) {
        try {
            if (user.getId() == null) {
                throw new NullPointerException("id null");
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            usuarioRepository.save(user);
            return ResponseEntity.ok().build();
        } catch (ClassCastException | NullPointerException e) {
            log.error(LOG_ERRO, "Erro ao salvar usuario", user);
            return ResponseEntity.badRequest().build();
        }

    }
}
