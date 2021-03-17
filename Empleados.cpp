#include <iostream>
#include <stdio.h>
using namespace std;

class Empleados{
	private:
		string name;
		int age;
		double sueldo;
	public:
		char* informacion();
		Empleados(string n, int a, double d);
	
};

Empleados::Empleados(string n,int a, double d)
{
	name=n;
	age = a;
	sueldo = d;
}
void Empleados::informacion(){
	
	printf("El empleado %s  %s trabaja en el area %s con numero de telefono %ld y tiene la edad de %d años\n", name, lastn, a, tel, age);
}


int main(){
	/*Empleados obj1;
	obj1.informacion("Annel","Uresti","Recepcion",8343525157, 20);*/

	Empleados obj2("Annel","Uresti", "Recepcion", 8343525157, 20);
	cout<<"El empleado "<<obj2.name<<" "<<obj2.lastn<<" trabaja en el area de "<<obj2.area<<" con numero de telefono "<<obj2.tel<<" y tiene la edad de "<<obj2.age<<"\n";

	return 0;

}
