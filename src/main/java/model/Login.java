package model;

public class Login {

	private Integer Id_Entrar;
	private String Nome;
	private String Email;
	private Integer Senha;
	private Integer Id_Cadastro;
	
	public Login() {
		
	}
	public Login(String nome, String email, Integer senha, Integer id_Cadastro) {
		super();
		this.Nome = nome;
		this.Email = email;
		this.Senha = senha;
		this.Id_Cadastro = id_Cadastro;
	}
	
	public Integer getId_Entrar() {
		return Id_Entrar;
	}

	public void setId_Entrar(Integer id_Entrar) {
		this.Id_Entrar = id_Entrar;
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

	public Integer getId_Cadastro() {
		return this.Id_Cadastro;
	}

	public void setId_Cadastro(Integer id_Cadastro) {
		this.Id_Cadastro = id_Cadastro;
	}
	@Override
	public String toString() {
		return "Login [Id_Entrar=" + Id_Entrar + ", Nome=" + Nome + ", Email=" + Email + ", Senha=" + Senha
				+ ", Id_Cadastro=" + Id_Cadastro + "]";
	}

	
	
	
}
