package dat108.eksv21.oppg5;

import javax.swing.JOptionPane;

public class MeldingsboksTraad extends Thread {
	
/*  Tips i oppgavetekst:

	JOptionPane.showMessageDialog(null, "Trykk OK for å avbryte utskriftstråden", 
			"Avbryt", JOptionPane.PLAIN_MESSAGE);	
 */
	private UtskriftsloopTraad t;
	
	public MeldingsboksTraad(UtskriftsloopTraad t) {
		
		this.t = t;
	}
	
	@Override
	public void run() {
		JOptionPane.showMessageDialog(null, "Trykk OK for å avbryte utskriftstråden", 
				"Avbryt", JOptionPane.PLAIN_MESSAGE);
		t.stopp();
		
	}
}
