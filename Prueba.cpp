#include <iostream>
using namespace std;

class Rueda {
	private:
		string nombre;
	public:
		Rueda(string n);
		void printRueda();
};

Rueda::Rueda(string n)
{nombre=n;}

void Rueda::printRueda()
 {cout <<nombre<<"\n";};

///////////////////////////
class Bicicleta 
{
	private: 
		Rueda *r[2]; //puntero
	public:
		Bicicleta();
		Bicicleta(Rueda *r1, Rueda *r2);
		void cambiarRueda(int pos, Rueda *raux);
		
		void ImprimeRuedas ();
		
		~Bicicleta();
};

Bicicleta::~Bicicleta()
{
		    r[0]=NULL;
		    r[1]=NULL;
}
Bicicleta::Bicicleta()
{r[0]=NULL; r[1]=NULL;}

Bicicleta::Bicicleta(Rueda *r1, Rueda *r2)
{
			r[0]=r1;
			r[1]=r2;
}
void Bicicleta::cambiarRueda(int pos, Rueda *raux)
{
			r[pos]=raux;
}

void Bicicleta::ImprimeRuedas()
{
			r[0]->printRueda();
			r[1]->printRueda();
}

int main(){
	//Rueda *r, *r2, *r3;
	Rueda *r= new Rueda("primera"); 
	Rueda *r2= new Rueda("segunda");
	Rueda *r3 =new Rueda("tercera"); 
	Bicicleta b1(r,r2);
	
	cout<<"Ruedas de la bicicleta b1"<<endl;
	b1.ImprimeRuedas();
	
	b1.cambiarRueda(0,r3);
	
	cout<<"Nuevas ruedas de la bicicleta b1"<<endl;
	b1.ImprimeRuedas();
	
	b1.~Bicicleta();
	cout<<"Ruedas"<<endl;
	r->printRueda();
	r2->printRueda();
	r3->printRueda();
}
