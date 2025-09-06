package com.douglas.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douglas.controller.CategoriaMemeController;
import com.douglas.entity.Usuario;

@Configuration
@EnableDiscoveryClient
public class CategoriaMemeClient {

	@Autowired
	private ICategoriaMemeClient categoriaMemeClient;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeController.class);


	public Iterable<Usuario> buscarTodos() {
		logger.info("Chamando o Feign Client para buscar todos os usuários");
		return categoriaMemeClient.buscarTodos();
	}

	public Usuario buscarPorId(Long id) {
		return categoriaMemeClient.buscarPorId(id);
	}
	
	// Interface com implementação de Feign Client
	
	@FeignClient(name = "user", url = "http://localhost:8080")
	interface ICategoriaMemeClient {
		@RequestMapping(path = "/usuarios", method = RequestMethod.GET)
		@ResponseBody
		Iterable<Usuario> buscarTodos();

		@RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
		@ResponseBody
		Usuario buscarPorId(@PathVariable("id") Long id);
	}
}
