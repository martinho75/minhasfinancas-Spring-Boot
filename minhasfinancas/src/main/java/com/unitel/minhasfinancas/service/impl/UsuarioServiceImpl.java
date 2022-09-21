package com.unitel.minhasfinancas.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unitel.minhasfinancas.exception.ErroAutenticacao;
import com.unitel.minhasfinancas.exception.RegraNegocioException;
import com.unitel.minhasfinancas.model.entity.Usuario;
import com.unitel.minhasfinancas.model.repository.UsuarioRepository;
import com.unitel.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;
     
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        
        Optional<Usuario> usuario = repository.findByEmail(email);
        if(!usuario.isPresent()){
            throw new ErroAutenticacao("Usuario não encontrado para o email informado");
        }

        if(!usuario.get().getSenha().equals(senha)){
            throw new ErroAutenticacao("senha inválida");
        }

        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
         validarEmail(usuario.getEmail());
         
         return repository.save(usuario);
        
    }

    @Override
    public void validarEmail(String email) {
        
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
        }
        
    }
    
}
