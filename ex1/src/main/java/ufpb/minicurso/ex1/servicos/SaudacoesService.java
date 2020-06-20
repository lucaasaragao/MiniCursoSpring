package ufpb.minicurso.ex1.servicos;

import org.springframework.stereotype.Service;

import ufpb.minicurso.ex1.entidades.Saudacao;
import ufpb.minicurso.ex1.entidades.SaudacaoTemporalFactory;

import java.util.List;
import java.util.ArrayList;



@Service
public class SaudacoesService {
	
	private List <Saudacao> saudacoesAlternativas = new ArrayList<>();
	
	public Saudacao getSaudacao(String nome) {
		Saudacao saudacao = new Saudacao();
		saudacao.setNome(nome);
		return saudacao;
	}
	
	public Saudacao getSaudacaoTemporal(String nome) {
		return SaudacaoTemporalFactory.getSaudacaoTemporal(nome);
		
	}
	
	
	public Saudacao setNovaSaudacao (Saudacao novaSaudacao) {
		saudacoesAlternativas.add(novaSaudacao);
		return saudacoesAlternativas.get(saudacoesAlternativas.size() -1);
	}
	
	public Saudacao getNovaSaudacao(String nome, int id) {
		if(saudacoesAlternativas.isEmpty() || id < 0 || id>= saudacoesAlternativas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		saudacoesAlternativas.get(id).setNome(nome);
		return saudacoesAlternativas.get(id);
	}
	
	

}
