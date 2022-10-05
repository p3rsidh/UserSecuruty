package com.secutiry.UsuariosSeguranca.Service;

import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import com.secutiry.UsuariosSeguranca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> apagarUsuario(Long id){
        usuarioRepository.deleteById(id);
        if (usuarioRepository.findAll().isEmpty()){
            throw new NullPointerException();
        }else
        return usuarioRepository.findAll();
    }
}

