package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		String dirWin = "C:\\temp";//pasta que ele vai ler
		String path = "C:\\temp"; //pasta que ele vai ler e criar o arquivo
		//String name = "teste.csv"; //criar arquivo .csv
		//String name = "temp";
		String name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo com exten��o: ",
				"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			int opc=0;

			while(opc!=9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Ler diret�rio "+dirWin+"\n2- Cria Arquivo  \n3 - L� arquivos  \n4 - Abre arquivo  \n9 - Finalizar"));
				switch (opc){
		    		case 1: arqCont.readDir(dirWin);
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
		    		default: JOptionPane.showMessageDialog(null,"Inv�lido");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
