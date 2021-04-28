package com.zup.cadastro.controller;

import com.zup.cadastro.model.Usuario;
import com.zup.cadastro.repository.UsuarioRepository;
import com.zup.cadastro.service.EnderecoService;
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
	private EnderecoService enderecoService;
	
	@PostMapping("/cadastrar/{emailUsuario}")
	public ResponseEntity<Endereco> cadastrarEndereco(@PathVariable String emailUsuario, @RequestBody Endereco endereco){
		return enderecoService.cadastrarEndereco(emailUsuario, endereco);
	}
}