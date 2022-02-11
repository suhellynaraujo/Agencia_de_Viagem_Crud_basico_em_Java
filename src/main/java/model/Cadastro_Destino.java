package model;
public class Cadastro_Destino {

	private Integer Id_Destino;
	private String Nome_Destino;
	private String Cidade;
	private String Estado;
	private String Ida;
	private String Volta;
	private Integer Id_Cadastro;
	
	
	public Cadastro_Destino() {
		
	}


	public Cadastro_Destino(String nome_Destino, String cidade, String estado, String ida, String volta) {
		this.Nome_Destino = nome_Destino;
		this.Cidade = cidade;
		this.Estado = estado;
		this.Ida = ida;
		this.Volta = volta;
	
	}


	public Integer getId_Destino() {
		return this.Id_Destino;
	}


	public void setId_Destino(Integer id_Destino) {
		this.Id_Destino = id_Destino;
	}


	public String getNome_Destino() {
		return this.Nome_Destino;
	}


	public void setNome_Destino(String nome_Destino) {
		this.Nome_Destino = nome_Destino;
	}


	public String getCidade() {
		return this.Cidade;
	}


	public void setCidade(String cidade) {
		this.Cidade = cidade;
	}


	public String getEstado() {
		return this.Estado;
	}


	public void setEstado(String estado) {
		this.Estado = estado;
	}


	public String getIda() {
		return this.Ida;
	}


	public void setIda(String ida) {
		this.Ida = ida;
	}


	public String getVolta() {
		return this.Volta;
	}


	public void setVolta(String volta) {
		this.Volta = volta;
	}


	public Integer getId_Cadastro() {
		return this.Id_Cadastro;
	}


	public void setId_Cadastro(Integer id_Cadastro) {
		this.Id_Cadastro = id_Cadastro;
	}

	@Override
	public String toString() {
		return "Cadastro_Destino [Id_Destino=" + Id_Destino + ", Nome_Destino=" + Nome_Destino + ", Cidade=" + Cidade
				+ ", Estado=" + Estado + ", Ida=" + Ida + ", Volta=" + Volta + ", Id_Cadastro=" + Id_Cadastro + "]";
	}



	
	
}
