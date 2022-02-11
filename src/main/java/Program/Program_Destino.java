package Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Connection.Conexao;
import model.Cadastro_Destino;

public class Program_Destino {

	public void create() {
		Scanner entrada = new Scanner(System.in);

		String sql = "INSERT INTO Destino(Nome_Destino, Cidade, Estado, Ida, Volta, Id_Cadastro) VALUES (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		Cadastro_Destino destino = new Cadastro_Destino();

		System.out.println("--------- Cadastre seu destino ---------");
		System.out.println("Nome do Destino : ");
		destino.setNome_Destino(entrada.nextLine());
		System.out.println("Cidade: ");
		destino.setCidade(entrada.nextLine());
		System.out.println("Estado: ");
		destino.setEstado(entrada.nextLine());
		System.out.println("Ida: ");
		destino.setIda(entrada.nextLine());
		System.out.println("Volta: ");
		destino.setVolta(entrada.nextLine());
		System.out.println("Id do seu Cadastro:");
		destino.setId_Cadastro(entrada.nextInt());

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome_Destino());
			pstm.setString(2, destino.getCidade());
			pstm.setString(3, destino.getEstado());
			pstm.setString(4, destino.getIda());
			pstm.setString(5, destino.getVolta());
			pstm.setInt(6, destino.getId_Cadastro());

			pstm.execute();

			System.out.println("---------- Cadastro Realizado com Sucesso! ----------");
			System.out.println("");

		} catch (Exception e) {
			System.out.println("Erro ao Cadastrar!" + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	public List<Cadastro_Destino> getRead() {

		String sql = "SELECT * FROM Destino";

		List<Cadastro_Destino> cadastros = new ArrayList<Cadastro_Destino>();

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while (rset.next()) {

				Cadastro_Destino destino = new Cadastro_Destino();

				destino.setId_Destino(rset.getInt("Id_Destino"));
				System.out.println("Nome: " + rset.getString("Nome_Destino") + ", Cidade: " + rset.getString("Cidade")
						+ ", Estado: " + rset.getString("Estado") + ", Ida:  " + rset.getString("Ida") + ", Volta: "
						+ rset.getString("Volta") + ", Id_Cadastro: " + rset.getInt("Id_Cadastro"));
				cadastros.add(destino);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cadastros;
	}

	public void update() {

		Scanner entrada = new Scanner(System.in);

		String sql = "UPDATE Destino SET Nome_Destino = ? , Cidade = ? , Estado = ?, Ida = ?,  Volta = ?, Id_Cadastro = ? WHERE Id_Destino = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;

		Cadastro_Destino destino = new Cadastro_Destino();

		System.out.println("--------- Cadastre seu destino ---------");
		System.out.println("Id do Destino: ");
		destino.setId_Destino(entrada.nextInt());
		entrada.nextLine();
		System.out.println("Nome do Destino : ");
		destino.setNome_Destino(entrada.nextLine());
		System.out.println("Cidade : ");
		destino.setCidade(entrada.nextLine());
		System.out.println("Estado : ");
		destino.setEstado(entrada.nextLine());
		System.out.println("Ida: ");
		destino.setIda(entrada.nextLine());
		System.out.println("Volta: ");
		destino.setVolta(entrada.nextLine());
		System.out.println("Id do seu Cadastro:");
		destino.setId_Cadastro(entrada.nextInt());

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(7, destino.getId_Destino());
			pstm.setString(1, destino.getNome_Destino());
			pstm.setString(2, destino.getCidade());
			pstm.setString(3, destino.getEstado());
			pstm.setString(4, destino.getIda());
			pstm.setString(5, destino.getVolta());
			pstm.setInt(6, destino.getId_Cadastro());

			pstm.execute();

			System.out.println("---------- Dados Atualizado com Sucesso! ----------");

			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Erro ao Atualizar! " + e.getMessage());
		}

	}

	public void delete() throws Exception {
		Scanner entrada = new Scanner(System.in);

		String sql = "DELETE FROM Destino WHERE Id_Destino = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		Cadastro_Destino destino = new Cadastro_Destino();

		System.out.println("--------- Deletar seus Dados ? ---------");
		System.out.println("Digite o Id do Destino");
		destino.setId_Destino(entrada.nextInt());

		try {
			conn = Conexao.CreateConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, destino.getId_Destino());
			pstm.execute();

			System.out.println("---------- Dados Excluidos com Sucesso! ----------");
			System.out.println("");

		} catch (SQLException e) {
			System.out.println("Erro ao Deletar os dados! " + e.getMessage());
		}
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Menu() throws Exception {
		Scanner entrada = new Scanner(System.in);
		Boolean opcao = true;

		do {
			System.out.println("--------------------------------------");
			System.out.println("--- Aqui você encontra seus dados. ---");
			System.out.println("O que deseja Realizar ?");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("5 - Sair");
			int op = entrada.nextInt();
			Program_Destino destino = new Program_Destino();

			switch (op) {
			case 1:
				destino.create();
				break;
			case 2:
				destino.getRead();				
				break;
			case 3:
				destino.update();
				break;
			case 4:
				destino.delete();
				break;
			case 5:
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("|Agência de Viagens Súh FullStack agradece pela Preferência, volte sempre!|");
				System.out.println("---------------------------------------------------------------------------");
				System.exit(op);
				break;
			default:
				System.out.println("Opçção inválida!");
				break;
			}
		} while (opcao);
	}
	
	
}
