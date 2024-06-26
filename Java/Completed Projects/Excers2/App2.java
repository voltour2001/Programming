abstract class Animal {
	
	String name;
	static int animals = 0;
	
	Animal(String n) {
		name = n;
		animals++;
	}
	
	abstract void speak();
	static int numberOfAnimals() {
		return animals;
	}

}

class Dog extends Animal {
	String sound = "woof";
	static int dogs = 0;
	
	Dog(String n) {
		super(n);
		dogs++;
	}
	public static int numberOfDogs() {
		return dogs;
	}
	void speak() {
        System.out.println(name + ": " + sound);
    }

}

class Cat extends Animal {
	String sound = "miaou";
	static int cats = 0;

	Cat(String n) {
		super(n);
		cats++;
	}
	public static int numberOfCats() {
		return cats;
	}
	void speak() {
		System.out.println(name + ": " + sound);
    }
}

class App2 {

	public static void main(String[] args) {
		Animal[] animal = {	new Cat("stella"), new Cat("ziggy"), new Dog("azor")};
		System.out.println("Cats: "+Cat.numberOfCats());
		System.out.println("Dogs: "+Dog.numberOfDogs());
		System.out.println("Animals: "+Animal.numberOfAnimals());
		for ( int i = 0; i < animal.length; i++ )
			animal[i].speak();
	}
}
