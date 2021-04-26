package com.zup.cadastro.controller;

import com.zup.cadastro.model.Usuario;
import com.zup.cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zup.cadastro.model.Endereco;
import com.zup.cadastro.repository.EnderecoRepository;

@RequestMapping("/endereco")
@CrossOrigin("*")
@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastrar/{emailUsuario}")
	public ResponseEntity<Endereco> cadastrarEndereco(@PathVariable String emailUsuario, @RequestBody Endereco endereco){
		try{
			Usuario usuario = usuarioRepository.findByEmail(emailUsuario).orElseThrow();
			endereco.setUsuario(usuario);
			enderecoRepository.save(endereco);
		} catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}
}