package com.secutiry.UsuariosSeguranca.Controller;

import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import com.secutiry.UsuariosSeguranca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuario")
    public ResponseEntity<UsuarioModel> buscarUsuarios(){
        return null;
    }

}
