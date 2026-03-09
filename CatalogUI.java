package org.example;

import javax.swing.*;
import java.awt.*;

public class CatalogUI extends JFrame {
    private JTextField idField, numeField, prenumeField, medieField;
    private JComboBox<Specializare> specializareBox;
    private JTextArea area;

    private Catalog catalog = new Catalog();

    public CatalogUI() {
        setTitle("Catalog studenti");
        setSize(600,500);
        setLayout(new GridLayout(0,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        idField = new JTextField();
        add(new JLabel("ID"));
        add(idField);

        numeField = new JTextField();
        add(new JLabel("Nume"));
        add(numeField);

        prenumeField = new JTextField();
        add(new JLabel("Prenume"));
        add(prenumeField);

        medieField = new JTextField();
        add(new JLabel("Medie"));
        add(medieField);

        specializareBox = new JComboBox<>(Specializare.values());
        add(new JLabel("Specializare"));
        add(specializareBox);

        JButton adaugaBtn = new JButton("Adauga student");
        add(adaugaBtn);

        JButton sortNumeBtn = new JButton("Sorteaza dupa nume");
        add(sortNumeBtn);

        JButton sortMedieBtn = new JButton("Sorteaza dupa medie");
        add(sortMedieBtn);

        area = new JTextArea();
        area.setEditable(false);
        add(new JScrollPane(area));

        adaugaBtn.addActionListener(e -> adauga());
        sortNumeBtn.addActionListener(e -> sortNume());
        sortMedieBtn.addActionListener(e -> sortMedie());
    }

    private void adauga() {
        try {
            String id = idField.getText();
            String nume = numeField.getText();
            String prenume = prenumeField.getText();
            int medie = Integer.parseInt(medieField.getText());
            Specializare specializare = (Specializare) specializareBox.getSelectedItem();

            Student student = new Student(id, nume, prenume, medie, specializare);
            catalog.add(student);
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void sortNume() {
        try {
            catalog.sorteazaDupaNume();
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void sortMedie() {
        try {
            catalog.sorteazaDupaMedie();
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void refresh() {
        area.setText("");
        for (Person p : catalog.getAll()) {
            area.append(p.format() + "\n");
        }
        idField.setText("");
        numeField.setText("");
        prenumeField.setText("");
        medieField.setText("");
    }

}
