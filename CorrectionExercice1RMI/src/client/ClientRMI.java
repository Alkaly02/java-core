package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import interfaces.Calculatrice;


public class ClientRMI {
	enum ARITHMETIQUE_OPERATIONS{
		addition,
		soustraction,
		multiplication,
		division
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registryClient = LocateRegistry.getRegistry("localhost", 5555);
			Calculatrice serviceCalculatrice = (Calculatrice)registryClient.lookup("CalculatriceService");
			
			Scanner scn = new Scanner(System.in);	
			System.out.print("Donner le premier nombre: ");
			int a = scn.nextInt();
			System.out.print("Donner le deuxieme nombre: ");
			int b = scn.nextInt();
			System.out.print("Quelle opeation souhaitez vous faire? :");
			String userAnswer = scn.next();
			ARITHMETIQUE_OPERATIONS desiredOperation = findByName(userAnswer);
			
			Boolean isOperationPossible = false;
			
			for(ARITHMETIQUE_OPERATIONS operation: ARITHMETIQUE_OPERATIONS.values()) {
				if(operation.equals(desiredOperation)) {
					isOperationPossible = true;
				}
			}
			
			if(!isOperationPossible) {
				System.out.println("Veuillez choisir une operation arithmetique "+ ARITHMETIQUE_OPERATIONS.values());
			}else {
				String answer = new String();
				answer = switch (desiredOperation) {
					case addition ->{
						yield "L'addition de " + a + "+"+ b +"="+serviceCalculatrice.addition(a, b);
					}
					case soustraction ->{
						yield "La soustraction de "+a+"-"+b+"="+serviceCalculatrice.soustraction(a, b);
					}
					case multiplication ->{
						yield "La multiplication de "+a+"*"+b+"="+serviceCalculatrice.multiplication(a, b);
					}
					case division ->{
						yield "La division de "+a+"/"+b+"="+serviceCalculatrice.division(a, b);
					}
				};
				System.out.println(answer);
			}
			scn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ARITHMETIQUE_OPERATIONS findByName(String name) {
		ARITHMETIQUE_OPERATIONS result = null;
	    for (ARITHMETIQUE_OPERATIONS direction : ARITHMETIQUE_OPERATIONS.values()) {
	        if (direction.name().equalsIgnoreCase(name)) {
	            result = direction;
	            break;
	        }
	    }
	    return result;
	}

}
