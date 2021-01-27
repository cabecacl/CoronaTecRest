package entidade;

import java.util.List;

public class Cliente {
	private String cpf;
	private String nome;
	private int idade;
	private String interesses;
	private List<Contato> listaContatos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	@Override
	public boolean equals(Object obj) {
		
		Cliente clienteEntrada = (Cliente)obj;
		
		if(this.cpf.equals(clienteEntrada.getCpf())) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
