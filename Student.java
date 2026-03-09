package org.example;

public class Student implements Person {

    private String id;
    private String nume;
    private String prenume;
    private int medie;
    private Specializare specializare;

    public Student(String id, String nume, String prenume,
                   int medie, Specializare specializare) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id invalid!");
        }
        if (nume == null || nume.isBlank()) {
            throw new IllegalArgumentException("nume invalid!");
        }
        if (prenume == null || prenume.isBlank()) {
            throw new IllegalArgumentException("prenume invalid!");
        }
        if (medie <= 0 || medie > 10) {
            throw new IllegalArgumentException("medie invalida");
        }
        if (specializare == null) {
            throw new IllegalArgumentException("specializare invalida");
        }

        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.medie = medie;
        this.specializare = specializare;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String format() {
        return id + " | " + nume + " | " + prenume +
                " | " + medie + " | " + specializare;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getMedie() {
        return medie;
    }

    public Specializare getSpecializare() {
        return specializare;
    }
}
