package mybatis.model;

public class Player {

	private int id;
	private String name;
	private String nationality;
	private String club;
	
	
	public Player(String name, String nationality, String club) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.club = club;
	}
	
	public Player() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
}
