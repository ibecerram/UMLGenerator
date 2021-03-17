import java.util.*;
import java.io.*;

public class main
{
	public static void main(String[] args) 
	{
		ArrayList<Clase> listaClases = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String nombreArchivo;

		int opcion = 1;
		while(opcion == 1)
		{
			System.out.println("Teclea el nombre del archivo con su extensión: ");
			nombreArchivo = sc.nextLine();
			Archivo archivo = new Archivo(nombreArchivo);
			//archivo.leer();
			archivo.analizar();
			/*archivo.buscarNombre();
			archivo.buscarMetodos();
			archivo.buscarVariables();*/
			//archivo.leer();
			listaClases.addAll(archivo.obtenerClase());
			//System.out.println("\n**************************************");

			/*Clase clase;
			clase = archivo.getClase();
			clase.mostrarClase();*/
			System.out.println("Deseas leer otro archivo? 1 = SI.");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		for(Clase clase : listaClases)
		{
			clase.mostrarClase();
			System.out.println("----------------------------------------");
		}

		Latex latex = new Latex("diagramaClases", listaClases);
		latex.crearArchivo();
		latex.escribir();

		try
		{
			Process p = Runtime.getRuntime().exec("pdflatex diagramaClases.tex");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			/*String line = "";
			while((line = reader.readLine()) != null)
			{
				System.out.println(line + "\n");
			}*/

			p.waitFor();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	//Falta HERENCIA************
	//Falta Composiciones******************
	//Probar comando para generar PDF
	//Ver CÖMO se acomoda en latex con tikz
	//Ver si se mete en un package o algo?????????????????????
	//Ver adornos de latex para que funcione
	//Faltan las relaciones
	//Las COORDENADAS desde donde empieza el diagrama para acomodar
	//Es desde la esquina inferior izquierda
}

//https://mkyong.com/java/how-to-execute-shell-command-from-java/

/*
1) CREAR RELACIONES DE HERENCIA
2) CREAR COMPOSICIONES
3) ADORNAR




*/