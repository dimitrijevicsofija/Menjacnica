package menjacnica_interfejs;

import java.util.GregorianCalendar;

import menjacnica.Kurs;
import menjacnica.Valuta;

public interface MenjacnicaInterface {
      public void dodavanjeKursa(Valuta valuta, Kurs kurs);
      public void brisanjeKursa(Valuta valuta, GregorianCalendar datum);
      public Kurs pronalazenjeKursaValute(Valuta valuta, GregorianCalendar datum);
}
