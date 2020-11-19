package champollion;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
	Intervention cm, tp,td;
	Salle salle;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
		salle = new Salle("B01",30);
		cm = new Intervention(salle,java,untel,new Date(),2,TypeIntervention.CM);
		tp = new Intervention(salle,uml,untel,new Date(),4,TypeIntervention.TP);
		td = new Intervention(salle,uml,untel,new Date(),4,TypeIntervention.TD);

	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testEnSousService (){
		untel.ajouteEnseignement(uml, 0, 10, 0);
		assertEquals(true,untel.enSousService(), "L'enseignant est en sous-service");
		untel.ajouteEnseignement(uml, 0, 182, 0);
		assertEquals(false,untel.enSousService(), "L'enseignant n'est pas en sous-service");
		untel.ajouteEnseignement(uml, 0, 10, 0);
		assertEquals(false,untel.enSousService(), "L'enseignant n'est pas en sous-service");
	}

	@Test
	public void testAjouterIntervention(){
		untel.ajouterIntervention(cm);
		assertEquals(2*1.5,untel.heuresPlanifiées(), "L'enseignant à un CM de 2h plannifié.");
		untel.ajouterIntervention(tp);
		untel.ajouterIntervention(td);
		assertEquals(2*1.5+4*0.75+4,untel.heuresPlanifiées(), "L'enseignant à un CM de 2h plannifié.");

	}


	
}
