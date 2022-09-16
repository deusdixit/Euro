package de.materna.currency;

import java.text.DecimalFormat;

/**
 * Euro is a class that describes the Euro Currency.
 *
 * This class is immutable and stores the value as double.
 */
public final class Euro {

    private final double wert;
    private final DecimalFormat df = new DecimalFormat( "###.## €" );


    /**
     * Constructs a new Euro instance with the specified value.
     * @param value - the value of the new Euro instance
     */
    private Euro(double value) {
        if ( value < 0 ) {
            throw new IllegalArgumentException("Keine negativen Werte erlaubt.");
        }
        this.wert = value;
    }

    /** Erzeugen von immutable Euro-Objekten durch Fabrikmethode
     *
     * @param value - Value greater than or equal to 0
     * @return - new Instance of Euro with the specified value
     */
    public static Euro of(double value) {
        return new Euro(value);
    }

    /**
     * Gets the value as double
     * @return - value as double
     */
    public double value() {
        return this.wert;
    }

    /**
     * Get the Euro as a string in decimal format ###.## €
     * @return - a String form of Euro
     */
    public String toString() {
        return df.format( value() );
    }

    /**
     * Compares Euro objects to test if they are equal.
     * Double comparison without delta!
     * @param o - the reference object with which to compare
     * @return - true if object is equal
     */
    public boolean equals(Object o) {
        if ( o instanceof Euro euro) {
            return value() == euro.value();
        } else {
            return false;
        }
    }

    /**
     * Get hashcode for the Euro
     * @return - hashcode of the Euro value
     */
    public int hashCode() {
        return Double.hashCode( value() );
    }

    /**
     * Add the value of the Euro to another.
     * @param euro - the Euro to add
     * @return a Euro instance with the resulting value
     */
    public Euro add(Euro euro) {
        return new Euro(value()+euro.value());
    }

    /**
     * Subtracts the value of the Euro to another
     * @param euro - the Euro to subtract
     * @return a Euro instance with the resulting value
     * @throws IllegalArgumentException - if the result is negativ
     */
    public Euro subtract(Euro euro) {
        return new Euro(value()-euro.value());
    }

}
