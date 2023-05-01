package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException{

		File file = new File("C:\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivos_excel.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

		// criando objeto
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

		// Lista pode vir do banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		// adicona na lista de pessoas
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		// biblioteca do apachepoi
		// vair ser usado para escrever a planilha
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		// cria a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas!");

		// varrer a lista de pessoas com foreach

		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			// cria a linha
			Row linha = linhasPessoa.createRow(numeroLinha++);

			// cria a celula
			int celula = 0;

			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());

			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());

			Cell celIdade = linha.createCell(celula++);
			celIdade.setCellValue(p.getIdade());

		} // termino da mantagem da planilha

		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);// escreve a planilha no arquivo
		saida.flush();
		saida.close();

		System.out.println("Planilha criada");
	}

}
