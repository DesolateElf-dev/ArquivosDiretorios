package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController{

	public ArquivosController() {
		super();
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) { //verifica se existe e verifica se � um diret�rio
			File[] files = dir.listFiles(); //retorna um vetor com as files
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("     \t"+f.getName());
				} else {
					System.out.println("<DIR>\t"+f.getName());
				}
			}
		} else {
			throw new IOException("Diret�rio inv�lido");
		}
		
	}

	@Override
	public void createFile(String path, String name) throws IOException {
		File dir = new File(path); //caminho do diret�rio
		//File arq = new File(path, name + ".txt"); //cria o arquivo no diret�rio 'path' com o nome 'name' formato .txt
		File arq = new File(path, name); //se quiser criar arquivo .csv
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) { //verifica se diret�rio existe
				existe = true; //verifica se arquivo existe
			}
			String conteudo = geraTxt(); //gera o texto
			FileWriter fileWriter = new FileWriter(arq, existe); //cria o arquivo
			PrintWriter print = new PrintWriter(fileWriter); //abre o arquivo e define o tipo de opera��o de escrita
			print.write(conteudo); //inicia a vari�vel de fazer a escrita e faz a escrita
			print.flush();
			print.close();
			fileWriter.close(); //fecha o arquivo
		} else {
			throw new IOException("Diret�rio Inv�lido");
		}
		
	}

	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (!linha.equalsIgnoreCase("fim")) { //enquanto a linha n�o for "fim" fa�a
			linha = JOptionPane.showInputDialog(null,"Digite uma frase (digite 'fim' para terminar)",
					"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha+"\r\n");
			}
		}
		return buffer.toString();
	}

	@Override
	public void readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) { //verifica se existe e verifica se � um diret�rio
			FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); //l� o arquivo
			BufferedReader buffer = new BufferedReader(leitor); //converte o arquivo
			String linha = buffer.readLine(); //coloca o arquivo no buffer
			//faz as opera��es
			while (linha != null) { //procura EOF (fim do arquivo)
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close(); //fecha o arquivo
			
		} else {
			throw new IOException("Arquivo inv�lido");
		}
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inv�lido");
		}
		
	}
	
	
/*
	private int id;
	//ctrl + 3 "contructor" (cria o contrutor) 

	public ArquivosController(int id) {
		this.id = id;
	}
*/
	
}
