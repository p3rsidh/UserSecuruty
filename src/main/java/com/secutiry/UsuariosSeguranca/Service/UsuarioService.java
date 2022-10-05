package com.secutiry.UsuariosSeguranca.Service;

import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import com.secutiry.UsuariosSeguranca.Model.UsuarioResponse;
import com.secutiry.UsuariosSeguranca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> buscarUsuarios(){
        List<UsuarioResponse> novaLista = new ArrayList<>();

        for (UsuarioModel usuarioModel : usuarioRepository.findAll()){
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setNome(usuarioModel.getNome());
            usuarioResponse.setLogin(usuarioModel.getLogin());
            usuarioResponse.setSenha(usuarioModel.getSenha());
             novaLista.add(usuarioResponse);
        }

        return novaLista;
    }

    public UsuarioResponse cadastrarUsuario(UsuarioModel usuarioModel){
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));
        usuarioRepository.save(usuarioModel);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNome(usuarioModel.getNome());
        usuarioResponse.setLogin(usuarioModel.getLogin());
        usuarioResponse.setSenha(usuarioModel.getSenha());

        return usuarioResponse;
    }

    public void apagarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        if (usuarioRepository.findAll().isEmpty()) {
            throw new NullPointerException();
        }
    }
}

