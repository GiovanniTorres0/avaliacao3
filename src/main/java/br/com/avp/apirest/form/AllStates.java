package br.com.avp.apirest.form;

public class AllStates extends EstadoForm {

	String estado;

	public String teste(String estado) {

		
		switch (estado) {

		case "são paulo":
			estado = "São Paulo";
			break;
		case "rio grande do sul":
			estado = "Rio Grande do Sul";
			break;
		case "ceará":
			estado = "Ceará";
			break;
		case "santa catarina":
			estado = "Santa Catarina";
			break;
		case "pernambuco":
			estado = "Pernambuco";
			break;
		case "pará":
			estado = "Pará";
			break;
		case "amazonas":
			estado = "Amazonas";
			break;
		case "espirito santo":
			estado = "Espirito Santo";
			break;
		case "sergipe":
			estado = "Sergipe";
			break;
		case "maranhão":
			estado = "Maranhão";
			break;
		case "piauí":
			estado = "Piauí";
			break;
		case "rio grande do norte":
			estado = "Rio Grande do Norte";
			break;
		case "amapá":
			estado = "Amapá";
			break;
		case "alagoas":
			estado = "Alagoas";
			break;
		case "roraima":
			estado = "Roraima";
			break;
		case "mato grosso do sul":
			estado = "Mato Grosso do Sul";
			break;
		case "acre":
			estado = "Acre";
			break;
		case "rondônia":
			estado = "Rondônia";
			break;
		case "tocantins":
			estado = "Tocantins";
			break;

		case "São Paulo":
			break;
		case "Rio Grande do Sul":
			break;
		case "Ceará":
			break;
		case "Santa Catarina":
			break;
		case "Pernambuco":
			break;
		case "Pará":
			break;
		case "Amazonas":
			break;
		case "Espirito Santo":
			break;
		case "Sergipe":
			break;
		case "Maranhão":
			break;
		case "Piauí":
			break;
		case "Rio Grande do Norte":
			break;
		case "Amapá":
			break;
		case "Alagoas":
			break;
		case "Roraima":
			break;
		case "Mato Grosso do Sul":
			break;
		case "Acre":
			break;
		case "Rondônia":
			break;
		case "Tocantins":
			break;

		default:
			ev.handle(exception);
			break;
		}
		return estado;
	}

}
