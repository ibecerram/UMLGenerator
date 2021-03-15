public class Variable
{
	private String tipoDeDato;
	private String identificador;

	public Variable(String tipoDeDato, String identificador)
	{
		this.tipoDeDato = tipoDeDato;
		this.identificador = identificador;
	}

	public void setTipoDeDato(String tipoDeDato)
	{
		this.tipoDeDato = tipoDeDato;
	}

	public void setIdentificador(String identificador)
	{
		this.identificador = identificador;
	}

	public String getTipoDeDato()
	{
		return this.tipoDeDato;
	}

	public String getIdentificador()
	{
		return this.identificador;
	}

	public String toString()
	{
		return this.tipoDeDato + " " + this.identificador;
	}
}