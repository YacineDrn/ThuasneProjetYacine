package fr.thuasne;

public class Device {

	private String deviceRef= new String() ;
	private boolean  available; 
	private String currentFirmware=new String();
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public Device (String ref)
	{
		this.deviceRef=ref;
		this.available=true;
		this.currentFirmware=null;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getDeviceRef() {
		return deviceRef;
	}
	public void setDeviceRef(String deviceRef) {
		this.deviceRef = deviceRef;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getCurrentFirmware() {
		return currentFirmware;
	}
	public void setCurrentFirmware(String currentFirmware) {
		this.currentFirmware = currentFirmware;
	}
}
