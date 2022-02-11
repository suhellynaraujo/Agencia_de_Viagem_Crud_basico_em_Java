package Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connection.Conexao;
import model.Login;

public class Program_Login {
	public void create()  {
		Scanner entrada = new Scanner(System.in);

		String sql = "INSERT INTO Entrar ( Email, Senha, Id_Cadastro) VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		Login login = new Login();

		System.out.println("--------- Faça seu login ---------");
		System.out.println("Email: ");
		login.setEmail(entrada.nextLine());
		System.out.println("Senha: ");
		login.setSenha(entrada.nextInt());
		System.out.println("Id do seu Cadastro:");
		login.setId_Cadastro(entrada.nextInt());


		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, login.getEmail());
			pstm.setInt(2, login.getSenha());
			pstm.setInt(3, login.getId_Cadastro());
			

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

	
	public List<Login> getRead() {

		String sql = "SELECT * FROM Entrar";

		List<Login> logins = new ArrayList<Login>();

		Connection conn = null;
		PreparedStatement pstm = null;
		

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while ( rset.next()) {

				Login login = new Login();

				login.setId_Entrar(rset.getInt("Id_Entrar"));				
				System.out.println("Email: " + rset.getString("Email")
				 + ", Senha: " + rset.getString("Senha") + ", Id_Cadastro: " + rset.getInt("Id_Cadastro"));
				logins.add(login);
				
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
		return logins;
	}

	public void update() {

		Scanner entrada = new Scanner(System.in);

		String sql = "UPDATE Entrar SET Email = ?, Senha = ?, Id_Cadastro = ? WHERE Id_Entrar = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;

		Login login = new Login();

		System.out.println("--------- Atualize seus Dados ---------");
		System.out.println("Id_login: ");
		login.setId_Entrar(entrada.nextInt());	
		entrada.nextLine();
		System.out.println("Email: ");
		login.setEmail(entrada.nextLine());	
		System.out.println("Senha: ");
		login.setSenha(entrada.nextInt());
		System.out.println("Id do seu Cadastro:");
		login.setId_Cadastro(entrada.nextInt());
		
		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, login.getEmail());
			pstm.setInt(2, login.getSenha());
			pstm.setInt(3, login.getId_Cadastro());
			pstm.setInt(4, login.getId_Entrar());


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

		String sql = "DELETE FROM Entrar WHERE Id_Entrar = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		Login login = new Login();
		
		System.out.println("Digite o id do login");
		login.setId_Entrar(entrada.nextInt());
		
		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, login.getId_Entrar());

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
			Program_Login login = new Program_Login();

			switch (op) {
			case 1:
				login.create();
				break;
			case 2:
				login.getRead();
				break;
			case 3:
				login.update();
				break;
			case 4:
				login.delete();
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
