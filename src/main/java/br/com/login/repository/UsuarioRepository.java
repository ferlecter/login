package br.com.login.repository;

import br.com.login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String password);
    
    Usuario findByEmail(String email);

}
