package org.Person;

import java.util.List;

/*
@author Lucas Colbert Eastgate
*/

public class Person {
    private final String name;
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

    public double[] avarageAgePerGender(List<Person> persons){
        double sumaEdadesHombre=0;
        double sumaEdadesMujer=0;
        double numHombres=0;
        double numMujeres=0;
        double mediaHombres;
        double mediaMujeres;
        for (Person persona : persons){
            if(!persona.gender.equals("M") && !persona.gender.equals("H")){
                throw new RuntimeException("Genero no existente");
            }
            if(persona.age<0){
                throw new RuntimeException("Numero negativo");
            }
            if(persona.gender().equals("H")){
                sumaEdadesHombre+=persona.age();
                numHombres++;
            }else if(persona.gender().equals("M")){
                sumaEdadesMujer+=persona.age();
                numMujeres++;
            }
        }
        if(numHombres==0){
            mediaHombres=0;
        }else{
            mediaHombres=sumaEdadesHombre/numHombres;
        }

        if(numMujeres==0){
            mediaMujeres=0;
        }else{
            mediaMujeres = sumaEdadesMujer/numMujeres;
        }

        double[] res= new double[2];
        res[0] = mediaHombres;
        res[1] = mediaMujeres;

        return res;
    }
}
