package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KaartenDoelstelling2 {
	static int a = 0;
	static int geshuffled = 0;
	static List<String> shuffledDeck = new ArrayList<>();
	static List<String> hand = new ArrayList<>();
	static String totaleWaarde = null;
	static List<Integer> totaal = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// Start programma
		System.out.println("Voer \"k\" in voor een nieuwe kaart, \"p\" voor passen of \"q\" om te stoppen.");

		while (true) {
			@SuppressWarnings("resource")
			Scanner invoer = new Scanner(System.in);
			char kaartPakken = invoer.next().charAt(0);
			String kaart = geefKaart(kaartPakken);
			System.out.println(kaart);

			if (totaal.stream().mapToInt(value -> value).sum() >= 22) {
				System.out.println("Helaas, je hebt verloren. De waarde van je kaarten is groter dan 21.");
				System.out.println("De totale waarde van je kaarten is " + totaal.stream().mapToInt(value -> value).sum() + ".");
				System.out.println(hand);
				break;
			}
			if (totaal.stream().mapToInt(value -> value).sum() == 21) {
				System.out.println("Gefeliciteerd, je hebt gewonnen. De waarde van je kaarten is precies 21.");
				System.out.println("De totale waarde van je kaarten is " + totaal.stream().mapToInt(value -> value).sum() + ".");
				System.out.println(hand);
				break;
			}
			if ("Je bent gestopt.".equals(kaart)) {
				break;
			}
		}
	}

	public static String geefKaart(char functie) {

		String foutmelding = "Er gaat iets mis, probeer het opnieuw.";
		
		String[] waardes = { "aas", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "boer", "vrouw", "heer" };
		String[] kleuren = { "Schoppen ", "Harten ", "Klaver ", "Ruiten " };
		List<String> deck = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {

			for (int x = 0; x < 13; x++) {
				String kaart = kleuren[i] + waardes[x];
				deck.add(kaart);
			}
		}
//			System.out.println(deck);

		if(geshuffled == 0) {
			shuffle(deck);
			shuffledDeck = deck;
			geshuffled = 1;
		}

//			System.out.println(shuffledDeck);

		switch (functie) {
			case 'k': {
				String nieuweKaart = shuffledDeck.get(a);
				hand.add(nieuweKaart);
					if(nieuweKaart.contains("aas")) {
						if(totaal.stream().mapToInt(value -> value).sum() + 11 <= 21)
							totaal.add(11);
						else {
							totaal.add(1);
						}
					}
					else if(nieuweKaart.contains("twee")) {
						totaal.add(2);
					}
					else if(nieuweKaart.contains("drie")) {
						totaal.add(3);
					}
					else if(nieuweKaart.contains("vier")) {
						totaal.add(4);
					}
					else if(nieuweKaart.contains("vijf")) {
						totaal.add(5);
					}
					else if(nieuweKaart.contains("zes")) {
						totaal.add(6);
					}
					else if(nieuweKaart.contains("zeven")) {
						totaal.add(7);
					}
					else if(nieuweKaart.contains("acht")) {
						totaal.add(8);
					}
					else if(nieuweKaart.contains("negen")) {
						totaal.add(9);
					}
					else if(nieuweKaart.contains("tien")) {
						totaal.add(10);
					}
					else if(nieuweKaart.contains("boer")) {
						totaal.add(10);
					}
					else if(nieuweKaart.contains("vrouw")) {
						totaal.add(10);
					}
					else if(nieuweKaart.contains("heer")) {
						totaal.add(10);
					}
					else {
						System.out.println("Deze waarde klopt niet.");
					}
				System.out.println(shuffledDeck.get(a));
				a++;
				return "";
			}
			case 'p': {
				System.out.println("Je hebt gepast.");
				System.out.println(hand);
				System.out.println("De totale waarde van je kaarten is " + totaal.stream().mapToInt(value -> value).sum() + ".");
				return "";
			}
			case 'q': {
				return "Je bent gestopt.";
			}
			default: {
				System.out.println("Voer een andere functie in.");
			}
		}
		return foutmelding;
	}

	private static void shuffle(List<String> deck) {
		Collections.shuffle(deck);
	}
}


