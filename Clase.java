import java.util.*;

public class Clase
{
	private String nombre;
	private String herencia = "";
	private ArrayList<Variable> listaVariables = new ArrayList<>();
	private ArrayList<Metodo> listaMetodos = new ArrayList<>();

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

	}
}