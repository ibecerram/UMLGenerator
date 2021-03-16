import java.io.*;
import java.util.*;

public class Latex
{
	private String nombre;
	private File file;
	private Uml uml = new Uml();
	private ArrayList<Clase> listaClases = new ArrayList<>();

	public Latex(String nombre, ArrayList<Clase> listaClases)
	{
		this.nombre = nombre + ".tex";
		this.listaClases.addAll(listaClases);
	}

	public void crearArchivo()
	{
		try
		{
			file = new File(this.nombre);
			if(!file.exists())
			{
				file.createNewFile();
				System.out.println("Archivo creando");
			}

			/*FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("holaaaa");
			bw.close();*/
		}
		catch(Exception e)
		{
			System.out.println("Error al crear archivo latex");
		}
	}

	public void escribir()
	{
		try
		{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("prueba2");
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir latex");
		}

		//System.out.println("CREANDO CLASE: " + uml.crearClase("A"));

		for(Clase clase : listaClases)
		{
			//clase.mostrarClase();
			System.out.println(uml.crearClase(clase, 1, 2));
		}
	}
}

/*
https://geekytheory.com/como-crear-y-modificar-ficheros-con-java
https://beginnersbook.com/2014/01/how-to-append-to-a-file-in-java/
https://www.journaldev.com/881/java-append-to-file
https://www.baeldung.com/java-append-to-file
*/