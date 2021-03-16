import java.util.*;

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

		Latex latex = new Latex("prueba", listaClases);
		latex.crearArchivo();
		latex.escribir();
	}

	//Encontrar varios ejemplos como .h para que funcione
	//PROBAR CON HERENCIA (un metodo que analice la linea de nombre y que:
		//Si encuentra un : que entonces Hay herencia y la primera parte es la hija
		//Y la 2da es el padre
	//Ver cómo se crea una clase con tikz uml
	//Ver cómo se hacen las relaciones en tikzuml
	//Hacer una ArrayList de Clases
	//Probar con varios archivos
	//Ver cómo lo vamos a realizar
	//Preguntarle a Leo cómo le hará su equipo
}