#include <iostream>
#include <stdio.h>
#include "clases.h"
using namespace std;

class Zoo{
	private:
		char* name;
		Animal arrayAnimales[30];
		Empleados arrayEmpleados[30];
	public:
		Zoo(string n);
		void getZoo();
		
};

Zoo::Zoo(char* nombre)
{
	name = nombre;
}

void Zoo::getZoo()
{
	cout<<"Bienvenido al zoo de: " <<name;
}

int main(){

	Zoo obj("TAMATAN");
	//Animal::sexo(1);

	//objA.eats(2);
	//Mamifero::eats(2);

	

	return 0;

}
