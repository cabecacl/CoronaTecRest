package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entidade.RetornoCalculadora;

@Path("/calculadora")
public class Calculadora {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Funfando";
	}
	
	@GET
	@Path("/somar")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadora somar(@QueryParam("valor1") double valor1, 
						@QueryParam("valor2") double valor2) {
		RetornoCalculadora retorno = new RetornoCalculadora();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");
		retorno.setValorRetorno(valor1 + valor2); 
		return retorno;
	}
}
