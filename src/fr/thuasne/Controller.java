package fr.thuasne;
import java.util.Scanner;
public class Controller {

	public int declarer (User[] usr, Device[] SLB, Firmware[] FW)
	
	{
		Controller ctrl=new Controller();
		int choixSLB, choixFW, numLigne;
		
		Scanner sc = new Scanner(System.in);
		
		///////////////////////////////////////////////////		Choix de la SLB à déclarer		///////////////////////////////////
		
		System.out.println("Veuillez selectionner une Ceinture dans la liste suivante :");
		
		for (int i = 0; i<SLB.length; i++)
		{
			numLigne= i+1;
			System.out.println("\t"+numLigne+"- "+ SLB[i].getDeviceRef() +"\t CURRENT FIRMWARE VERSION : " + SLB[i].getCurrentFirmware());			
		}
		
		System.out.println("\t0- Menu principal");	
		
		choixSLB=sc.nextInt();
		
		if (choixSLB==0)
		{
		ctrl.menuPrincipal(usr, SLB, FW);
		return 0;
		}
		if(choixSLB<0||choixSLB>SLB.length)  
		{												
				System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
					
			ctrl.declarer(usr,SLB, FW);
			return 0;
		} 
		else 
		{
			choixSLB--;
			if (SLB[choixSLB].getCurrentFirmware()!=null)
			{
			System.out.println("ERREUR : "+SLB[choixSLB].getDeviceRef()+" est deja declaré");
			ctrl.declarer(usr,SLB, FW);
			return 0;
			}
		}
			
		
		///////////////////////////////////////////////////		Choix du firmware		///////////////////////////////////
		
		System.out.println("Veuillez selectionner unun firmware dans la liste suivante :");
		
		for (int i = 0; i<FW.length; i++)
		{
			numLigne= i+1;
			
			System.out.println("\t"+numLigne+"- "+ FW[i].getFirmwareVersion() );			
		}
		
		System.out.println("\t0- Menu Declarer");	
		
		choixFW=sc.nextInt();
		
		if(choixFW<=0||choixFW>FW.length)  
		{
			if (choixFW!=0)																
			{
				System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
			}		
			ctrl.declarer(usr,SLB, FW);
			return 0;
		} 
		else 
		{
			choixFW--;
		}
		
		
		///////////////////////////////////////// 		Declaration		///////////////////////////////////////////////////////
		
		if (FW[choixFW].getFirmwareVersion().equals(SLB[choixSLB].getCurrentFirmware()))
			
		{
			System.out.println("KO : "+SLB[choixSLB].getDeviceRef()+" Comporte deja le firmware "+FW[choixFW].getFirmwareVersion());
			ctrl.declarer(usr,SLB, FW);			
			return 0;
		}
		
		else 
		{
			ctrl.newFW(SLB[choixSLB], FW[choixFW]);
			return 0;
		}
		
		

		
	}

	
	
	public void newFW(Device SLB, Firmware FW)
	{
		SLB.setCurrentFirmware(FW.getFirmwareVersion());
	}
	
	
public int miseAJour (Device[] SLB, Firmware[] FW)
	
