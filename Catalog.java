package org.example;

import java.util.*;

public class Catalog {
    public List<Person> persoane = new ArrayList<>();
    public Map<String, Person> map = new HashMap<>();

    public void add(Person persoana) throws DuplicatePersonException {
        if (map.containsKey(persoana.getId())) {
            throw new DuplicatePersonException("Persoana duplicata");
        }
        persoane.add(persoana);
        map.put(persoana.getId(), persoana);
    }

    public void remove(String id) throws PersonNotFoundException {
        Person persoana = map.get(id);
        if (persoana == null) {
            throw  new PersonNotFoundException("persoana negasita");
        }
        persoane.remove(persoana);
        map.remove(id);
    }

    public List<Person> cautaDupaNume(String nume) {
        List<Person> result = new ArrayList<>();

        for (Person p : persoane) {
            Student s = (Student) p;
            if (s.getNume().toLowerCase().contains(nume.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Person> sorteazaDupaNume() {
        List<Person> sortat = new ArrayList<>(persoane);
        Collections.sort(sortat, new NumeComparator());
        return sortat;
    }

    public List<Person> sorteazaDupaMedie() {
        List<Person> sortat = new ArrayList<>(persoane);
        Collections.sort(sortat, new MedieComparator());
        return sortat;
    }

    public List<Person> getAll() {
        return new ArrayList<>(persoane);
    }
}
