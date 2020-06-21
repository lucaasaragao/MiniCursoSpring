package br.ufpb.minicurso.api1.servicos;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.minicurso.api1.entidades.Disciplina;
import org.springframework.stereotype.Service;

@Service
public class DisciplinasService {

	private List<Disciplina> disciplinasAdcionadas = new ArrayList<>();
	
	public Disciplina getDisciplina(String nome, int id, double nota) {
		Disciplina disciplina = new Disciplina(nome, id, nota);
		disciplina.setNome(nome);
		disciplina.setId(id);
		disciplina.setNota(nota);
		return disciplina;
	}
	
	public Disciplina setNovaDisciplina(Disciplina novaDisciplina) {
		disciplinasAdcionadas.add(novaDisciplina);
		return disciplinasAdcionadas.get(disciplinasAdcionadas.size() -1);
	}
	
	public Disciplina getNovaDisciplina(String nome, int id, double nota){
		if(disciplinasAdcionadas.isEmpty() || id < 0 || id >= disciplinasAdcionadas.size() ) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		disciplinasAdcionadas.get(id).setNome(nome);
		return disciplinasAdcionadas.get(id);
	}
	
	
}


