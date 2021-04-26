package com.zup.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zup.cadastro.model.Usuario;
import com.zup.cadastro.repository.UsuarioRepository;


@RequestMapping("/usuario")
@CrossOrigin("*")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		try {
			usuarioRepository.save(usuario);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	@GetMapping("/listarEnderecos/{usuarioEmail}")
	public ResponseEntity<?> buscarPorEmail(@PathVariable String usuarioEmail) {
		try {
			usuarioRepository.findByEmail(usuarioEmail).orElseThrow();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Não há usuário cadastrado com o e-mail informado");
		}
		return ResponseEntity.ok(usuarioRepository.findByEmail(usuarioEmail));
	}
}