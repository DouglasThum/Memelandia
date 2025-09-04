package com.douglas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.entity.Usuario;
import com.douglas.servico.ServicoUsuario;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {
	
	 private static final Logger logger = LoggerFactory.getLogger(ControllerUsuario.class);
	 private final ServicoUsuario servicoUsuario;
	 
	 public ControllerUsuario(ServicoUsuario servicoUsuario) {
		 this.servicoUsuario = servicoUsuario;
	 }
	 
	 @PostMapping
	 public Usuario criarUsuario(@RequestBody Usuario usuario) {
		 logger.info("Criando usuário: {}", usuario);
		 Usuario usuarioCriado = servicoUsuario.criarUsuario(usuario);
		 logger.info("Usuario criado: {}", usuario);
		 return usuarioCriado;
	 }
	 
	 @GetMapping
	 public Iterable<Usuario> encontrarTodos() {
		 logger.info("Encontrar todos usuários");
		 Iterable<Usuario> usuarios = servicoUsuario.encontrarTodos();
		 logger.info("Encontrados {} usuários", usuarios.spliterator().getExactSizeIfKnown());
		 return usuarios;
	 }
	 
	    @GetMapping("/{id}")
	    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
	        logger.info("Buscando usuário com id: {} ", id);
	        Usuario usuarios = servicoUsuario.buscarUsuarioPorId(id);
	        logger.info("Usuário encontrado: {}", usuarios);
	        return usuarios;
	    }

}
