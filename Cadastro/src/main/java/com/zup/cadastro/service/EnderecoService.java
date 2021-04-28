package com.zup.cadastro.service;

import com.zup.cadastro.model.Endereco;
import com.zup.cadastro.model.Usuario;
import com.zup.cadastro.repository.EnderecoRepository;
import com.zup.cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Endereco> cadastrarEndereco(String emailUsuario, Endereco endereco){
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
