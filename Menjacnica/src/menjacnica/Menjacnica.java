package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica_interfejs.MenjacnicaInterface;

public class Menjacnica implements MenjacnicaInterface {
	private LinkedList<Valuta> valute = new LinkedList<Valuta>();

	public LinkedList<Valuta> getValute() {
		return valute;
	}

	public void setValute(LinkedList<Valuta> valute) {
		if (valute != null)
			this.valute = valute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valute == null) ? 0 : valute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menjacnica other = (Menjacnica) obj;
		if (valute == null) {
			if (other.valute != null)
				return false;
		} else if (!valute.equals(other.valute))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menjacnica [valute=" + valute + "]";
	}

	@Override
	public void dodavanjeKursa(Valuta valuta, Kurs kurs) {
		if (valute.isEmpty() || !valute.contains(valuta))
			System.out.println("U menjacnici ne postoji trazena valuta.");
		else {
			valute.get(valute.indexOf(valuta)).getKursevi().add(kurs);
		}

	}

	@Override
	public void brisanjeKursa(Valuta valuta, GregorianCalendar datum) {
		if (valute.isEmpty() || !valute.contains(valuta))
			System.out.println("U menjacnici ne postoji trazena valuta.");
		else {
			LinkedList<Kurs> pom = valute.get(valute.indexOf(valuta)).getKursevi();
			int a = 1;
			for (int i = 0; i < pom.size(); i++) {
				if (pom.get(i).getDatum().equals(datum)) {
					pom.remove(i);
					a = 0;
				}
				if (a == 0)
					break;
			}
			if (a == 1)
				System.out.println("Kurs za trazeni datum ne postoji u menjacnici.");
			else
				valute.get(valute.indexOf(valuta)).setKursevi(pom);
		}
	}

	@Override
	public Kurs pronalazenjeKursaValute(Valuta valuta, GregorianCalendar datum) {

		if (valute.isEmpty() || !valute.contains(valuta))
			return null;
		else {
			LinkedList<Kurs> pom = valute.get(valute.indexOf(valuta)).getKursevi();

			for (int i = 0; i < pom.size(); i++) {
				if (pom.get(i).getDatum().equals(datum)) {
					return pom.get(i);
				}
			}
		}
		System.out.println("Ne postoji vrednost kursa za trazeni datum.");
		return null;
	}

}
