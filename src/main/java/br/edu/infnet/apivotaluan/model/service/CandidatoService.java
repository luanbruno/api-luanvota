package br.edu.infnet.apivotaluan.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apivotaluan.model.domain.Candidato;
import br.edu.infnet.apivotaluan.model.domain.Eleicao;
import br.edu.infnet.apivotaluan.model.repository.CandidatoRepository;
@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public void incluir(Candidato candidato) {
		candidatoRepository.save(candidato);
	}
	public void excluir(Integer id) {
		candidatoRepository.deleteById(id);

	}
	
	public List<Candidato> obterLista(){
		return (List<Candidato>) candidatoRepository.findAll();
	}
		
	public Candidato obterPorId(Integer id) {
		return candidatoRepository.findById(id).orElse(null);
	}
	
	public List<Candidato> obterPorEleicao(Eleicao eleicao) {		
		List<Candidato> candidatos = new ArrayList<Candidato>();
		
		for(Candidato candidato : candidatoRepository.findAll()) {
			if (candidato.getEleicao()!=null && candidato.getEleicao().equals(eleicao)) {
				candidatos.add(candidato);
			}
		}		
		return candidatos;
	}
	
}
