package com.zup.cadastro.controller;

import com.zup.cadastro.service.UsuarioService;
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
	private UsuarioService usuarioService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario);
	}

	@GetMapping("/listarEnderecos/{usuarioEmail}")
	public ResponseEntity<?> buscarPorEmail(@PathVariable String usuarioEmail) {
		return usuarioService.buscarPorEmail(usuarioEmail);
	}
}