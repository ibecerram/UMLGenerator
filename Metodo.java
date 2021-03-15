public class Metodo
{
	private String tipoRetorno = "";
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
}