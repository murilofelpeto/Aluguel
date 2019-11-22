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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.aluguel.dto.request.CasaRequest;
import br.com.murilo.aluguel.dto.response.CasaResponse;
import br.com.murilo.aluguel.facade.CasaFacade;

@RestController
@RequestMapping("/api/v1/casa")
public class CasaController {

	@Autowired
	private CasaFacade casaFacade;

	@GetMapping("/proprietario")
	public ResponseEntity<List<CasaResponse>> findCasasByProprietario(
			@RequestParam(name = "name", required = true) String name) {
		List<CasaResponse> casas = casaFacade.findCasaByProprietario(name);
		return (casas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(casas, HttpStatus.OK));
	}

	@GetMapping("/endereco/cep")
	public ResponseEntity<List<CasaResponse>> findByCep(@RequestParam(name = "cep", required = true) String cep) {
		List<CasaResponse> casas = casaFacade.findCasaByCep(cep);
		return (casas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(casas, HttpStatus.OK));
	}

	@PostMapping("/casas")
	public ResponseEntity<CasaResponse> salvarCasa(@RequestBody CasaRequest casa) {
		return new ResponseEntity<>(casaFacade.salvarCasa(casa), HttpStatus.CREATED);
	}

	@PutMapping("/casas/{id}")
	public ResponseEntity<CasaResponse> update(@PathVariable(value = "id") Long idCasa, @RequestBody CasaRequest casa) {
		return new ResponseEntity<>(casaFacade.atualizarCasa(idCasa, casa), HttpStatus.OK);
	}

	@DeleteMapping("/casas/{id}")
	public void deletarCasa(@PathVariable(value = "id") Long id) {
		casaFacade.deleteCasa(id);
	}
}
