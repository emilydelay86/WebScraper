//the getters and setters will go in this class
public class data {
	private String name, number, animal, gender, breed, age, id;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//gotta make the constructor 
	public data(String name, String number, String animal,
			String gender, String breed, String age, String id) {
	//setfunction(variable)
		setName(name);
		setNumber(number);
		setAnimal(animal);
		setGender(gender);
		setBreed(breed);
		setAge(age);
		setId(id);
		
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s",
				name, number, animal, gender, breed, age, id );
	}
}
