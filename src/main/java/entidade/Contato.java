package entidade;

public class Contato {
	private String email;
	private String telefone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Contato contatoEntrada = (Contato)obj;
		
		if(this.email.equalsIgnoreCase(contatoEntrada.getEmail())
			|| this.telefone.equals(contatoEntrada.getTelefone())) {
			return true;
		}else {
			return false;
		}
		
	}
}
