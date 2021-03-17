public class Metodo
{
	private String tipoRetorno;
	private String nombre;

	public Metodo(String tipoRetorno, String nombre)
	{
		this.tipoRetorno = tipoRetorno;
		this.nombre = nombre;
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
}