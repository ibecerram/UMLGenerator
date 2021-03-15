#include <iostream> 
using namespace std; 
class Coordenada {
	private:  int x; int y;
	public: Coordenada (int x, int y) {this->x=x, this->y=y;}
	public: int getX () { return x;}
	public: int getY () { return y;}
	public: void setX (int x) { this->x=x;}
	public: void setY (int y) { this->y=y;}
	
	string to_string() const { return ("Objeto tipo PUNTO X="+ std::to_string(x) + " Y=" + std::to_string(y)); }
};

ostream& operator<< (ostream& outs, const Coordenada& obj) {  return outs << obj.to_string();  }  
ostream& operator<< (ostream& outs, const Coordenada* obj) {  return outs << obj->to_string();  }  

class Figura2D {
	protected: Coordenada PosPunto; 
	int Color;
	public: Figura2D (): PosPunto {Coordenada(0,0)}, Color {80} {}
	public: Figura2D(const Coordenada & posicion, int c): 
		PosPunto {posicion}, Color {c}
		{
			/*Coordenada Temporal(50,50);
			PosPunto = Temporal;
			PosPunto = posicion;
			Color = c;*/
		}
	string to_string() const { return ("Objeto tipo FIGURA2D Punto="+ PosPunto.to_string()+" Color="+std::to_string(Color)); }
};
ostream& operator<< (ostream& outs, const Figura2D& obj) {  return outs << obj.to_string();  }
ostream& operator<< (ostream& outs, const Figura2D* obj) {  return outs << obj->to_string(); }    

class Circulo : Figura2D {
	string Identificador;
	float Radio;
	public: Circulo (): Figura2D (), Radio{10.0}, Identificador{"N1"} {  } // Valores por defecto para Figura2D y Radio
	
	public: Circulo (int x, int y, int c, float Radio): 
		Identificador{"N2"},
		Figura2D (Coordenada(x,y),c), Radio{Radio} {
	}
	
	public: Coordenada RetornaPunto()
	{
		return PosPunto;
	}
	string to_string() const { return ("Circulo ID: "+Identificador+" Radio="+std::to_string(Radio)+" Centro: "+PosPunto.to_string()); }
}; 
ostream& operator<< (ostream& outs, const Circulo& obj) {  return outs << obj.to_string();  }
ostream& operator<< (ostream& outs, const Circulo* obj) {  return outs << obj->to_string(); }    




int main() { 
	Coordenada C1 (1,10);
	Coordenada C3 (1,10);
	Coordenada * C2 = new Coordenada (2,20);
	cout <<C1<<"\n";
	cout <<C2<<"\n";
	
	Figura2D FigTem0;
	Figura2D FigTem (C1,0);
	Figura2D FigTem3 (C1,0);
	cout <<FigTem0<<"\n";
	cout <<FigTem<<"\n";
	cout <<FigTem3<<"\n";
	
	Circulo CLo1;
	Circulo CLo2(-10,-15,0,9.5);
	cout <<CLo1<<"\n";
	cout <<CLo2<<"\n";		

	cout <<CLo1.RetornaPunto()<<"\n";
	cout <<CLo2.RetornaPunto()<<"\n";
	/*cout <<C1<<"\n";
	cout <<C2<<"\n";
	cout <<FigTem0<<"\n";
	cout <<FigTem<<"\n";*/
	return 0; 
} 
