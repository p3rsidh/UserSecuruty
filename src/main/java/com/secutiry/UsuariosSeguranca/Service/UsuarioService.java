package com.secutiry.UsuariosSeguranca.Service;

import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import com.secutiry.UsuariosSeguranca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> apagarUsuario(Long id){
        usuarioRepository.deleteById(id);
        return usuarioRepository.findAll();
    }
}

