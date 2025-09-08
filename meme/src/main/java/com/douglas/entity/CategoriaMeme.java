package com.douglas.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

public class CategoriaMeme {

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataCadastro;

	public CategoriaMeme(Long id, String nome, String descricao, LocalDate dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}

	public void CategoriaMeme() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
