package fr.thuasne;
import java.util.Scanner;
public class ThuasneProject {

	public static void main(String[] args) {
		
		 int choix=0;
		Scanner sc= new Scanner(System.in);
		
		Controller ctrl=new Controller();
		User[] user = new User[3];
		
		user[0]= new User("User-01");
		user[1]= new User("User-02");
		user[2]= new User("User-03");
		
		Firmware[] FW = new Firmware[2];
		
		FW[0]= new Firmware("FW-01");
		FW[1]= new Firmware("FW-02");
		
		Device[] SLB= new Device[3];
		
		SLB[0]=new Device("SLB-01");
		SLB[1]=new Device("SLB-02");
		SLB[2]=new Device("SLB-03");
				
		
		ctrl.menuPrincipal(user, SLB, FW);
		
		

	}

}
