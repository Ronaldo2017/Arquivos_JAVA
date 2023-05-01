package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws IOException {
		FileInputStream entrada = new FileInputStream(
				new File("C:\\\\eclipse-workspace\\\\Arquivos\\\\src\\\\arquivos\\\\arquivos_excel.xls"));

		// prepara a entrada do arquivo excel para ler
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		// pega a primeira planilha do nosso arquivo excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

		// percorre as linhas
		Iterator<Row> linhaIterator = planilha.iterator();

		// percorrer a tabela do excel, colocando na lista de pessoas
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (linhaIterator.hasNext())// enquanto tiver linha no arquivo excel
		{
			Row linha = linhaIterator.next();// dados da pessoa na linha
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celulas.hasNext()) {//percorre as celulas
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}//final das celulas da linha
				
				//adiciona na lista
				pessoas.add(pessoa);
			}
			
			entrada.close();//terminou de ler o arquivo excel
			
			for (Pessoa p : pessoas) {
				System.out.println(p);
			}
			

		}

	}
}
