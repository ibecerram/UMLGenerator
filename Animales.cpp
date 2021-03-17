#include <iostream>
#include <stdio.h>
using namespace std;

class Animal{
	private:
		int sexo;
		int a;
	public:
		void sexo(int sexo);
		void alimento(int a);
	
};

void Animal::sexo(){
	int s;
	s = sexo;
	//s=1=hembra, s=2=macho
	if(s==1){
		cout<<"Es una hembra\n";
	}else{
		cout<<"Es un macho\n";
	}

}

void Animal::tipoAlimentacion(){
	int food;
	food = alimentacion;
	//food =1 = herbivoro, food=2=carnivoro
	if(food==1){
		cout<<"Es un animal herbivoros\n";
	}else{
		cout<<"Es un animal carnivoro\n";
	}

}

class Vertebrados:Animal{
	private:
		int patas;
	public:
		int cantPatas();
		void setPatas(int n);
	
};

int Vertebrados::cantPatas(){
	//int res;
	//res = patas;
	//res =1 = mamifero, res=2=aves
	//cout << "Tiene " << res << "patas";
	return patas;

}

void Vertebrados::setPatas(int n){
	patas = n;

}


class Mamifero:Vertebrados{
	private:
		int come;
		int habitat;
	public:
		void eats(int come);
		char* habitat(int a);
	
};

void Mamifero::eats(int come){
	int meat;
	meat = come;
	//meat=1=carnivoro, meat=2=no carnivoro
	if(meat==1){
		cout<<"Está comiendo\n";
	}else{
		cout<<"Está descansando..\n";
	}
}

char* Mamifero::habitat(int habitat){
	int esp;
	esp = habitat;
	//esp=1=marsupiales, esp=2=placentarios
	if(esp==1){
		return "Terrestre";
	}else{
		return "Marino";
	}

}


class Leon:Mamifero{
	private:
		int sonido, edad;
		char nombre;
	public:
		void info();
		Leon(string n, int y);
	
};

Leon::Leon(string n, int y)
{

	nombre=n;
	edad = y;
	
}

void Leon::info(){
	printf("El nombre del Leon es: %s y su edad es %d", nombre, edad);
	

}



int main(){

	Animal obj1;
	obj1.sexo(1);
	Animal obj2;
	obj2.tipoAlimentacion(2);

	Vertebrados obj3;
	obj3.cantPatas(1);

	Mamifero obj5;
	obj5.eats(2);
	Mamifero obj6;
	obj6.habitat(2);

	/*Leon obj7;
	obj7.makeSound(1);
	Leon obj8;
	obj8.info("Alex", 10, 2011);*/

	Leon obj9("Alex", 10, 50);
	cout<<"El nombre del leon es "<<obj9.name<<" y su edad es "<<obj9.age<<" y tiene un peso de "<<obj9.peso<<" kilos\n";
	return 0;

}
