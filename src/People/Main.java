package People;

//Imports.
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

	public static void showArray(String[] array) {
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("");
		
	}
	
	public static void read(String fileName, String[] array) throws IOException {
		
		//Variables.
		BufferedReader 	in 			= null;
		File 			nameFile 	= new File("files/" + fileName + ".txt");
		String			buffer;
		int				position	= 0;
		
		try {
			
			if(nameFile.exists()) {
				in = new BufferedReader(new FileReader(nameFile));
				
				while((buffer = in.readLine()) != null && position < array.length) {
					array[position] = buffer;
					position++;
				}
			} else {
				System.out.println("Error: El fichero no existe.");
			}
			
		} finally {
		
			if(in != null) {
	            in.close();
	        }

		}
			
	}
	
	public static void writePeople(String[] array) {
		
		showArray(array);
		
		//Variables.
		Scanner scan 		= new Scanner(System.in);
		int 	position 	= 0;
		String 	respuesta 	= "";
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				position = i;
				break;
			}
		}
		
		for(int k = position; k < array.length; k++) {
			
			System.out.printf("¿Quieres escribir un nombre? (s/n): ");
			respuesta = scan.next();
			
			if(respuesta.compareTo("n") == 0) {
				break;
			} else {
				if(position == (array.length - 1)) {
					System.out.printf("Introduce un nombre: ");
					array[k] = scan.next();
					
					showArray(array);
				} else {
					System.out.println("Error: El array está lleno.");
				}
			}
			
		}
		
	}
	
	public static void write(String fileName, String[] array) throws IOException {
		
		//Variables.
		PrintWriter out 		= null;
		File 		nameFile 	= new File("files/" + fileName + ".txt");
		int			position	= 0;
		
		if(!nameFile.exists()) {
			nameFile.createNewFile();
		}
		
		try {
			out = new PrintWriter(new FileWriter(nameFile));
			
			while(array[position] != null) {
				out.println(array[position]);
				
				
				if(position == (array.length - 1)) {
					break;
				}
				position++;
			}
			
		} finally {
			
			if(out != null) {
				out.close();
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		//Variables.
		String[] array = new String[5];
		
		read("people", array);
		writePeople(array);
		write("people2", array);

	}

}
