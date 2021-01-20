package fr.thuasne;

public class Display {
	
	
	public void fullLine()
	{
		System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

	}
	
	public  void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public void diplayStatutFW(Firmware[] FW)

	{
		
		System.out.println("FIRMWARES DISPONIBLES :");
		for (int i=0;i<FW.length;i++)
		{
			System.out.println("\t- "+FW[i].getFirmwareVersion());
		}
		System.out.println();
	}
	
	public void displayStatutUser(User[] user)
	{
		boolean allEquiped=true,noneEquiped=true;
		
////////////////////////////////////////////////////// est ce que tout les users sont équipés?
		
		for (int i=0;i< user.length;i++)
		{
			if (!user[i].isEquiped())
			{
				allEquiped=false;
				break;
			}	
		}
		
////////////////////////////////////////////////////// est ce qu'aucun user n'est équipé?
		
		for (int i=0;i< user.length;i++)
		{
			if (user[i].isEquiped())
			{
				noneEquiped=false;
				break;
			}	
		}
//////////////////////////////////Affichage dans le cas ou tout les user sont équipés de ceinture
		if (allEquiped)
		{
		System.out.println("UTILISATEURS ASSOCIES :");
			for(int i=0;i<user.length;i++)
			{
				if (user[i].isEquiped())
				{
					System.out.println("\t- "+user[i].getUserRef()+"\tSLB ASSOCIEE : "+user[i].getAssociatedDevice());
				}	
			}
			System.out.println();
		}
	
///////////////////////////////////affichage dans le cas  ou aucun utilisateur n'est équipé de ceinture
		if (noneEquiped)
		{
		System.out.println("UTILISATEURS NON ASSOCIES :");
			for(int i=0;i<user.length;i++)
			{
				if (!user[i].isEquiped())
				{
					System.out.println("\t- "+user[i].getUserRef());
				}	
			}
			System.out.println();
		}
		
////////////////////////Affichage dans le cas ou certain user sont équipés et d'autres non
		
		
		if(allEquiped==false && noneEquiped==false)
		{
			System.out.println("UTILISATEURS ASSOCIES :\n");
			for(int i=0;i<user.length;i++)
			{
				if (user[i].isEquiped())
				{
					System.out.println("\t- "+user[i].getUserRef()+"\tSLB ASSOCIEE : "+user[i].getAssociatedDevice());
				}	
			}
			System.out.println();
			System.out.println("UTILISATEURS NON ASSOCIES :\n");
			for(int i=0;i<user.length;i++)
			{
				if (!user[i].isEquiped())
				{
					System.out.println("\t- "+user[i].getUserRef());
				}	
			}
			System.out.println();
		}
		
	}
	
	public void displayStatutDevice(Device[] SLB)
	{
		System.out.println("SMAART LUMBAR BELT DEVICE :");
		for(int i=0;i<SLB.length;i++)
		{
			if (SLB[i].isAvailable())
			{
				if(SLB[i].getCurrentFirmware()==null)
					System.out.println("\t- "+SLB[i].getDeviceRef()+"\tFIRMWARE VERSION : "+SLB[i].getCurrentFirmware()+"\t\tSTATUT : Disponible");
				else
					System.out.println("\t- "+SLB[i].getDeviceRef()+"\tFIRMWARE VERSION : "+SLB[i].getCurrentFirmware()+"\tSTATUT : Disponible");
			}	
			else if(!SLB[i].isAvailable())
			{
				if(!SLB[i].getCurrentFirmware().equals(null))
					System.out.println("\t- "+SLB[i].getDeviceRef()+"\tFIRMWARE VERSION : "+SLB[i].getCurrentFirmware()+"\tSTATUT : En cours d'utilisation");
				else
					System.out.println("\t- "+SLB[i].getDeviceRef()+"\tFIRMWARE VERSION : "+SLB[i].getCurrentFirmware()+"\tSTATUT : En cours d'utilisation");
				}	
		}
		System.out.println();
		
	}
	
	
	public void displayStatut(Firmware[] FW, User[] user,Device[] SLB)
	{
		Display disp= new Display();
		disp.diplayStatutFW(FW);
		disp.displayStatutUser(user);
		disp.displayStatutDevice(SLB);
	}
	public void diplayMenuPrincipal()
	{	
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("Veuillez selectionner une action :\n\t1-Declarer une SLB\n\t2-Associer un patient à une SLB\n\t3-Dissocier un patient et une SLB\n\t4-Mettre à jour une SLB\n\t0-EXIT\n");
	}
}
