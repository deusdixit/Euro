package de.materna.currency;

import java.text.DecimalFormat;

public class Euro {

    private final double wert;
    private final DecimalFormat df = new DecimalFormat( "###.## €" );


    private Euro(double value) {
        if ( value < 0 ) {
            throw new IllegalArgumentException("Keine negativen Werte erlaubt.");
        }
        this.wert = value;
    }

    // Erzeugen von immutable Euro-Objekten durch Fabrikmethode
    public static Euro of(double value) {
        return new Euro(value);
    }

    // erfragt den Wert
    public double value() {
        return this.wert;
    }

    public String toString() {
        return df.format( value() );
    }

    // Euro-Objekte soll man mit equals(Object o) vergleichen können
    public boolean equals(Object o) {
        if ( o instanceof Euro euro) {
            return value() == euro.value();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Double.hashCode( value() );
    }

    public Euro add(Euro euro) {
        return new Euro(value()+euro.value());
    }

    public Euro subtract(Euro euro) {
        return new Euro(value()-euro.value());
    }

}
