package org.Person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    /*
        CASOS DE PRUEBA
        El programa debe calcular bien la edad media de un grupo de 6 personas con 3 hombres y 3 mujeres
        El programa debe calcular bien la edad media de un grupo de 2 personas con 1 hombre y 1 mujer
        El programa debe calcular bien la edad media con un grupo donde haya 0 hombres
        El programa debe calcular bien la edad media con un grupo donde haya 0 mujeres
        El programa debe calcular lanzar una excepción cuando encuentra un número negativo
        En caso de que haya una persona con género distinto a H o M el programa lanza error
        Al crear un objeto de una persona, sus atributos deben ser los que se pasen por parámetro a la función del constructor.
     */

    Person p;

    @BeforeEach
    void setup(){
        p = new Person("Persona", 20, "H");
    }

    @AfterEach
    void restart(){
        p = null;
    }
    @Test
    void avarageAge(){
        List<Person> personas = new ArrayList<Person>();
        personas.add(new Person("Lucas", 20, "H"));
        personas.add(new Person("Lucia", 30, "M"));
        personas.add(new Person("Antonio", 16, "H"));
        personas.add(new Person("Juan", 26, "H"));
        personas.add(new Person("Maria", 20, "M"));
        personas.add(new Person("Juana", 25, "M"));

        double[] expectedValue = new double[2];
        expectedValue[1] = (double) (30+20+25)/3;
        expectedValue[0] = (double) (20+16+26)/3;


        assertEquals(expectedValue[0], p.avarageAgePerGender(personas)[0]);
        assertEquals(expectedValue[1], p.avarageAgePerGender(personas)[1]);
    }

    @Test
    void soloUnaPersonaDeCadaGenero(){
        List<Person> personas = new ArrayList<Person>();
        personas.add(new Person("Lucas", 20, "H"));
        personas.add(new Person("Lucia", 30, "M"));

        double[] expectedValue = new double[2];
        expectedValue[1] = (double) 30;
        expectedValue[0] = (double) 20;

        assertEquals(expectedValue[0], p.avarageAgePerGender(personas)[0]);
        assertEquals(expectedValue[1], p.avarageAgePerGender(personas)[1]);
    }

    @Test
    void noHayHombres(){
        List<Person> personas = new ArrayList<Person>();
        personas.add(new Person("Lucia", 30, "M"));

        double[] expectedValue = new double[2];
        expectedValue[1] = (double) 30;
        expectedValue[0] = (double) 0;

        assertEquals(expectedValue[0], p.avarageAgePerGender(personas)[0]);
        assertEquals(expectedValue[1], p.avarageAgePerGender(personas)[1]);
    }

    @Test
    void noHayMujeres(){
        List<Person> personas = new ArrayList<Person>();
        personas.add(new Person("Lucas", 20, "H"));

        double[] expectedValue = new double[2];
        expectedValue[1] = (double) 0;
        expectedValue[0] = (double) 20;

        assertEquals(expectedValue[0], p.avarageAgePerGender(personas)[0]);
        assertEquals(expectedValue[1], p.avarageAgePerGender(personas)[1]);
    }

    @Test
    void edadNegativa(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person("Lucas", -1, "H");
        });
        assertEquals("Edad negativa", exception.getMessage());
    }

    @Test
    void generoNoExistente(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person("Lucia", 30, "F");
        });
        assertEquals("Genero no existente", exception.getMessage());
    }

    @Test
    void nombreNulo(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person(null, 30, "M");
        });
        assertEquals("Nombre nulo", exception.getMessage());
    }
    @Test
    void testConstructor(){
        Person p1 = new Person("Lucas", 20, "H");
        assertEquals(20, p1.age());
        assertEquals("H", p1.gender());
        assertEquals("Lucas", p1.name());
    }

    @Test
    void getterNombre(){
        Person p1 = new Person("Lucas", 20, "H");
        assertEquals("Lucas", p1.name());
    }

    @Test
    void getterEdad(){
        Person p1 = new Person("Lucas", 20, "H");
        assertEquals(20, p1.age());
    }

    @Test
    void getterGenero(){
        Person p1 = new Person("Lucas", 20, "H");
        assertEquals("H", p1.gender());
    }
}
