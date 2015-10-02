package si.fri.prpo;

import javax.validation.constraints.Size;

public class User extends Entiteta{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastname;
	private int user_ID;
	private double credit;
	private int bonusPoints;
	private String phone;
	private String email;
	private double maxDaily;
	
	//geteri
	@Override
	public int getId() {
		return user_ID;
	}
	
	@Size(min = 2, message="Name too short")
	public String getName(){
		return name;
	}
	
	@Size(min = 2, message="lastname too short")
	public String getLastname(){
		return lastname;
	}
	
	public double getCredit(){
		return credit;
	}

	public int getBonusPoints(){
		return bonusPoints;
	}	

	public String getPhone(){
		return phone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public double getMaxDaily(){
		return maxDaily;
	}
	
	
	//seteri
	@Override
	public void setId(int user_ID) {
		this.user_ID = user_ID;
	}
    
	public void setName(String name){
		this.name = name;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public void setCredit(double credit){
		this.credit = credit;
	}
	
	public void setBonusPoints(int bonusPoints){
		this.bonusPoints = bonusPoints;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	
	public void setMaxDaily(double maxDaily){
		this.maxDaily = maxDaily;
	}	
}
