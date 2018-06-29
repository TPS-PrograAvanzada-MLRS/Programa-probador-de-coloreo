package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		ProbadorDeColoreo ppc = new ProbadorDeColoreo();
		
		try {
			System.out.println(ppc.verificarColoreo("datos\\grafo.in", "datos\\coloreado.out"));
		} catch (FileNotFoundException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}

	}

}
