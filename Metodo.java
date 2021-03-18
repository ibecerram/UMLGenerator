import java.util.*;

public class Metodo
{
	private String tipoRetorno;
	private String nombre;

	public Metodo(String tipoRetorno, String nombre)
	{
		this.tipoRetorno = tipoRetorno;
		this.nombre = nombre;
		this.formatoNombre();
	}

	public void setTipoRetorno(String tipoRetorno)
	{
		this.tipoRetorno = tipoRetorno;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
		
	}

	public String getTipoRetorno()
	{
		return this.tipoRetorno;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String toString()
	{
		return this.tipoRetorno + " " + this.nombre;
	}

	public String getFormatoUml()
	{
		if(tipoRetorno.isEmpty())
		{
			//System.out.println("Entro aqui en " + nombre);
			return "+ " + this.nombre;
		}
		else
		{
			return "+ " + this.nombre + " : " + this.tipoRetorno; 
		}
		
	}

	public void formatoNombre()
	{
		String formato = "";
		String variablesFormato = "";
		//String[] division[0] = "s";
		String primeraParte = "";
		//System.out.println("Entra al Metodo");
		if(!this.nombre.contains("\\(\\)"))
		{
			//System.out.println("ENTRO AL FOR");
			String formateo = this.nombre.replace("\\)", "");
			String[] division = this.nombre.split("\\(");
			primeraParte = division[0];
			String[] variables = division[1].split(",");
			for(int i = 0; i < variables.length; i++)
			{
				variables[i] = variables[i].replaceAll("\\)", "");
				if(!variables[i].isEmpty())
				{
					//System.out.println(variables[i] +  " entra aqui");
					variables[i] = variables[i].trim();
					String[] divisionVariable = variables[i].split(" ");
					//System.out.println(divisionVariable[1] + " parte 2");
					//System.out.println(divisionVariable[0] + " parte 1");
					variablesFormato += divisionVariable[1] + " : " + divisionVariable[0];
					if(i != variables.length -1)
					{
						variablesFormato += ", ";
					}
				}

			}
		}

		if(variablesFormato.isEmpty())
		{
			variablesFormato = this.nombre;
		}
		else
		{
			variablesFormato = primeraParte + "(" + variablesFormato + ")";
		}

		//System.out.println("Variables como: " + variablesFormato);
		this.nombre = variablesFormato;
	}
}