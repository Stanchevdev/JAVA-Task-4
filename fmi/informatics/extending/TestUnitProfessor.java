package fmi.informatics.extending;

import fmi.informatics.extending.Person;

public abstract class TestUnitProfessor extends Person {
    public static void getPlanetTestUnit(String expectedResult, String result){
        if (Comparison(expectedResult, result)) {
            System.out.println("getPlanet() in class Person returns what is expected");
        } else {
            System.err.println("getPlanet() in class Person returns: " + result + ", but the expected result is: " + expectedResult);
        }

    }

    public static void main(String[] args) {
        String expectedResult = "Earth";
        String result = getPlanet();

        getPlanetTestUnit(expectedResult,result);
    }


    public static boolean Comparison(String expectedResult, String result) {
        return result.equals(expectedResult);
    }


}