	{
		Controller ctrl=new Controller();
		int choixSLB, choixFW, numLigne;
		
		Scanner sc = new Scanner(System.in);
		
		///////////////////////////////////////////////////		Choix de la SLB à mettre à jour		///////////////////////////////////
		
		System.out.println("Veuillez selectionner une Ceinture dans la liste suivante :");
		
		for (int i = 0; i<SLB.length; i++)
		{
			numLigne= i+1;
			if(SLB[i].getCurrentFirmware()!=null)
			System.out.println("\t"+numLigne+"- "+ SLB[i].getDeviceRef() +"\t CURRENT FIRMWARE VERSION : " + SLB[i].getCurrentFirmware());			
		}
		
		System.out.println("\t0- Menu principal\nREMARQUE : si une ceinture n'apparait pas dans cette liste, veillez a en avoir prealablement fait la declaration");	
		
		choixSLB=sc.nextInt();
		
		if (choixSLB==0)
		{
			return 0;
		}
		
		else if(choixSLB<0||choixSLB>SLB.length)  
		{
			if (choixSLB!=0)																
			{
				System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
			}		
			ctrl.miseAJour(SLB, FW);
			return 0;
		} 
		else 
		{
			choixSLB--;
			if(SLB[choixSLB].getCurrentFirmware()==null)
			{
				System.out.println("ERREUR : SLB non declaree");
				ctrl.miseAJour(SLB,FW);
				return 0;
			}
		}
			
		
		///////////////////////////////////////////////////		Choix du firmware		///////////////////////////////////
		
		System.out.println("Veuillez selectionner unun firmware dans la liste suivante :");
		
		for (int i = 0; i<FW.length; i++)
		{
			numLigne= i+1;
			
			System.out.println("\t"+numLigne+"- "+ FW[i].getFirmwareVersion() );			
		}
		
		System.out.println("\t0- Menu Mise a jour");	
		
		choixFW=sc.nextInt();
		
		if(choixFW<=0||choixFW>FW.length)  
		{
			if (choixFW!=0)																
			{
				System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
			}		
			ctrl.miseAJour(SLB, FW);
			return 0;
		} 
		else 
		{
			choixFW--;
		}
		
		
		///////////////////////////////////////// 		Mise à jour		///////////////////////////////////////////////////////
		
		if (FW[choixFW].getFirmwareVersion().equals(SLB[choixSLB].getCurrentFirmware()))
			
		{
			System.out.println("ERREUR : "+SLB[choixSLB].getDeviceRef()+" Comporte deja le firmware "+FW[choixFW].getFirmwareVersion());
			ctrl.miseAJour(SLB, FW);
			return 0;
		}
		
		else 
		{
			ctrl.newFW(SLB[choixSLB], FW[choixFW]);
			return 0;
		}
		
		

		
	}

public int  associer(User[] usr, Device[] SLB)
{
	int numLigne, choixUser, choixSLB;
	
	Scanner sc=new Scanner(System.in);
	Controller ctrl=new Controller();
	
	////////////////////////		affichage des user dispo		///////////////////////
	
	System.out.println("veuillez choisir dans la liste des utilisateur disponible :");
	for(int i=0;i<usr.length;i++)
	{
		numLigne=i+1;
		if (!usr[i].isEquiped())
		{
			System.out.println("\t"+numLigne+"- "+usr[i].getUserRef());
		}	
	}
	System.out.println("\t0-Retour menu principal");
	
	////////////////////////		selection user		//////////////////////////////////
	
	choixUser=sc.nextInt();
	
	if(choixUser==0)
	{
		return 0;
	}
	if(choixUser<0||choixUser>usr.length)  
	{
		if (choixUser!=0)																
		{
			System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
		}		
		ctrl.associer(usr,SLB);
		return 0;
	} 
	else 
	{
		choixUser--;
		
		if (usr[choixUser].isEquiped())
		{
		System.out.println("ERREUR : "+usr[choixUser].getUserRef()+" est deja equipé d'une SLB");
		ctrl.associer(usr, SLB);
		return 0;
		}
	}
	
////////////////////////affichage des SLB qui sont dispo et déclarés		///////////////////////
	
System.out.println("veuillez choisir dans la liste des SLB disponible :");
for(int i=0;i<usr.length;i++)
{
numLigne=i+1;
if (SLB[i].isAvailable()&&SLB[i].getCurrentFirmware()!=null)
{
System.out.println("\t"+numLigne+"- "+SLB[i].getDeviceRef());
}	
}
System.out.println("\t0-Retour menu associer");

////////////////////////		selection SLB		//////////////////////////////////

choixSLB=sc.nextInt();

if(choixSLB==0)
{
ctrl.associer(usr, SLB);
return 0;
}
if(choixSLB<0||choixSLB>SLB.length)  
{												
System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
ctrl.associer(usr,SLB);
return 0;
} 
else 
{
choixSLB--;

if (!SLB[choixSLB].isAvailable())
{
System.out.println("ERREUR : "+SLB[choixSLB].getDeviceRef()+" n'est pas disponible");
ctrl.associer(usr, SLB);
return 0;
}
}
	////////////////////////		Association			////////////////////////////////////

	usr[choixUser].setEquiped(true);
	usr[choixUser].setAssociatedDevice(SLB[choixSLB].getDeviceRef());
	
	SLB[choixSLB].setAvailable(false);
	
	return 0;
}

public int dissocier(User[] usr, Device[] SLB)
{
	int numLigne, choixUser, choixSLB;
	
	Scanner sc=new Scanner(System.in);
	Controller ctrl=new Controller();
	
	////////////////////////		affichage des user associés		///////////////////////
	
	System.out.println("veuillez choisir dans la liste des utilisateurs associés:");
	for(int i=0;i<usr.length;i++)
	{
		numLigne=i+1;
		if (usr[i].isEquiped())
		{
			System.out.println("\t"+numLigne+"- "+usr[i].getUserRef()+ "\tSLB : "+usr[i].getAssociatedDevice());
		}	
	}
	System.out.println("\t0-Retour menu principal");
	
	////////////////////////		selection user		//////////////////////////////////
	
	choixUser=sc.nextInt();
	
	if(choixUser==0)
	{
		return 0;
	}
	if(choixUser<0||choixUser>usr.length)  
	{
		if (choixUser!=0)																
		{
			System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
		}		
		ctrl.dissocier(usr,SLB);
		return 0;
	} 
	else 
	{
		choixUser--;
		
		if (!usr[choixUser].isEquiped())
		{
		System.out.println("ERREUR : "+usr[choixUser].getUserRef()+" n'est pas equipé d'une SLB");
		ctrl.dissocier(usr, SLB);
		return 0;
		}
	}
	
////////////////////////affichage des SLB utilisées		///////////////////////
	
System.out.println("veuillez choisir dans la liste des SLB en cours d'utilisation :");
for(int i=0;i<usr.length;i++)
{
numLigne=i+1;
if (!SLB[i].isAvailable())
{
System.out.println("\t"+numLigne+"- "+SLB[i].getDeviceRef());
}	
}
System.out.println("\t0-Retour menu dissocier");

////////////////////////		selection SLB		//////////////////////////////////

choixSLB=sc.nextInt();

if(choixSLB==0)
{
ctrl.dissocier(usr, SLB);
return 0;
}
if(choixSLB<0||choixSLB>SLB.length)  
{												
System.out.println("ERREUR : veulliez selectionner un chiffre du menu");
ctrl.dissocier(usr,SLB);
return 0;
} 
else 
{
choixSLB--;

if (SLB[choixSLB].isAvailable())
{
System.out.println("ERREUR : "+SLB[choixSLB].getDeviceRef()+" n'est pas associée");
ctrl.dissocier(usr, SLB);
return 0;
}
}
	////////////////////////		Dissociation			////////////////////////////////////

if (usr[choixUser].getAssociatedDevice()!=SLB[choixSLB].getDeviceRef())
{
	System.out.println("ERREUR : "+usr[choixUser].getUserRef()+" et "+ SLB[choixSLB].getDeviceRef()+" ne sont pas associés\n");
	ctrl.dissocier(usr, SLB);
	return 0;

}
	usr[choixUser].setEquiped(false);
	usr[choixUser].setAssociatedDevice(null);
	
	SLB[choixSLB].setAvailable(true);
	
	return 0;
}


public void menuPrincipal (User[] usr, Device[] SLB, Firmware[] FW)
{
	Scanner sc=new Scanner(System.in);
	int choix;
	Display disp=new Display();
	Controller ctrl= new Controller();
	
	do {
		
	disp.displayStatut(FW, usr, SLB);
	disp.diplayMenuPrincipal();
	
	do 
	{
		choix=sc.nextInt();
		
		if(choix<0||choix>4)
		{
			System.out.println("ERREUR : Choix non valide, veuillez refaire votre saisie");
		}
	}while (choix<0||choix>4);
	
	switch (choix)
	{
		case 1 :
		{
			ctrl.declarer(usr,SLB,FW);
			break;
		}
		case 2:
		{
			ctrl.associer(usr,SLB);
			break;
		}
		case 3:
		{
			ctrl.dissocier(usr,SLB);
			break;
		}
		
		case 4:
		{
			ctrl.miseAJour(SLB, FW);
			break;
		}
		case 0:
		{
			choix=0;
			disp.fullLine();
			System.out.println("\n\tFIN DU PROGRAMME\n\tMerci de votre utilisation");
			break;
		}
		default:
		{
			System.out.println("ERREUR : Choix non valide, veuillez refaire votre saisie");
			ctrl.menuPrincipal(usr, SLB, FW);
			
			break;
		}
	}
	disp.fullLine();
	}while(choix!=0);
}
}
