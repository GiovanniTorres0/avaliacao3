package br.com.avp.apirest.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estado {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int populacao;
	private int area;
	private String regiao;

	public Estado() {
		
	}
	
	public Estado(String nome,int populacao,int area, String regiao) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.area = area;
	}


	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
			return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


}


