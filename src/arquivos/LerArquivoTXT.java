package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTXT {

	public static void main(String[] args) throws FileNotFoundException {
		// entrada de dados
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivos.csv"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

		//criando a lista de pessoas
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();

			// verifica as se tem linha em branco
			if (linha != null && !linha.isEmpty()) {
				//criando um array para receber os dados
				String[] dados = linha.split("\\;");
				
				//criando o objeto pessoa
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);//adiciona na listas
			}
		}
		
		//percorrendo a lista, gravar no bd, mandar email etc...
		for (Pessoa p: pessoas) {
			System.out.println(p);
		}
	}

}
