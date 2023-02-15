package org.Person;

import java.util.List;

/*
@author Lucas Colbert Eastgate
*/

public class Person {
    private final String name;1
    private final int age;
    private final String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    public double[] avarageAgePerGender(List<Person> persons) {
        int sumaEdadesHombre;
        int sumaEdadesMujer;
        int numHombres;
        int numMujeres;
        for persona Person in persons{
            if(persona.gender().equals("H")){
                sumaEdadesHombre+=persona.age();
                numHombres++;
            }else{
                sumaEdadesMujer+=persona.age();
                numMujeres++;
            }
        }
        double[] res;
        res[0]=sumaEdadesHombre/numHombres;
        res[1] = sumaEdadesMujer/numMujeres;

        return res;
    }
}
