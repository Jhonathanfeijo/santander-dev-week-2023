package com.santander.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {

	@GetMapping
	public String helloWorld() {
		return "Olá, Sou Jhonathan Feijó. Seja bem-vindo ao meu projeto Santander Dev Wek 2023";
	}
}
