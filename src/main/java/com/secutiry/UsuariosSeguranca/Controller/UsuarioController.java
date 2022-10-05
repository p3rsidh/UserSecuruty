package com.secutiry.UsuariosSeguranca.Controller;

import com.secutiry.UsuariosSeguranca.ExceptionHandler.ExceptionHandlerUsuario;
import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import com.secutiry.UsuariosSeguranca.Model.UsuarioResponse;
import com.secutiry.UsuariosSeguranca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController extends ExceptionHandlerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    @ResponseBody
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioModel));
    }

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<UsuarioResponse>> buscarUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }

    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity<List<?>> deletarUsuario(Long id){
         usuarioService.apagarUsuario(id);
         return null;
    }

}
