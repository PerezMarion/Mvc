package com.example.demoThymeleaf.business;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoryService {

    private ArrayList<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }
}