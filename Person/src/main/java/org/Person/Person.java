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

    public double[] avarageAgePerGender(List<Person> persons) {
        return null;
    }
}
