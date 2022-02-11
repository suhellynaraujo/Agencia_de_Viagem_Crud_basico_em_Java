package Program;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import Connection.Conexao;
import model.Cadastro_Pessoas;

public class Program_Pessoas {

	public void create() {
		Scanner entrada = new Scanner(System.in);

		String sql = "INSERT INTO Cadastro VALUES (null, ?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		Cadastro_Pessoas pessoas = new Cadastro_Pessoas();

		System.out.println("--------- Faça seu Cadastro ---------");
		System.out.println("Nome Completo : ");
		pessoas.setNome(entrada.nextLine());
		System.out.println("Email: ");
		pessoas.setEmail(entrada.nextLine());
		System.out.println("Senha: ");
		pessoas.setSenha(entrada.nextInt());

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, pessoas.getNome());
			pstm.setString(2, pessoas.getEmail());
			pstm.setInt(3, pessoas.getSenha());

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


	public List<Cadastro_Pessoas> getRead() {

		String sql = "SELECT * FROM Cadastro";

		List<Cadastro_Pessoas> cadastros = new ArrayList<Cadastro_Pessoas>();

		Connection conn = null;
		PreparedStatement pstm = null;
		

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while ( rset.next()) {

				Cadastro_Pessoas pessoa = new Cadastro_Pessoas();

				pessoa.setId_Cadastro(rset.getInt("Id_Cadastro"));
				System.out.println("Nome: " + rset.getString("Nome") + ", Email: " + rset.getString("Email")
				+ ", Senha: " + rset.getString("Senha") + ", Id_Cadastro: " + rset.getInt("Id_Cadastro"));
			
				cadastros.add(pessoa);
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
	
		String sql =  "UPDATE Cadastro SET Nome = ? , Email = ?, Senha = ? WHERE Id_Cadastro = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		Cadastro_Pessoas pessoa = new Cadastro_Pessoas();

		System.out.println("--------- Atualize seus Dados ---------");
		System.out.println("Id_Cadastro: ");
		pessoa.setId_Cadastro(entrada.nextInt());
		entrada.nextLine();
		System.out.println("Nome Completo: ");
		pessoa.setNome(entrada.nextLine());
		System.out.println("Email: ");
		pessoa.setEmail(entrada.nextLine());
		System.out.println("Senha: ");
		pessoa.setSenha(entrada.nextInt());

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(4, pessoa.getId_Cadastro());
			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getEmail());
			pstm.setInt(3, pessoa.getSenha());

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

		String sql = "DELETE FROM Cadastro WHERE Id_Cadastro = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
	
		
		Cadastro_Pessoas pessoa = new Cadastro_Pessoas();

		System.out.println("--------- Deletar seus Dados ? ---------");
		System.out.println("Digite o id do Cadastro");
		pessoa.setId_Cadastro(entrada.nextInt());
		
		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, pessoa.getId_Cadastro());

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
			Program_Pessoas pessoas = new Program_Pessoas();

			switch (op) {
			case 1:
				pessoas.create();
				break;
			case 2:
				pessoas.getRead();
				break;
			case 3:
				pessoas.update();
				break;
			case 4:
				pessoas.delete();
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
