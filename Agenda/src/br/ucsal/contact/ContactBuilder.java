package br.ucsal.contact;

public class ContactBuilder {
	private String name;
	private String phone;
	private String email;
	private String adress;

	public ContactBuilder(String name){
		this.name = name;
	}

	public ContactBuilder email(String email){
		this.email = email;
		return this;
	}

	public ContactBuilder phone(String phone){
		this.phone = phone;
		return this;
	}

	public ContactBuilder adress(String adress){
		this.adress = adress;
		return this;
	}

	public Contact build(){
		return new Contact(this.name, this.phone, this.email, this.adress);
	}
}