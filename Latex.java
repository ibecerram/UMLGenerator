import java.io.*;
import java.util.*;

public class Latex
{
	private String nombre;
	private File file;
	private Uml uml = new Uml();
	private ArrayList<Clase> listaClases = new ArrayList<>();
	private ArrayList<String> listaComposiciones = new ArrayList<>();

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
			//bw.write(uml.finalizarDocumento());
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir latex");
		}

		this.escribirRelaciones();
		this.escribirComposiciones();
	}

	public void escribirRelaciones()
	{
		//this.listaComposiciones.clear();
		try
		{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			for(Clase clase : listaClases)
			{
				//System.out.println("Entra");
				//System.out.println("Herencia: " + clase.getHerencia());
				if(!clase.getHerencia().isEmpty())
				{
					//System.out.println("Entra aqui en herencia");
					bw.write(uml.crearHerencia(clase.getNombre(), clase.getHerencia()));
					bw.newLine();
				}
			}

			/*for(Clase clase : listaClases)
			{
				this.listaComposiciones.addAll(clase.getComposiciones());
				for(String composicion : listaComposiciones)
				{
					System.out.println("Hay una composicion");
					bw.write(uml.crearHerencia(clase.getNombre(), composicion));
					bw.newLine();
				}
				this.listaComposiciones.clear();
				System.out.println("Entro a una clase");
			}*/

			//System.out.println("Saliendo...");
			//bw.write(uml.finalizarDocumento());
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir en Relaciones");
			e.printStackTrace();
		}
	}

	public void escribirComposiciones()
	{
		try
		{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			for(Clase clase : listaClases)
			{
				this.listaComposiciones.addAll(clase.getComposiciones());
				for(String composicion : listaComposiciones)
				{
					boolean bandera = false;
					for(Clase buscarClase : listaClases)
					{
						if(buscarClase.getNombre().equals(composicion))
						{
							bandera = true;
						}
					}

					if(bandera)
					{
						//System.out.println("Si entra");
						bw.write(uml.crearComposicion(clase.getNombre(), composicion));
					}
					else
					{
						System.out.println("\nERROR: La clase contiene composiciones de clases que NO fueron encontradas. \nFavor de ingresar todos los archivos");
						System.out.println("El diagrama generar?? una composicion con la misma clase.");
						System.out.println("Le pedimos que agregue todos los archivos de C++ con extensi??n .cpp\n");
						bw.write(uml.crearComposicion(clase.getNombre(), clase.getNombre()));
					}
					//System.out.println("Hay una composicion" + clase.getNombre() +  "-" + composicion);
					
					bw.newLine();
				}
				this.listaComposiciones.clear();
				//System.out.println("Entro a una clase");
			}

			//System.out.println("\n <<<< GENERANDO ARCHIVO PDF... >>>>\n");
			bw.write(uml.finalizarDocumento());
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir en Relaciones");
			e.printStackTrace();
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