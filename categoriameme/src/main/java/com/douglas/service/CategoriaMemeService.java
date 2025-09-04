package com.douglas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douglas.entity.CategoriaMeme;
import com.douglas.repository.CategoriaMemeRepository;

@Component
public class CategoriaMemeService {
	
	@Autowired
    private final CategoriaMemeRepository categoriaMemeRepository;

    public CategoriaMemeService(CategoriaMemeRepository categoriaMemeRepository) {
        this.categoriaMemeRepository = categoriaMemeRepository;
    }

    public Iterable<CategoriaMeme> encontrarTodos() {
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme criarCategoriaMeme(CategoriaMeme categoriaMeme) {
        return categoriaMemeRepository.save(categoriaMeme);
    }

    public CategoriaMeme buscarCategoriaMemePorId(Long id) {
        Optional<CategoriaMeme> categoria = categoriaMemeRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new RuntimeException("CategoriaMeme não encontrada!");
        }
    }
}
