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

import br.edu.infnet.apivotaluan.model.domain.Candidato;
import br.edu.infnet.apivotaluan.model.service.CandidatoService;

@RestController
@RequestMapping(value = "/api/candidato")
public class CanditatoController {

	@Autowired
	private CandidatoService candidatoService;

	@GetMapping(value = "/listar")
	public List<Candidato> obterLista() {
	return candidatoService.obterLista();
	}

	@GetMapping(value="/{idCandidato}/listar")
	public Candidato obterPorId(@PathVariable int idCandidato) {
		return candidatoService.obterPorId(idCandidato);
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Candidato candidato) {
		candidatoService.incluir(candidato);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		candidatoService.excluir(id);
	}

}
