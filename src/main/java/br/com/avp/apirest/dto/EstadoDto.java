package br.com.avp.apirest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;

import br.com.avp.apirest.config.validacao.ErroDeValidacaoHandler;
import br.com.avp.apirest.modelo.Estado;

public class EstadoDto {

	private Long id;
	private String nome;
	private int populacao;
	private int area;
	private String regiao;
	private MethodArgumentNotValidException exception;
	ErroDeValidacaoHandler ev = new ErroDeValidacaoHandler();

	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.populacao = estado.getPopulacao();
		this.area = estado.getArea();
		this.regiao = estado.getRegiao();
	}

	public String getRegiao() {

		switch (regiao) {
		case ("Sul"):
			break;
		case ("Norte"):
			break;
		case ("Sudeste"):
			break;
		case ("Nordeste"):
			break;
		case ("Centro-Oeste"):
			break;
		case ("sul"):
			regiao = "Sul";
			break;
		case ("norte"):
			regiao = "Norte";
			break;
		case ("nordeste"):
			regiao = "Nordeste";
			break;
		case ("sudeste"):
			regiao = "Sudeste";
			break;
		case ("centro-oeste"):
			regiao = "Centro-Oeste";
			break;
		default:
			ev.handle(exception);
			break;
		}
		return regiao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public int getArea() {
		return area;
	}

	public static List<EstadoDto> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
		
	
	}

}
