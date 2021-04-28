package com.zup.cadastro.service;

import com.zup.cadastro.model.Usuario;
import com.zup.cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario){
        try {
            usuarioRepository.save(usuario);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    public ResponseEntity<?> buscarPorEmail(String usuarioEmail) {
        try {
            usuarioRepository.findByEmail(usuarioEmail).orElseThrow();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há usuário cadastrado com o e-mail informado");
        }
        return ResponseEntity.ok(usuarioRepository.findByEmail(usuarioEmail));
    }
}