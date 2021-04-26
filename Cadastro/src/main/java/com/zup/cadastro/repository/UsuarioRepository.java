package com.zup.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.cadastro.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmail(String email);
}
