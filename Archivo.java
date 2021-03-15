import java.io.*;
import java.util.*;

public class Archivo
{
	private String nombreArchivo;
	private ArrayList<Variable> listaVariables = new ArrayList<>();
	private ArrayList<Metodo> listaMetodos = new ArrayList<>();
	private ArrayList<String> clasesDisponibles = new ArrayList<>();
	private Clase clase;

	public Archivo(String nombreArchivo)
	{
		this.nombreArchivo = nombreArchivo;
	}

	public void leer(int limiteInferior, int limiteSuperior)
	{
		int n = 1;
		int linea;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();
				/*//System.out.println(lineaArchivo);
				if(lineaArchivo.contains("class"))
				{
					n++;
				}*/
				if(n >= limiteInferior && n<= limiteSuperior)
				{
					System.out.println(lineaArchivo);
				}
				n++;
			}
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n<--- ERROR: El archivo no se encuentra en el directorio. --->\n");
			//e.printStackTrace();
		}

		System.out.println("HAY ESTE NUMERO DE CLASES: " + String.valueOf(n));
	}

	public void analizar()
	{
		boolean bandera = false;
		String prueba = "";
		int n = 1;
		int linea;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();
				if(lineaArchivo.contains("class"))
				{
					bandera = true;
					prueba += String.valueOf(n) + "|";
				}

				if(bandera)
				{
					if(lineaArchivo.contains("};"))
					{
						bandera = false;
						prueba += String.valueOf(n);
						//System.out.println("CLASE DE: " + prueba);
						clasesDisponibles.add(prueba);
						prueba = "";
					}
				}
				/*//System.out.println(lineaArchivo);
				if(lineaArchivo.contains("class"))
				{
					n++;
				}
				if(n >= 4 && n<=10)
				{
					System.out.println(lineaArchivo);
				}
				n++;*/
				n++;
			}
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n<--- ERROR: El archivo no se encuentra en el directorio. --->\n");
			//e.printStackTrace();
		}

		//System.out.println("HAY ESTE NUMERO DE CLASES: " + String.valueOf(n));
		/*for(String string : clasesDisponibles)
		{
			System.out.println(string);
		}*/
	}

	public void buscarNombre()
	{
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();
				if(lineaArchivo.contains("class"))
				{
					lineaArchivo = depurarString(lineaArchivo);
					//System.out.println("\nNombre clase: " + lineaArchivo);
					clase = new Clase(lineaArchivo);
				}
			}
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n<--- ERROR: El archivo no se encuentra en el directorio. --->\n");
			//e.printStackTrace();
		}
	}

	public void buscarMetodos()
	{
		this.listaMetodos.clear();
		boolean banderaMetodo = false;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();

				if(lineaArchivo.contains("private:") || lineaArchivo.contains("};"))
				{
					banderaMetodo = false;
				}
				if(banderaMetodo)
				{
					lineaArchivo = depurarString(lineaArchivo);
					this.agregarMetodo(lineaArchivo);
				}
				if(lineaArchivo.contains("public:"))
				{
					banderaMetodo = true;
				}				
			}
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n<--- ERROR: El archivo no se encuentra en el directorio. --->\n");
			//e.printStackTrace();
		}

		/*System.out.println("\n\nESTOS SON LOS METODOS DE MI CLASE:");
		for(Metodo metodo : listaMetodos)
		{
			System.out.println(metodo.toString());
		}
		//System.out.println(todosLosbanderaMetodos);*/
		clase.setMetodos(listaMetodos);

	}

	public void buscarVariables()
	{
		this.listaVariables.clear();
		boolean banderaMetodo = false;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();
				if(lineaArchivo.contains("public:") || lineaArchivo.contains("};"))
				{
					banderaMetodo = false;
				}
				if(banderaMetodo)
				{
					lineaArchivo = depurarString(lineaArchivo);
					this.agregarVariable(lineaArchivo);
				}
				if(lineaArchivo.contains("private:"))
				{
					banderaMetodo = true;
				}	
				
			}
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n<--- ERROR: El archivo no se encuentra en el directorio. --->\n");
			//e.printStackTrace();
		}

		/*System.out.println("\n\nESTOS SON LAS VARIABLES DE MI CLASE:\n");
		for(Variable variable : listaVariables)
		{
			System.out.println(variable.toString());
		}
		//System.out.println(todosLosbanderaMetodos);*/
		clase.setVariables(listaVariables);
	}

	public String depurarString(String linea)
	{
		String depuracion = "";
		depuracion = linea.trim();
		depuracion = depuracion.replace(";", "");
		depuracion = depuracion.replace("{", "");
		depuracion = depuracion.replace("}", "");
		depuracion = depuracion.replace("class", "");
		depuracion = depuracion.trim();

		return depuracion;
	}

	public void agregarVariable(String linea)
	{
		String[] division = linea.split(" ", 2);
		listaVariables.add(new Variable(division[0], division[1]));
	}

	public void agregarMetodo(String linea)
	{
		if(!linea.isEmpty())
		{
			String[] division = linea.split(" ", 2);
			if(division.length >= 2)
			{
				listaMetodos.add(new Metodo(division[0], division[1]));
			}
			else
			{
				listaMetodos.add(new Metodo("", division[0]));
			}
			
		}
		
	}

	public void obtenerClase()
	{
		String split[];
		for(String string : clasesDisponibles)
		{
			split = string.split("\\|");
			//System.out.println(split[0] + " y " + split[1]);
			this.leer(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			System.out.println("\n\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n");
		}
	}
	public Clase getClase()
	{
		this.buscarNombre();
		this.buscarVariables();
		this.buscarMetodos();
		return clase;
	}
}

//Hacer un if para que guarde un string desde que encuentra un "class" hasta un ";}"
//Después que guarde solamente las que tienen "un ( o )"
//Para las variables hacer una condición que después de un "Private" me guarde todo después de eso
//http://chuwiki.chuidiang.org/index.php?title=Eliminar_espacios_de_un_String_en_Java
//OPCION 2
//Si es una variable, se pone PRIVATE
//Después de PUBLIC son los métodos.
//https://es.stackoverflow.com/questions/45846/c%C3%B3mo-separar-un-string-en-java-c%C3%B3mo-utilizar-split