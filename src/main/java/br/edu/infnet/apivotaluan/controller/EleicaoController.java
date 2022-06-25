package br.edu.infnet.apivotaluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apivotaluan.model.domain.Eleicao;
import br.edu.infnet.apivotaluan.model.service.EleicaoService;
@RestController
@RequestMapping(value = "/api/eleicao")
public class EleicaoController {

	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping(value = "/{idEleicao}/listar")
	public Eleicao obterPorId(@PathVariable Integer idEleicao) {

		return eleicaoService.obterPorId(idEleicao);
	}

	@GetMapping(value = "/listar")
	public List<Eleicao> obterLista() {

		return eleicaoService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Eleicao eleicao) {

		eleicaoService.incluir(eleicao);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {

		eleicaoService.excluir(id);
	}

}

