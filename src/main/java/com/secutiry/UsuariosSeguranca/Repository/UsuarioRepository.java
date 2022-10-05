package com.secutiry.UsuariosSeguranca.Repository;

import com.secutiry.UsuariosSeguranca.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
