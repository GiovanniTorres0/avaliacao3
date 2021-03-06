package br.com.avp.apirest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.MethodArgumentNotValidException;
import br.com.avp.apirest.config.validacao.ErroDeValidacaoHandler;
import br.com.avp.apirest.modelo.Estado;
import br.com.avp.apirest.repository.EstadoRepository;

public class EstadoForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	@Length(max = 12)
	private String regiao;
	@NotNull 
	private int populacao;
	@NotNull 
	private int area;
	protected MethodArgumentNotValidException exception;
	ErroDeValidacaoHandler ev = new ErroDeValidacaoHandler();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		AllStates es = new AllStates();
		es.teste(nome);
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
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
		this.regiao = regiao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPopulacao() {
		return populacao;
	}

	public MethodArgumentNotValidException getException() {
		return exception;
	}

	public int getArea() {
		return area;
	}

	public Estado converter(EstadoRepository estadoRepository) {
		return new Estado(nome, populacao, area, regiao);
	}
		
		public Estado atualizar(Long id, EstadoRepository estadoRepository) {
			Estado estado = estadoRepository.getOne(id);
			estado.setNome(this.nome);
			estado.setRegiao(this.regiao);
			estado.setArea(this.area);
			estado.setPopulacao(this.populacao);
			return estado;
		}
	}


