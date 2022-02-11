package model;
public class Cadastro_Pessoas {
	private Integer Id_Cadastro;
	private String Nome;
	private String Email;
	private Integer Senha;

	public Cadastro_Pessoas() {

	}

	public Cadastro_Pessoas(String nome, String email, Integer senha) {
		this.Nome = nome;
		this.Email = email;
		this.Senha = senha;

	}

	public Integer getId_Cadastro() {
		return this.Id_Cadastro;
	}

	public void setId_Cadastro(Integer id_Cadastro) {
		this.Id_Cadastro = id_Cadastro;
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

	public Integer getSenha() {
		return this.Senha;
	}

	public void setSenha(Integer senha) {
		this.Senha = senha;
	}
	
	
}
	