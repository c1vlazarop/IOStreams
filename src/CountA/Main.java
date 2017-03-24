package CountA;

//Imports.
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//Variables.
		FileInputStream in = null;
		BufferedReader inputStream = null;
		File name = new File("files/xanadu.txt");
		int countA = 0, countUpp = 0, countUpp2 = 0, buffer;
		String bufferLine;
		
		try {
			
			in = new FileInputStream(name);
			
			while((buffer = in.read()) != -1) {		
				if(buffer == 'A' || buffer == 'a') {
					countA++;
				}
				
				if(buffer >= 65 && buffer <= 90) {
					countUpp++;
				}
			}
			
			System.out.println("Hay un total de " + countA + " letras \"A\" en el fichero.");
			System.out.println("Hay un total de " + countUpp + " mayúsculas en el fichero.");
			
		} finally {
			
			if(in != null) {
				in.close();
			}
			
		}
		
		try {
			
			inputStream = new BufferedReader(new FileReader("files/xanadu.txt"));
			
			while((bufferLine = inputStream.readLine()) != null) {
				for(int i = 0; i < bufferLine.length(); i++) {
					if(bufferLine.charAt(i) >= 65 && bufferLine.charAt(i) <= 90) {
						countUpp2++;
					}
				}
			}
			
			System.out.println("Hay un total de " + countUpp2 + " mayúsculas en el fichero.");
			
		} finally {
			
			if (inputStream != null) {
				inputStream.close();
			}
			
		}
		
	}
	
}
