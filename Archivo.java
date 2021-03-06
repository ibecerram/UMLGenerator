import java.io.*;
import java.util.*;

public class Archivo
{
	private String nombreArchivo;
	private ArrayList<Variable> listaVariables = new ArrayList<>();
	private ArrayList<Metodo> listaMetodos = new ArrayList<>();
	private ArrayList<String> listaComposiciones = new ArrayList<>();
	//private ArrayList<String> clasesDisponibles = new ArrayList<>();
	HashMap <Integer, Integer> mapLimitesClases = new HashMap<>();
	private Clase clase;
	private ArrayList<Clase> listaClases = new ArrayList<>();
	private ArrayList<String> tiposDeDatos = new ArrayList<>();

	public Archivo(String nombreArchivo)
	{
		this.nombreArchivo = nombreArchivo;
		this.tiposDeDatos.add("int");
		this.tiposDeDatos.add("char");
		this.tiposDeDatos.add("char*");
		this.tiposDeDatos.add("float");
		this.tiposDeDatos.add("double");
		this.tiposDeDatos.add("long");
		this.tiposDeDatos.add("short");
		this.tiposDeDatos.add("string");
		this.tiposDeDatos.add("void");
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
		//String prueba = "";
		int n = 1;
		int limiteInferior = 0;
		int limiteSuperior = 0;
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
					//prueba += String.valueOf(n) + "|";
					limiteInferior = n;
				}

				if(bandera)
				{
					if(lineaArchivo.contains("};"))
					{
						bandera = false;
						//prueba += String.valueOf(n);
						//System.out.println("CLASE DE: " + prueba);
						limiteSuperior = n;
						//clasesDisponibles.add(prueba);
						//prueba = "";
						mapLimitesClases.put(limiteInferior, limiteSuperior); 
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

	public void buscarNombre(int limiteInferior, int limiteSuperior)
	{
		int n = 1;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();

				if(n >= limiteInferior && n<= limiteSuperior)
				{
					if(lineaArchivo.contains("class"))
					{
						lineaArchivo = depurarString(lineaArchivo);
						if(lineaArchivo.contains(":"))
						{
							String[] split = lineaArchivo.split(":");
							clase = new Clase(depurarString(split[0]));
							clase.setHerencia(depurarString(split[1]));
						}
						else
						{
							//System.out.println("\nNombre clase: " + lineaArchivo);
							clase = new Clase(lineaArchivo);
						}
						
					}
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
	}

	public void buscarMetodos(int limiteInferior, int limiteSuperior)
	{
		int n = 1;
		this.listaMetodos.clear();
		boolean banderaMetodo = false;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();

				if(n >= limiteInferior && n<= limiteSuperior)
				{
					//System.out.println(lineaArchivo);
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

				n++;							
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

	public void buscarVariables(int limiteInferior, int limiteSuperior)
	{
		int n = 1;
		this.listaVariables.clear();
		this.listaComposiciones.clear();
		boolean banderaMetodo = false;
		try
		{
			File file = new File(this.nombreArchivo);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String lineaArchivo = reader.nextLine();

				if(n >= limiteInferior && n<= limiteSuperior)
				{
					//System.out.println(lineaArchivo);
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
				n++;
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
		clase.setComposiciones(listaComposiciones);
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
		//Verificar composici??n
		if(!this.tiposDeDatos.contains(division[0]))
		{
			if(!division[0].equals(clase.getNombre()))
			{
				//System.out.println("CONTIENE UNA COMPOSICI??N EN:" + division[0] + "x");
				//System.out.println("NOMBRE CLASE:" + clase.getNombre() + "x");
				division[0] = division[0].replace("*", "");
				division[0] = division[0].replace("**", "");
				division[0] = division[0].replace("***", "");
				this.listaComposiciones.add(division[0]);
			}
			
		}
	}

	public void agregarMetodo(String linea)
	{
		if(!linea.isEmpty())
		{
			String[] division = linea.split(" ", 2);
			if(division.length >= 2)
			{
				//listaMetodos.add(new Metodo(division[0], division[1]));
				if(division[0].contains("(") || division[0].contains(")"))
				{
					listaMetodos.add(new Metodo("", linea));
					//System.out.println("ENTRO EN (((((()))) = " + division[0]);
				}
				else
				{
					listaMetodos.add(new Metodo(division[0], division[1]));
					//System.out.println("ENTRO EN aca= " + division[0]);
				}
			}
			else
			{
				listaMetodos.add(new Metodo("", linea));
				//System.out.println("Entro en else= " + division[0]);
			}
			/*
			else
			{
				if(division[0].contains(")"))
				{
					listaMetodos.add(new Metodo("", division[0]));
				}
				else
				{
					listaMetodos.add(new Metodo(division[0], division[1]));
				}
			}
			*/
			
		}
		
	}
	/*
		public void agregarMetodo(String linea)
	{
		if(!linea.isEmpty())
		{
			if(!this.tiposDeDatos.contains(linea))
			{
				if(linea.equals(clase.getNombre()))
				{
					listaMetodos.add(new Metodo("", linea));
				}
			}
			else
			{
				String[] division = linea.split(" ", 2);
				if(division.length >= 2)
				{
					listaMetodos.add(new Metodo(division[0], division[1]));
				}
			}
			
			/*else
			{
				listaMetodos.add(new Metodo("", division[0]));
			}
			
		}
		
	}*/


	public ArrayList<Clase> obtenerClase()
	{
		//String split[];
		//for(String string : clasesDisponibles)
		for(Map.Entry<Integer, Integer> map : mapLimitesClases.entrySet())
		{
			//split = string.split("\\|");
			//System.out.println(split[0] + " y " + split[1]);
			int limiteInferior = map.getKey();
			int limiteSuperior = map.getValue();
			//this.leer(limiteInferior, limiteSuperior);
			//System.out.println("\n\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n");
			this.buscarNombre(limiteInferior, limiteSuperior);
			this.buscarVariables(limiteInferior, limiteSuperior);
			this.buscarMetodos(limiteInferior, limiteSuperior);
			listaClases.add(clase);
		}

		/*for(Clase clase : listaClases)
		{
			clase.mostrarClase();
			System.out.println("\n***************************************\n");
		}*/

		return listaClases;
	}
	/*public Clase getClase()
	{
		this.buscarNombre();
		this.buscarVariables();
		this.buscarMetodos();
		return clase;
	}*/
}

//Hacer un if para que guarde un string desde que encuentra un "class" hasta un ";}"
//Despu??s que guarde solamente las que tienen "un ( o )"
//Para las variables hacer una condici??n que despu??s de un "Private" me guarde todo despu??s de eso
//http://chuwiki.chuidiang.org/index.php?title=Eliminar_espacios_de_un_String_en_Java
//OPCION 2
//Si es una variable, se pone PRIVATE
//Despu??s de PUBLIC son los m??todos.
//https://es.stackoverflow.com/questions/45846/c%C3%B3mo-separar-un-string-en-java-c%C3%B3mo-utilizar-split