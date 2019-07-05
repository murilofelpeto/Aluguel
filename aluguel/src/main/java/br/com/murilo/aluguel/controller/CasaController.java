package br.com.murilo.aluguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.aluguel.data.vo.CasaVO;
import br.com.murilo.aluguel.service.CasaService;

@RestController
@RequestMapping("/api/v1/proprietario")
public class CasaController {

	@Autowired
	private CasaService service;

	@GetMapping("/{id}/casas")
	public ResponseEntity<List<CasaVO>> findCasasByProprietario(@PathVariable(value = "id") Long id) {
		List<CasaVO> casas = service.findCasaByProprietario(id);
		return (casas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(casas, HttpStatus.OK));
	}
}
