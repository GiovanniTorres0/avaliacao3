package br.com.avp.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.avp.apirest.config.validacao.ErroDeValidacaoHandler;
import br.com.avp.apirest.dto.EstadoDto;
import br.com.avp.apirest.form.EstadoForm;
import br.com.avp.apirest.modelo.Estado;
import br.com.avp.apirest.repository.EstadoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/states")
public class EstadoController {

	ErroDeValidacaoHandler ev = new ErroDeValidacaoHandler();

	
	@Autowired
	private EstadoRepository estadoRepository;

	@ApiOperation(value = "Obtém um Estado por Regiao", notes = "Obtém um Estado por Regiao")
	@ApiResponses({ @ApiResponse(code = 200, message = "Existe um Estado por Regiao") })
	@GetMapping
	public List<EstadoDto> lista(String regiao) {
		if (regiao == null) {
			List<Estado> estados = estadoRepository.findAll();
			return EstadoDto.converter(estados);

		} else {
			List<Estado> estados = estadoRepository.findByRegiao(regiao);
			return EstadoDto.converter(estados);

		}
	}
	
		
	
	@ApiOperation(value = "Insere um estado", notes = "Insere um Estado", response = EstadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Inclusão com sucesso de uma avaliação") })
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder) {

		Estado estado = form.converter(estadoRepository);
		estadoRepository.save(estado);

		URI uri = uriBuilder.path("api/states/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));

	}

	@ApiOperation(value = "Obtém um Estado por Id", notes = "Obtém um Estado por Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Existe um Estado") })
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> detalhar(@PathVariable long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			return ResponseEntity.ok(new EstadoDto(estado.get()));
		}
		return ResponseEntity.notFound().build();
	}

	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid EstadoForm form) {
		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			Estado estado = form.atualizar(id, estadoRepository);
			return ResponseEntity.ok(new EstadoDto(estado));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Exclui um Estado", notes = "Exclui um Estado")
	@ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de um Estado") })
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}




