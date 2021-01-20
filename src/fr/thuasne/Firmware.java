package fr.thuasne;

public class Firmware {

	private String firmwareVersion = new String();
	
	
	public Firmware(String version)
	{
		this.firmwareVersion=version;
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}




}


