package Program;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Connection.Conexao;
import model.Contato;

public class Program_Contato {

	public void create()  {
		Scanner entrada = new Scanner(System.in);

		String sql = "INSERT INTO Contato (Nome, Email, Mensagem, Id_Cadastro) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		Contato contato = new Contato();

		System.out.println("--------- Faça seu Contato ---------");
		System.out.println("Nome Completo : ");
		contato.setNome(entrada.nextLine());
		System.out.println("Email: ");
		contato.setEmail(entrada.nextLine());
		System.out.println("Digite uma breve Mensagem: ");
		contato.setMensagem(entrada.nextLine());
		System.out.println("Id do seu Cadastro:");
		contato.setId_Cadastro(entrada.nextInt());


		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getMensagem());
			pstm.setInt(4, contato.getId_Cadastro());
			

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

	
	public List<Contato> getRead() {

		String sql = "SELECT * FROM Contato";

		List<Contato> Contatos = new ArrayList<Contato>();

		Connection conn = null;
		PreparedStatement pstm = null;
		

		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = conn.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while ( rset.next()) {

				Contato contato = new Contato();

				contato.setId_Contato(rset.getInt("Id_Contato"));					
				System.out.println("Nome: " + rset.getString("Nome") + ", Email: " + rset.getString("Email")
				 + ", Mensagem: " + rset.getString("Mensagem") + ", Id_Cadastro: " + rset.getInt("Id_Cadastro"));
				Contatos.add(contato);
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
		return Contatos;
	}

	public void update() {

		Scanner entrada = new Scanner(System.in);

		String sql = "UPDATE Contato SET Nome = ? , Email = ?, Mensagem = ?, Id_Cadastro = ?  WHERE Id_Contato = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;

		Contato contato = new Contato();

		System.out.println("--------- Atualize seus Dados ---------");
		System.out.println("Id_Contato: ");
		contato.setId_Contato(entrada.nextInt());
		entrada.next();
		System.out.println("Nome: ");
		contato.setNome(entrada.nextLine());
		System.out.println("Email: ");
		contato.setEmail(entrada.nextLine());
		System.out.println("Mensagem: ");
		contato.setMensagem(entrada.nextLine());
		System.out.println("Id_Cadastro: ");
		contato.setId_Cadastro(entrada.nextInt());
		
		
		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getMensagem());
			pstm.setInt(4, contato.getId_Cadastro());
			pstm.setInt(5, contato.getId_Contato());


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

		String sql = "DELETE FROM Contato WHERE Id_Contato = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		Contato contato = new Contato();
		
		System.out.println("Digite o id do Contato");
		contato.setId_Contato(entrada.nextInt());
		
		try {
			conn = Conexao.CreateConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, contato.getId_Contato());

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
			Program_Contato contato = new Program_Contato();

			switch (op) {
			case 1:
				contato.create();
				break;
			case 2:
				contato.getRead();
				break;
			case 3:
				contato.update();
				break;
			case 4:
				contato.delete();
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
