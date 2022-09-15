# Aufgabe 2:


1. Lege eine neue Klasse de.materna.currency.Euro an. Sie soll einen Betrag auf zwei Stellen hinter dem Komma speichern. Das Objekt ist immutable.

```
public class Euro {
private Euro() { }
// Erzeugen von immutable Euro-Objekten durch Fabrikmethode
public static Euro of( double value ) { return null; }
// erfragt den Wert
public double value() { return 0; }
public String toString() { return ""; }
// Euro-Objekte soll man mit equals(Object o) vergleichen können
public boolean equals( Object o ) { return false; }
public Euro add( Euro euro ) { return null; }
public Euro subtract( Euro euro ) { return null; }
}
```

2. Schreibe ein kurzes Javadoc und werde dir der Wertebereiche und Ausnahmen bewusst. Negative Beträge müssen über eine Ausnahme abgeblockt werden. 0 ist erlaubt. Das toString-Format ist “###.## €” (nach https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html, beliebige Anzahl Vorkommastellen und 2 Nachkommastellen).
3. Wir wollen eine neue Klasse de.materna.currency.EuroTest anlegen. Wohin kommt die Klasse? Unterstützt uns die IDE?
4. Implementiere passende Testmethoden. Was müssen wir alles testen?
5. Implementiere alle Methoden der Klasse Euro.
6. Sind unsere Datentypen klug gewählt? Müssen wir eine Wahl korrigieren?