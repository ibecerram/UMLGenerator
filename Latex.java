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
			/*if(!file.exists())
			{
				file.createNewFile();
				System.out.println("Archivo creando");
			}*/

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(uml.encabezadoDocumento());
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al crear archivo latex");
		}
	}

	public void escribir()
	{
		int x = 0, y = 0;
		int contador = 1;
		try
		{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			for(Clase clase : listaClases)
			{
				if(contador >= 4)
				{
					y += 10;
					contador = 1;
					x = 0;
				}
				bw.write(uml.crearClase(clase, x, y));
				x += 10;
				contador++;
				bw.newLine();
			}
			bw.write(uml.finalizarDocumento());
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir latex");
		}

	}
}

/*
https://geekytheory.com/como-crear-y-modificar-ficheros-con-java
https://beginnersbook.com/2014/01/how-to-append-to-a-file-in-java/
https://www.journaldev.com/881/java-append-to-file
https://www.baeldung.com/java-append-to-file
*/

//AGREGAR ZOO//EMPLEADOS//ANIMALES