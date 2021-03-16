

public class Uml
{
	private String clase;
	public Uml()
	{

	}

	public String crearClase(Clase clase, int x, int y)
	{
		String codigo = "";
		codigo += "\\umlclass";
		codigo += "[x=" + String.valueOf(x) + ", y = " + String.valueOf(y) + "]";
		codigo += "{" + clase.getNombre() + "}";
		codigo += "{Variables";
		//Variables
		codigo += "}";
		codigo += "{Metodos";
		//Metodos
		codigo += "}";

		return codigo;
	}
}