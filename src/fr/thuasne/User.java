package fr.thuasne;

public class User {


	private String userRef= new String();
	private String associatedDevice= new String(); //R�f�rence de la ceinture associ�e � l'utilisateur
	private boolean equiped;	// l'utilisateur est-il �quip� d'une ceinture
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public User (String userRef)
	{
	
		this.userRef=userRef;
		this.associatedDevice= null;
		this.equiped=false;		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getUserRef() {
		return userRef;
	}

	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}

	public String getAssociatedDevice() {
		return associatedDevice;
	}

	public void setAssociatedDevice(String associatedDevice) {
		this.associatedDevice = associatedDevice;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	

	
	
}