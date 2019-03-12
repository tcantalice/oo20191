package br.ucsal.contact;

public class Contact{

	Contact next = null;
	char firstLetter;
	String name;
	String phone;
	String email;
	String adress;

	Contact(String name, String phone, String email, String adress){
		this.name = name;
		this.firstLetter = this.name.charAt(0);
		this.phone = phone;
		this.email = email;
		this.adress = adress;
	}

	public String getName(){
		return this.name;
	}

	/**
	*	Return the contact object based in the name. If not exists, return null.
	*
	*	@param name
	*/
	public Contact get(String name){
		if(this.name.equals(name))
			return this;
		else if(this.next != null)
			return this.next.getContact(name);
		else
			return null;
	}

	/**
	*	Insert contact in next free space. Return if has been inserted.
	*
	*	@param contact
	*/
	public boolean insert(Contact contact){
		boolean inserted = false;
		if(!this.equals(contact)){
			if(this.next == null){
				this.next = contact;
			}
			else{
				this.next.insert(contact);
			}
			inserted = true;
		}
		return inserted;
	}
	
	/**
	*	Remove object equal to the contact and move the next object to the current instance.
	*
	*	@param contact
	*/
	public void remove(Contact contact){
		if(this.equals(contact)){
			this = this.next;
		}
		else{
			this.next.remove(contact);
		}
	}

	/**
	*	Return the next contact in list, even it's null.
	*/
	public Contact getNext(){
		return this.next;
	}

	@Override
	public boolean equals(Object other){
		Contact contact = (Contact) other;
		return this.name.equals(contact.getName());
	}

}