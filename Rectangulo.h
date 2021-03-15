class Rectangulo : Figura2D { 
	private:
		TipoRectangulo TR;
		int base;
		int altura;
		char* Nombre;
	public:
		Rectangulo ();
		Rectangulo (int b, int a); 
		Rectangulo (int a, int b, char * c);
		TipoRectangulo getTipoRectangulo ();
		static int count;
		static const float PI;
		void ImprimeContador();
		void dimensiones(int a, int b);
		int area ();
	
};
