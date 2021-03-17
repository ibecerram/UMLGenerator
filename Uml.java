import java.util.*;

public class Uml
{
	private String codigoUml;
	private ArrayList<Variable> listaVariables = new ArrayList<>();
	private ArrayList<Metodo> listaMetodos = new ArrayList<>();

	public Uml()
	{
		this.codigoUml = "";
	}

	public String encabezadoDocumento()
	{
		codigoUml = "";
		codigoUml += "\\documentclass[legalpaper,11pt, landscape]{article}\n";
		codigoUml += "\\usepackage[T1]{fontenc}\n";
		codigoUml += "\\usepackage[utf8]{inputenc}\n";
		codigoUml += "\\usepackage[spanish]{babel}\n";
		codigoUml += "\\usepackage{listings}\n";
		codigoUml += "\\usepackage{fancyvrb}\n";
		codigoUml += "\\usepackage{tikz-uml}\n";
		codigoUml += "\\usepackage[margin=0.5in]{geometry}\n";
		codigoUml += "\\begin{document}\n";
		codigoUml += "\\begin{tikzpicture}\n";
		codigoUml += "\\begin{umlpackage}[x=0, y=0]{diagramaClasesUML}\n";
		return codigoUml;
	}

	public String crearClase(Clase clase, int x, int y)
	{
		codigoUml = "";
		listaVariables.clear();
		listaMetodos.clear();

		listaVariables.addAll(clase.getVariables());
		listaMetodos.addAll(clase.getMetodos());

		codigoUml += "\\umlclass";
		codigoUml += "[x=" + String.valueOf(x) + ", y = " + String.valueOf(y) + "]";
		codigoUml += "{" + clase.getNombre() + "}";
		codigoUml += "\n{\n";
		//Variables
		for(Variable variable : listaVariables)
		{
			codigoUml += variable.getFormatoUml() + " \\\\" + "\n";
		}
		codigoUml += "\n}";

		codigoUml += "\n{\n";
		//Metodos
		for(Metodo metodo : listaMetodos)
		{
			codigoUml += metodo.getFormatoUml() + " \\\\ " + "\n";
		}
		codigoUml += "\n}";

		return codigoUml;
	}

	public String crearHerencia()
	{
		codigoUml = "";
		return codigoUml;
	}

	public String crearComposicion()
	{

	}
	
	public String finalizarDocumento()
	{
		codigoUml = "";
		codigoUml += "\\end{umlpackage}\n";
		codigoUml += "\\end{tikzpicture}\n";
		codigoUml += "\\end{document}";

		return codigoUml;
	}

}