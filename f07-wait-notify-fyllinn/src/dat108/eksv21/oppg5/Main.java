package dat108.eksv21.oppg5;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		//Her opprettes og startes en tråd som går i en løkke og skriver ut
		//en melding på skjermen ca. hvert sekund helt til tråden avsluttes 
		//på kontrollert måte.
		UtskriftsloopTraad t1 = new UtskriftsloopTraad();
		t1.start();

		//Her opprettes og startes en tråd som viser frem en JOptionPane meldings-
		//boks. Når brukeren trykker på OK-knappen skal utskrifts-tråden få beskjed 
		//om å avslutte, og meldingsboks-tråden vil også være ferdig.
		MeldingsboksTraad t2 = new MeldingsboksTraad(t1);
		t2.start();
		
		System.out.println("Tråder er startet. Venter på at de er ferdige ...");
		
		//Her ventes det på at de andre trådene er ferdige før main avsluttes.
		t1.join();
		t2.join();
		
		System.out.println("Begge tråder er ferdige!");	
		System.out.println("Main-tråd ferdig!");
	}
}