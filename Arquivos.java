package ManipulaçãoDeArquivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Arquivos {

	public static void main(String[] args) {
		Menu();
	}
	static void Menu() {
		while(2>1) {
			Scanner teclado = new Scanner(System.in);
			System.out.println("\n********(Sistema Solar)******** \n");
			System.out.println("1- Inserir nome de um planeta\n");
			System.out.println("2- Exibir todos os nomes dos planetas inseridos\n");
			System.out.println("3- Apagar todos o nomes inseridos\n");
			System.out.println("\n ---(Selecione a opção desejada)---\n");
			
			int op = teclado.nextInt();
			File arquivo = new File("NomesDosPlanetas.txt");
			
			/*Bloco try serve para tratamento de exceções, tratamento de códigos que 
			 * podem não ser totalmente atendidos e gerarem alguma exceção/erro. */
			
			try {
				if(!arquivo.exists()) {
					arquivo.createNewFile();
				}
				if(op==1) {
					FileWriter fw = new FileWriter(arquivo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					System.out.println("\n Digite o nome de um planeta: ");
					String y = teclado.next();
					bw.write(y);
					bw.newLine();
					bw.close();
					fw.close();
				try {
					TimeUnit.SECONDS.sleep(1);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				}
				else if(op==2) {
					FileReader fr = new FileReader(arquivo);
					BufferedReader br = new BufferedReader(fr);
					while (br.ready()) {
						String linha = br.readLine();
						System.out.println(linha);
					}
					br.close();
					fr.close();
					
					try {
						TimeUnit.SECONDS.sleep(3);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(op==3) {
					arquivo.delete();
					System.out.println("**Nomes dos planetas apagados com sucesso!!!**");
					
					try {TimeUnit.SECONDS.sleep(4);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Opção inválida, mas tente novamente com uma válida :)");
				}
					
			}catch(IOException ex) {
				ex.printStackTrace();
			}
					
		}		    
	}
}