#include <iostream>
using namespace std;
#include "Rectangulo.h"

const float Rectangulo::PI = 3.141592;
Rectangulo::Rectangulo () 
{
	dimensiones(1,1);
	TR=CUADRADO;
	count++;
	Nombre="SinPropietario";
	
}
Rectangulo::Rectangulo (int b, int a) {
	base=b;
	altura=a;
	dimensiones(a,b);	
	TR= (b!=a? NOCUADRADO : CUADRADO); //if (b!=a) TR = NOCUADRADO; else TR=Cuadrado;
	count++;
	Nombre="SinPropietario";
}

Rectangulo::Rectangulo(int a, int b, char * c)
{
	dimensiones(a,b);
	Nombre = c;	
	TR= (b!=a? NOCUADRADO : CUADRADO); //if (b!=a) TR = NOCUADRADO; else TR=Cuadrado;
	count++;
}
void Rectangulo::ImprimeContador(){
	cout <<"Valor de count "<<count<<" \n";
	cout <<"base "<<base<<" altura: "<<altura<<"\n";
	cout <<"Valor de TR " <<TR<<"\n";
	cout <<"Propietairio: " <<Nombre<<"\n";
	switch (TR) {
		case CUADRADO: cout <<"CUADRADO  \n"; break;
		case NOCUADRADO: cout <<"NO CUADRADO  \n"; break;
		default: cout <<"DESCONOCIDO \n"; break;
	}
	
	cout <<"\n";
}
void Rectangulo::dimensiones(int a, int b) {
	base = a;
	altura = b;
}
