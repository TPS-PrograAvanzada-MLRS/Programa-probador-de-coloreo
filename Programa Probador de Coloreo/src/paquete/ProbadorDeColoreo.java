package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProbadorDeColoreo {

	public boolean verificarColoreo(String entrada, String salida) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));
		Scanner out = new Scanner(new File(salida));

		String[] linea = out.nextLine().split(" ");
		int cantidadNodos = Integer.parseInt(linea[0]);
		int[] coloreo = new int[cantidadNodos];
		boolean[] fueColoreado = new boolean[cantidadNodos];

		int nodosColoreados = 0;

		while (out.hasNextLine()) {
			int nodo = out.nextInt();
			int color = out.nextInt();
			if (fueColoreado[nodo] == false) {
				fueColoreado[nodo] = true;
				coloreo[nodo] = color;
				nodosColoreados++;
			} else {
				System.out.println("Nodo coloreado mas de una vez");
				in.close();
				out.close();
				return false;
			}
		}

		if (nodosColoreados !=  cantidadNodos) {
			System.out.println("No fueron coloreados todos los nodos");
			in.close();
			out.close();
			return false;
		}

		linea = in.nextLine().split(" ");
		int cantidadAristas = Integer.parseInt(linea[1]);
		boolean coloreoCorrecto = true;
		for (int i = 0; i < cantidadAristas && coloreoCorrecto; i++) {
			int origen = in.nextInt();
			int destino = in.nextInt();
			
			if( coloreo[origen] == coloreo[destino] )
				coloreoCorrecto = false;
		}
		
		if(coloreoCorrecto == false)
			System.out.println("Dos nodos adyacentes tienen el mismo color");
		in.close();
		out.close();
		return coloreoCorrecto;

	}

}
