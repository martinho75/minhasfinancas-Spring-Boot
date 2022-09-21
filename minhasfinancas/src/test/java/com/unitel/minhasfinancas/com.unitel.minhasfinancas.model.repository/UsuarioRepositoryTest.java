import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.unitel.minhasfinancas.model.entity.Usuario;
import com.unitel.minhasfinancas.model.repository.UsuarioRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith( SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveverificarAExistenciaDeUmEmail(){
        //cenario
        /*Usuario usuario = Usuario.builder().nome("usuario").email("usuario@gmail.com").senha("senha").build();*/

        Usuario usuario = new Usuario();
        usuario.setNome("usuario");
        usuario.setEmail("usuario@gmail.com");
        usuario.setSenha("senha");
        repository.save(usuario);

        //ação
        boolean result = repository.existsByEmail("usuario@gmail.com");

        //verificação
        Assertions.assertThat(result).isTrue();
    }
    
}
