import java.util.*;

class Stack4 {
	
	public static void main(String[] args) {
		
		DogCatQueue mixq = new DogCatQueue();
		
		Pet dog1 = new Pet("Dog");
		Pet cat1 = new Pet("Cat");
		Pet dog2 = new Pet("Dog");
		Pet cat2 = new Pet("Cat");

		mixq.add(dog1);
		mixq.add(cat1);
		mixq.add(dog2);
		mixq.add(cat2);
		
		Pet tmp = mixq.pollAll();
		System.out.println("Pop: "+tmp);

		tmp = mixq.pollCat();
		System.out.println("Pop: "+tmp);
		
		if(mixq.isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			System.out.println("Queue is not empty!");
		}


	}

}

class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}

class Dog extends Pet {
	public Dog() {
		super("Dog");
	}
}

class Cat extends Pet {
	public Cat() {
		super("Cat");
	}
}

class PetEnterQueue {
	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;
	}

	public long getCount() {
		return this.count;
	}

	public String getEnterType() {
		return this.pet.getPetType();
	}
	
}

class DogCatQueue {
	private Queue<PetEnterQueue> DogQ;
	private Queue<PetEnterQueue> CatQ;
	private long count;

	public DogCatQueue() {
		this.DogQ = new LinkedList<PetEnterQueue>();
		this.CatQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}

	public void add(Pet pet) {
		if(pet.getPetType().equals("Dog")) {
			this.DogQ.add(new PetEnterQueue(pet,this.count++));
		} else if(pet.getPetType().equals("Cat")) {
			this.CatQ.add(new PetEnterQueue(pet,this.count++));	
		} else {
			throw new RuntimeException("Type input error!");
		}
	}	

	public Pet pollAll() {
		if(!this.DogQ.isEmpty() && !this.CatQ.isEmpty()) {
			if(this.DogQ.peek().getCount() < this.CatQ.peek().getCount()) {
				return this.DogQ.poll().getPet();
			} else {
				return this.CatQ.poll().getPet();
			}
		} else if(!this.isCatEmpty()) {
			return this.CatQ.poll().getPet();
		} else if(!this.isDogEmpty()) {
			return this.DogQ.poll().getPet();
		} else {
			throw new RuntimeException("The queue is empty!");
		}
	}

	public Dog pollDog() {
		if(this.isDogEmpty()) {
			throw new RuntimeException("The Dog queue is empty!");
		}
		return (Dog) this.DogQ.poll().getPet();
	}


	public Cat pollCat() {
		if(this.isCatEmpty()) {
			throw new RuntimeException("The Cat queue is empty!");
		}
		return (Cat) this.CatQ.poll().getPet();
	}

	public boolean isEmpty() {
		return isDogEmpty() && isCatEmpty();
	}

	public boolean isDogEmpty() {
		return this.DogQ.isEmpty();
	}

	public boolean isCatEmpty() {
		return this.CatQ.isEmpty();
	}

}


