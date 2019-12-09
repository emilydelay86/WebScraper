//the getters and setters will go in this class
public class data {
	private String tname, tnumber, tanimal, tgender, tbreed, tage, tid;

	public String getName() {
		return tname;
	}
	public void setName(String name) {
		this.tname = tname;
	}
	public String getNumber() {
		return tnumber;
	}
	public void setNumber(String number) {
		this.tnumber = tnumber;
	}
	public String getAnimal() {
		return tanimal;
	}
	public void setAnimal(String animal) {
		this.tanimal = tanimal;
	}
	public String getGender() {
		return tgender;
	}
	public void setGender(String gender) {
		this.tgender = tgender;
	}
	public String getBreed() {
		return tbreed;
	}
	public void setBreed(String breed) {
		this.tbreed = tbreed;
	}
	public String getAge() {
		return tage;
	}
	public void setAge(String age) {
		this.tage = tage;
	}
	public String getId() {
		return tid;
	}
	public void setId(String id) {
		this.tid = tid;
	}
	
	public data() {
		tname = "";
		tnumber = "";
		tanimal = "";
		tgender = "";
		tbreed = "";
		tage = "";
		tid = "";
	}
 
	public data(String tname, String tnumber, String tanimal,
			String tgender, String tbreed, String tage, String tid) {
	//setfunction(variable)
		setName(tname);
		setNumber(tnumber);
		setAnimal(tanimal);
		setGender(tgender);
		setBreed(tbreed);
		setAge(tage);
		setId(tid);
		
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s",
				tname, tnumber, tanimal, tgender, tbreed, tage, tid );
	}
}

