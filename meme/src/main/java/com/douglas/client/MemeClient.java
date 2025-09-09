package com.douglas.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douglas.entity.CategoriaMeme;
import com.douglas.entity.Usuario;

@Configuration
@EnableDiscoveryClient
public class MemeClient {

	@Autowired
	private ICategoriaClient iCategoriaClient;

	@Autowired
	private IUsuarioClient iUsuarioClient;

	public Iterable<CategoriaMeme> encontrarTodasCategoriasMemes() {
		return iCategoriaClient.encontrarTodasCategoriasMemes();
	}

	public Iterable<Usuario> encontrarTodosUsuarios() {
		return iUsuarioClient.encontrarTodosUsuarios();
	}

	public Usuario encontrarUsuarioPorId(Long id) {
		return iUsuarioClient.encontrarUsuarioPorId(id);
	}

	public CategoriaMeme encontrarCategoriaMemePorId(Long id) {
		return iCategoriaClient.encontrarCategoriaMemePorId(id);
	}

	@FeignClient(name = "categoriameme", url = "http://localhost:8081")
	interface ICategoriaClient {
		@RequestMapping(value = "/categorias", method = RequestMethod.GET)
		@ResponseBody
		Iterable<CategoriaMeme> encontrarTodasCategoriasMemes();

		@RequestMapping(value = "/categorias/{id}", method = RequestMethod.GET)
		@ResponseBody
		CategoriaMeme encontrarCategoriaMemePorId(@PathVariable("id") Long id);
	}

	@FeignClient(name = "user", url = "http://localhost:8080")
	interface IUsuarioClient {
		@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
		@ResponseBody
		Iterable<Usuario> encontrarTodosUsuarios();

		@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
		@ResponseBody
		Usuario encontrarUsuarioPorId(@PathVariable("id") Long id);
	}
}
