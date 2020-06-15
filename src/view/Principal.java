package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		String path = JOptionPane.showInputDialog(null, "Digite o diretório de trabalho: ",
				"Entrada de texto", JOptionPane.INFORMATION_MESSAGE); //pasta que ele vai ler e criar o arquivo
		String name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo com extenção: ",
				"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			int opc=0;

			while(opc!=9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Ler diretório "+path+"\n2- Cria Arquivo  \n3 - Lê arquivos  \n4 - Abre arquivo  \n9 - Finalizar"));
				switch (opc){
		    		case 1: arqCont.readDir(path);
		    			break;
		    		case 2: arqCont.createFile(path, name);
		    			break;
		    		case 3: arqCont.readFile(path, name);
		    			break;	
		    		case 4: arqCont.openFile(path, name);
		    			break;
		    		case 9: {
		    			System.out.println("Programa Finalizado");
		    			System.exit(0);
		    		}
		    		default: JOptionPane.showMessageDialog(null,"Inválido");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
