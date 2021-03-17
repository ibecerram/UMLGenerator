import java.util.*;

public class Clase
{
	private String nombre;
	private String herencia;
	private ArrayList<Variable> listaVariables = new ArrayList<>();
	private ArrayList<Metodo> listaMetodos = new ArrayList<>();
	private ArrayList<String> listaComposiciones = new ArrayList<>();

	public Clase(String nombre)
	{
		this.nombre = nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setHerencia(String herencia)
	{
		this.herencia = herencia;
	}
	public void setVariables(ArrayList<Variable> listaVariables)
	{
		this.listaVariables = new ArrayList<Variable>(listaVariables);
	}

	public void setMetodos(ArrayList<Metodo> listaMetodos)
	{
		this.listaMetodos = new ArrayList<Metodo>(listaMetodos);
	}

	public void setComposiciones(ArrayList<String> listaComposiciones)
	{
		this.listaComposiciones = new ArrayList<String>(listaComposiciones);
	}

	public void mostrarClase()
	{
		System.out.println("Nombre clase: " + this.nombre);
		System.out.println("Herencia: " + this.herencia);
		System.out.println("\nMetodos:");
		for(Metodo metodo : listaMetodos)
		{
			System.out.println(metodo.toString());
		}

		System.out.println("\nVariables:");
		for(Variable variable : listaVariables)
		{
			System.out.println(variable.toString());
		}

		System.out.println("\nComposiciones:");
		for(String composicion : listaComposiciones)
		{
			System.out.println(composicion);
		}

	}

	public String getNombre()
	{
		return this.nombre;
	}

	public ArrayList<Variable> getVariables()
	{
		return this.listaVariables;
	}

	public ArrayList<Metodo> getMetodos()
	{
		return this.listaMetodos;
	}
}