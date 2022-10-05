package com.secutiry.UsuariosSeguranca.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ExceptionHandlerUsuario {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> listaVazia(NullPointerException nullPointerException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Sua lista está vazia", HttpStatus.NO_CONTENT);
    }


}
