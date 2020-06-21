package br.ufpb.minicurso.api1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.minicurso.api1.entidades.Disciplina;
import br.ufpb.minicurso.api1.servicos.DisciplinasService;

/* */


@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService disciplinaService;
	
	@GetMapping("/v2/api/entra")
	public ResponseEntity<Disciplina> getDisciplina(@RequestParam(value = "nome", defaultValue = "Matematica") String nome){
		return new ResponseEntity<Disciplina>(disciplinaService.getDisciplina(nome, 2, 10), HttpStatus.OK);
	}
}
