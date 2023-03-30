package br.com.seiya.barbershop.aplicativo.adaptadores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentacaoController {

	@RequestMapping("/")
	public String start() {
		return "index";
	}
}
