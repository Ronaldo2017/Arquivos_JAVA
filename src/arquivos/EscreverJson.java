package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreverJson {

	public static void main(String[] args) throws IOException {

		Usuario usuario1 = new Usuario();
		usuario1.setCpf("3454345899");
		usuario1.setSenha("1234");
		usuario1.setLogin("1234");

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("34543458935");
		usuario2.setSenha("12345");
		usuario2.setLogin("12354");

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		// organiza o formato da saida do json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String jsonUser = gson.toJson(usuarios);

		System.out.println(jsonUser);

		// escrever no arquivo
		FileWriter fileWriter = new FileWriter("C:\\eclipse-workspace\\Arquivos\\src\\arquivos\\filejson.json");

		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();

		/*
		 * SE TIVER PROBLEMAS COM ACENTUAÇÃO
		 * 
		 * FileOutputStream escrever_no_arquivo = new FileOutputStream(new
		 * FileOutputStream(arquivo), "UTF-8");
		 */

		// --------------------------LENDO O ARQUIVO ----------------------------
		FileReader fileReader = new FileReader("C:\\eclipse-workspace\\Arquivos\\src\\arquivos\\filejson.json");
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuarios.add(usuario);
		}
		System.out.println("Leitura do arquivo JSON: " + listaUsuarios);
	}

}
