#include <iostream>
#include "Rectangulo.h"

using namespace std;

int Rectangulo::count = 0; //Se inicializa de manera estática el contador
int main()
{
	/*
	cout << "Hola Mundo C++\n";
	Rectangulo Obj1;
	Obj1.ImprimeContador();
	Rectangulo Obj2(10,10);
	Obj2.ImprimeContador();
	Rectangulo Obj3;
	Obj3.ImprimeContador();
	Rectangulo Obj4(15,7);
	Obj4.ImprimeContador();
	*/
	
	Rectangulo Obj1;
	Rectangulo Obj2(10,5);
	Rectangulo Obj3(10,5, "Marco Nuño");
	Obj1.ImprimeContador();
	Obj2.ImprimeContador();
	Obj3.ImprimeContador();
}
