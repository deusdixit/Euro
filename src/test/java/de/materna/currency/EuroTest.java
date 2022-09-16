package de.materna.currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class EuroTest {

    @org.junit.jupiter.api.Test
    void add() {
        Euro e1 = Euro.of( 1.5 );
        Euro e2 = Euro.of( 2.5 );
        assertEquals( e1.add( e2 ), Euro.of( 4.0 ));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Euro e1 = Euro.of( 3.5 );
        Euro e2 = Euro.of( 2.5 );
        assertThat( e1.subtract( e2 ) ).isEqualTo( Euro.of( 1.0 ) );
        assertThatIllegalArgumentException().isThrownBy( () -> e2.subtract( e1 ) );
    }

    @org.junit.jupiter.api.Test
    void exceptions() {
        Euro e1 = Euro.of( 3.5 );
        Euro e3 = Euro.of( 4.0 );
        assertThrows( IllegalArgumentException.class, () -> e1.subtract( e3 ) );
        assertThrows( IllegalArgumentException.class, () -> Euro.of( -1.0 ) );
    }

    @Test
    void print() {
        assertEquals( "2,35 €", Euro.of( 2.345 ).toString() );
        assertThat( Euro.of(3.1234) ).isEqualTo( "3,12 €" );
    }

    @Test
    void doubleDoof() {
        Euro e1 = Euro.of( 1.0/3.0 );
        Euro e2 = Euro.of( 0 );
        for (int i = 0; i < 300; i++) {
            e2 = e2.add(e1);
        }
        assertThat( e2.value() ).isEqualTo( 10 );
    }
}