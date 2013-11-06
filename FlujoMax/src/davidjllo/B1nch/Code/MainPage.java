package davidjllo.B1nch.Code;

import java.awt.font.NumericShaper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.io.File;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

public class MainPage {
	static int numAristas;
	private static MainScreen window;
	static String[] datos;
	static int[][] matrizAdj;
	static int i = 0;
	static int et;
	static String numero;
	private static Scanner leerDatos;

	public static void main(String[] args) {

		MainPage mainpage = new MainPage();
		openCodesFile();
		closeCodesFile();
		
		// Hay que cuadrar la funcion de flujoMax para que encuentre el estado inicial y el final, o que los saque de la matriz Adj
		
		et = flujoMax(matrizAdj,0,5);
		System.out.println(et);
		try {
			MainScreen window = new MainScreen(matrizAdj,numAristas);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static void openCodesFile() {
        try {
            leerDatos = new Scanner(new File("C:/Users/Binch/Dropbox/Eclipse/FlujoMax/src/datos.txt"));
            
        } catch (Exception e) {
            System.out.println("Datos no encontrados!");
        }
        readCodesFile();
    }
	public static void readCodesFile() {
    	String x= leerDatos.nextLine();
    	numAristas = Integer.parseInt(x);
    	datos = new String [Integer.parseInt(x)];
        while(leerDatos.hasNext()) {
            datos[i] = leerDatos.nextLine();
            System.out.println(datos[i]);
            i++; 
        }
        matrizAdj= new int[numAristas][numAristas];
        for(int xx=0; xx<numAristas; xx++){
        	for(int yy=0; yy<numAristas; yy++){
            	matrizAdj[xx][yy]=0;
            }
        }
        
		for(int j=0; j<numAristas; j++){
			matrizAdj[Integer.parseInt(datos[j].substring(0,1))-1] [Integer.parseInt(datos[j].substring(2,3))-1] = Integer.parseInt(datos[j].substring(4));
		}
	
		
		
    }

    public static void closeCodesFile() {
        leerDatos.close();
   
    }
	
	
	
	 // la entrada s es el estado inicial, y el t el final.
	// este metodo se encarga de detectar si hay algun camino desde
	// la fuente hasta el destino.

    static boolean relaciones(int[][] gRel, int s, int t, int[] padre) {
		boolean visitado[] = new boolean[numAristas];
		for (boolean x : visitado) {
			x = false;
		}
		Queue<Integer> lista = new LinkedList<Integer>();
		lista.add(s);
		visitado[s] = true;
		padre[s] = -1;

		while (!lista.isEmpty()) {
			int actual = lista.poll();

			for (int vis = 0; vis < numAristas; vis++) {
				if (visitado[vis] == false && gRel[actual][vis] > 0) {
					lista.add(vis);
					padre[vis] = actual;
					visitado[vis] = true;
				}
			}

		}
		return (visitado[t] == true);
	}

	 // Este metodo de flujo maximo se creo a partir del algoritmo
	// de Ford Fulkerson, este retorna el flujo maximo partiendo de
	// el estado inicial s hasta el final t.

	static int flujoMax(int[][] gRel, int s, int t) {
		int x, y;
		int flujoMax = 0;
		// la matriz Residuos se encarga de guardar los restantes
		int[][] Residuos = new int[numAristas][numAristas];

		for (x = 0; x < numAristas; x++) {
			for (y = 0; y < numAristas; y++) {
				Residuos[x][y] = gRel[x][y];
			}
		}
		// el dato padre guarda los recorridos y se le pasa
		// a la funcion relaciones.
		int[] padre = new int[numAristas];

		while (relaciones(Residuos, s, t, padre)) {
			// Se encontrara ahora el flujo Maximo por un solo camino
			// dado en el metodo relaciones.
			int flujoCamino = 99;
			for (y = t; y != s; y = padre[y]) {
				x = padre[y];
				if (flujoCamino > Residuos[x][y])
					flujoCamino = Residuos[x][y];
			}
			// ahora hay que recomputar las capacidades restantes

			for (y = t; y != s; y = padre[y]) {
				x = padre[y];
				Residuos[x][y] -= flujoCamino;
				Residuos[y][x] += flujoCamino;
			}
			flujoMax += flujoCamino;
		}
		return flujoMax;
	}
}
