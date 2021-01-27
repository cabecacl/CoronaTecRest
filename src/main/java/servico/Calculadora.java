package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.TEXT_PLAIN)
	public String somar(@QueryParam("valor1") double valor1, 
						@QueryParam("valor2") double valor2) {
		return "Resultado: " + (valor1 + valor2);
	}
}
