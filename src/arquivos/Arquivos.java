package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		//criando objeto
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(44);
		pessoa1.setNome("Juca da silva");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(32);
		pessoa2.setNome("Maria da silva");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(12);
		pessoa3.setNome("João da silva");
		
		
		//Lista pode vir do banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		//instancia o arquivo
		File arquivo = new File("C:\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivos.csv");
		
		//se nao existe cria um novo
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		//instancia o objeto que escreve no arquivo
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		
		//escrever_no_arquivo.write("Busca o objeto pessoa e mostra os dados da lista\n\n");
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n\n");
		}
		
		
//		escrever_no_arquivo.write("Percorre os dados no arquivo\n\n");
//		for(int i = 1; i <= 10; i++) {
//			escrever_no_arquivo.write("Texto da linha " + i + "\n");
//		}
//		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
		
		
		
	}

}
