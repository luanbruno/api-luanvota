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

import br.edu.infnet.apivotaluan.model.domain.Eleitor;
import br.edu.infnet.apivotaluan.model.service.EleitorService;

@RestController
@RequestMapping(value = "/api/eleitor")
public class EleitorController {
	
	@Autowired
	private EleitorService eleitorService;

	@GetMapping(value = "/{idEleitor}/listar")
	public Eleitor obterPorId(@PathVariable Integer idEleitor) {

		return eleitorService.obterPorId(idEleitor);
	}

	@GetMapping(value = "/listar")
	public List<Eleitor> obterLista() {

		return eleitorService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Eleitor eleitor) {

		eleitorService.incluir(eleitor);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {

		eleitorService.excluir(id);
	}

}
