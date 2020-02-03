package fmi.informatics.events;

import java.util.concurrent.ThreadLocalRandom;

public class PeopleSayHi implements Salute{
    private static String[] people = {"Ivan", "Georgi", "Stoyan", "Petyr", "Dimitur", "Andicha"};
    private String Hello = "Hello people";

    @Override
    public String pickPerson() {
        int pickOne = ThreadLocalRandom.current().nextInt(0, people.length);
        String person = people[pickOne];
        SayHi(person, pickOne);
        return "Hello people";
    }


    @Override
    public void SayHi(String person, int index) {
        System.out.println(person + " says " + Hello);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<index; i++){
            sb.append(people[i]);
            sb.append(" says Hi! \n");
        }
        for (int j=index+1; j<people.length; j++){
            sb.append(people[j]);
            sb.append(" says Hi! \n");
        }
        System.out.println(sb);

    }



}
