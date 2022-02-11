package model;

public class Contato {
	private Integer Id_Contato;
	private String Nome;
	private String Email;
	private String Mensagem;
	private Integer Id_Cadastro;
	
	public Contato() {
	}
	

	public Contato(String nome, String email, String mensagem, Integer id_Cadastro) {
		
		this.Nome = nome;
		this.Email = email;
		this.Mensagem = mensagem;
		this.Id_Cadastro = id_Cadastro;
	}



	public Integer getId_Contato() {
		return this.Id_Contato;
	}

	public void setId_Contato(Integer id_Contato) {
		this.Id_Contato = id_Contato;
	}

	public String getNome() {
		return this.Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getMensagem() {
		return this.Mensagem;
	}

	public void setMensagem(String mensagem) {
		this.Mensagem = mensagem;
	}

	public Integer getId_Cadastro() {
		return this.Id_Cadastro;
	}

	public void setId_Cadastro(Integer id_Cadastro) {
		this.Id_Cadastro = id_Cadastro;
	}


	@Override
	public String toString() {
		return "Contato [Id_Contato=" + Id_Contato + ", Nome=" + Nome + ", Email=" + Email + ", Mensagem=" + Mensagem
				+ ", Id_Cadastro=" + Id_Cadastro + "]";
	}
	
	

}
