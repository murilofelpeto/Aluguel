package br.com.murilo.aluguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.aluguel.data.vo.CasaVO;
import br.com.murilo.aluguel.service.CasaService;

@RestController
@RequestMapping("/api/v1")
public class CasaController {

	@Autowired
	private CasaService service;

	@GetMapping("/proprietario/{id}/casas")
	public ResponseEntity<List<CasaVO>> findCasasByProprietario(@PathVariable(value = "id") Long id) {
		List<CasaVO> casas = service.findCasaByProprietario(id);
		return (casas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(casas, HttpStatus.OK));
	}
	
	@GetMapping("/casas/cep/{cep}")
	public CasaVO findByCep(@PathVariable(value = "cep")String cep) {
		return service.findByCEP(cep);
	}
	
	@PostMapping("/proprietario/{id}/casas")
	public ResponseEntity<CasaVO> salvarCasa(@PathVariable(value = "id")Long id, @RequestBody CasaVO casa){
		return new ResponseEntity<>(service.salvarCasa(id, casa), HttpStatus.CREATED);
	}
	
	@PutMapping("/proprietario/{id}/casas")
	public CasaVO update(@PathVariable(value = "id")Long idProprietario, @RequestBody CasaVO casa) {
		return service.atualizarCasa(idProprietario, casa);
	}
	
	@DeleteMapping("/casas/{id}")
	public void deletarCasa(@PathVariable(value = "id")Long id) {
		service.deleteCasa(id);
	}
}
