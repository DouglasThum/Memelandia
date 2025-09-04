package com.douglas.servico;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.douglas.entity.Usuario;
import com.douglas.repository.UsuarioRepository;

@Component
public class ServicoUsuario {
	
	private final UsuarioRepository usuarioRepository;
	
	public ServicoUsuario(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Iterable<Usuario> encontrarTodos() {
		return usuarioRepository.findAll();
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
	}
}
