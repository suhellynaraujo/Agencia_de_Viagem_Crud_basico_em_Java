package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia";
	private static String USER= "root";
	private static String PASSWORD = "02031989";
	
	public static Connection CreateConnectionToMySql() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL , USER, PASSWORD);
		
		return conexao;
		
	}
	
	
	public static void main(String[] args) throws Exception {
		Connection conexao = CreateConnectionToMySql();
		
		if (conexao !=null) {
			System.out.println("Conexão obtida com Sucesso!");
			
		}
		else {
			System.out.println("Erro ao Conectar!");
		}
	}

}
