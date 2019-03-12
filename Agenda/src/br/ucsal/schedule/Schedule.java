package br.ucsal.schedule;

public Schedule {

	private static Schedule instance = null;
	Contact topContact = null;
	String name;

	private Schedule(){
		
	}

	public static Schedule getInstance(){
		if(instance == null){
			instance = new Schedule();
		}
		return instance;
	}

	/**
	*	Add a new contact in schedule.
	*
	*	@param contact
	*/
	public void addContact(Contact contact){
		if(this.topContact == null){
			this.topContact = contact;
		}
		else{
			this.topContact.insert(contact);
		}
	}

	public void removeContact(Contact contact){
		if(this.topContact.equals(contact)){
			this.topContact = this.topContact.getNext();
		}
		else{
			this.topContact.remove(contact);
		}
	}
}