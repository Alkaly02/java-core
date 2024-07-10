package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import models.*;

public class MainActivity {
	static public void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
		Date date = sdf.parse("08/07/2024");
		PaiementParCarte paiement1 = new PaiementParCarte(2000, "2240 223 345", date);
		
		paiement1.effectuerPaiement();
		paiement1.afficherDetails();
	}
}
