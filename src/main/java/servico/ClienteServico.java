package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;
import entidade.RetornoCliente;

@Path("/cliente")
public class ClienteServico {

	private ClienteDAO clienteDAO = new ClienteDAOImpl();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Serviço Cliente";
	}
	
	@POST
	@Path("/inserirCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente inserirCliente(Cliente cliente) {
		
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		
//		if(this.existe(cliente) == null) {
//			if(cliente.getListaContatos() == null) {
//				cliente.setListaContatos(new ArrayList<Contato>());
//			}
//			this.listaCliente.add(cliente);
//		}else {
//			retorno.setCodigoRetorno(1);
//			retorno.setMensagemRetorno("FALHA: Cliente já existe!!");
//		}
		
		if(clienteDAO.existeCliente(cliente) == null) {
			if(cliente.getListaContatos() != null && 
				cliente.getListaContatos().size() > 0) {
				for (Contato contato : cliente.getListaContatos()) {
					contato.setCliente(cliente);
				}
			}
			clienteDAO.inserirCliente(cliente);
		}else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Cliente já existe!!");
		}
		
		return retorno;
		
	}

	@GET
	@Path("/pesquisarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente pesquisarCliente(Cliente cliente) {
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		retorno.setListaCliente(clienteDAO.pesquisarCliente(cliente));
		
		return retorno;
	}

//	@Override
//	public RetornoCliente adicionarContatoCliente(Cliente cliente) {
//
//		RetornoCliente retorno = new RetornoCliente();
//		retorno.setCodigoRetorno(0);
//		retorno.setMensagemRetorno("SUCESSO!!!");
//		// 1 - verificar se existe o cliente na base
//		Cliente clienteBase = this.existe(cliente);
//		
//		if(clienteBase != null) {
//			//2 - Verificar se existe contatos para serem inseridos
//			if(cliente.getListaContatos() != null && 
//				cliente.getListaContatos().size() > 0) {
//				
//		// 3 - Verifica se existe contato ja inseridos na base --------
//				boolean existeContato = false;
//				for (Contato contatoEntrada : cliente.getListaContatos()) {
//					int index = clienteBase.getListaContatos().indexOf(contatoEntrada);
//					if(index != -1) {
//						existeContato = true;
//					}
//				}
//				
//			// 4 - Se existir contato manda o erro, senão, adiciona todos os contatos
//				if(existeContato) {
//					retorno.setCodigoRetorno(1);
//					retorno.setMensagemRetorno("FALHA: Contato já existente!!!");
//				} else {
//					clienteBase.getListaContatos().addAll(cliente.getListaContatos());
//				}
//
//			}else {
//				retorno.setCodigoRetorno(1);
//				retorno.setMensagemRetorno("FALHA: Não existe contato para adicionar!!!");
//			}
//		}else {
//			retorno.setCodigoRetorno(1);
//			retorno.setMensagemRetorno("FALHA: Cliente não existe!!");
//		}
//		
//		return retorno;
//	}
//
//	@Override
//	public RetornoCliente removerContatoCliente(Cliente cliente) {
//	
//		RetornoCliente retorno = new RetornoCliente();
//		retorno.setCodigoRetorno(0);
//		retorno.setMensagemRetorno("SUCESSO!!!");
//		// 1 - verificar se existe o cliente na base
//		Cliente clienteBase = this.existe(cliente);
//		
//		if(clienteBase != null) {
//			//2 - Verificar se existe contatos para serem inseridos
//			if(cliente.getListaContatos() != null && 
//				cliente.getListaContatos().size() > 0) {
//				
//				for (Contato contatoEntrada : cliente.getListaContatos()) {
//					int index = clienteBase.getListaContatos().indexOf(contatoEntrada);
//					if(index != -1) {
//						clienteBase.getListaContatos().remove(index);
//					}
//				}
//				
//			}else {
//				retorno.setCodigoRetorno(1);
//				retorno.setMensagemRetorno("FALHA: Não existe contato para remover!!!");
//			}
//		}else {
//			retorno.setCodigoRetorno(1);
//			retorno.setMensagemRetorno("FALHA: Cliente não existe!!");
//		}
//		
//		return retorno;	
//	}
//
//	
//	
//	
//	
//	@GET
//	@Path("/somar")
//	@Produces(MediaType.APPLICATION_JSON)
//	public RetornoCalculadora somar(@QueryParam("valor1") double valor1, 
//						@QueryParam("valor2") double valor2) {
//		RetornoCalculadora retorno = new RetornoCalculadora();
//		retorno.setCodigoRetorno(0);
//		retorno.setMensagemRetorno("SUCESSO!!");
//		retorno.setValorRetorno(valor1 + valor2); 
//		return retorno;
//	}
}
