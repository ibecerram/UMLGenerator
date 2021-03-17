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
			System.out.println("\nTeclea el nombre del archivo con su extensión: ");
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
			System.out.println("\n¿Deseas leer otro archivo? 1 = SI.");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		/*for(Clase clase : listaClases)
		{
			clase.mostrarClase();
			System.out.println("----------------------------------------");
		}*/

		Latex latex = new Latex("diagramaClases", listaClases);
		latex.crearArchivo();
		latex.escribir();

		try
		{
			Process p = Runtime.getRuntime().exec("pdflatex diagramaClases.tex");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("\n <<<< GENERANDO ARCHIVO PDF... >>>>\n");

			p.waitFor();
		}
		catch(Exception e)
		{
			System.out.println("\n <<<< OCURRIÓ UN PROBLEMA AL GENERAR EL PDF >>>>\n");
			e.printStackTrace();
		}

		System.out.println("\n************************************************* \n");
		System.out.println("\n <<<< ¡DIAGRAMA GENERADO EXITOSAMENTE! >>>>\n");
		System.out.println("\n # Archivo diagramaClases.pdf creado en la carpeta actual #\n");
		
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