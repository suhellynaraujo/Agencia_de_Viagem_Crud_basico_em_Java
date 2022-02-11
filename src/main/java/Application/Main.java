package Application;
import java.util.Scanner;
import Program.Program_Contato;
import Program.Program_Destino;
import Program.Program_Login;
import Program.Program_Pessoas;

public class Main {
	public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);        
		Boolean opcao = true;
		do {
			System.out.println("------------ Bem Vindo ------------");
			System.out.println("- Escolha uma das opções abaixo: -");		
			System.out.println("1 - Cadastro");
			System.out.println("2 - Contato");
			System.out.println("3 - Destino");
			System.out.println("4 - Login");
			System.out.println("5 - Sair");
			
			int op = entrada.nextInt();			
			Program_Pessoas pessoas = new Program_Pessoas();
			Program_Destino destino = new Program_Destino();
			Program_Contato contato = new Program_Contato();
			Program_Login login = new  Program_Login();
			
			
			switch (op) {			
			case 1:				
				pessoas.Menu();				
				break;
			case 2:			
				contato.Menu();				
				break;	
			case 3:				
				destino.Menu();				
				break;
			case 4:				
				login.Menu();				
				break;
			case 5:				
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("|Agência de Viagens Súh FullStack agradece pela Preferência, volte sempre!|");
				System.out.println("---------------------------------------------------------------------------");
				System.exit(op);
				break;
			default: System.out.println("Opçção inválida!");
				break;
			}
		} while (opcao);
	}
	
	
	
	}


