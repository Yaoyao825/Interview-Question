package com.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static class Person {
        int birth;
        int death;

        Person(int birth, int death){
            this.birth = birth;
            this.death = death;
        }
    }

    int findYearMostPeopleAlive(List<Person> people, int startYear, int endYear) {
        int years = endYear-startYear+1;

        if(years<1){
            System.out.println("Invalid input: start year should be smaller than end year.");
            return -1;
        }

        int[] birth = new int[years];
        int[] death = new int[years];
        int maxAlive = 0;
        int yearOfMaxAlive = startYear;

        for(Person person:people) {
            birth[person.birth-startYear]++;
            death[person.death-startYear]++;
        }

        for(int i=1;i<years;i++) {
            birth[i] += birth[i - 1];
            death[i] += death[i - 1];
        }

        for(int i=0;i<years;i++) {
            if(maxAlive<(birth[i]-death[i])) {
                maxAlive = birth[i] - death[i];
                yearOfMaxAlive = i + startYear;
            }
        }

        return yearOfMaxAlive;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution.Person person1 = new Solution.Person(1923, 1975);
        Solution.Person person2 = new Solution.Person(1952, 1998);
        Solution.Person person3 = new Solution.Person(1935, 1997);
        Solution.Person person4 = new Solution.Person(1911, 2000);

        List<Solution.Person> people = new ArrayList<>();
        Collections.addAll(people, person1, person2, person3, person4);

        Solution solution = new Solution();
        System.out.println(solution.findYearMostPeopleAlive(people,1900, 2000));
    }
}
