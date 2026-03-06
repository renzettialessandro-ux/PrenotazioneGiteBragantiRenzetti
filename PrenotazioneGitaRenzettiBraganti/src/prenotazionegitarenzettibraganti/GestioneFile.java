/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prenotazionegitarenzettibraganti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author renzetti.alessandro
 */
public class GestioneFile {

    private int dimRecordStudente = 126;
    private int dimRecordGita = 46;

    public GestioneFile() {
    }

    
    public String aggiustaLunghezzaStringa(String s) {
        String aggiustata = s;
        if (s.length() < 20) {
            for (int i = 0; i < (20 - s.length()); i++) {
                aggiustata += "*";
            }
            return aggiustata;
        } else if (s.length() > 20) {
            aggiustata = s.substring(0, 20);
            return aggiustata;
        }
        return s;
    }

    public Studente cercaStudenteById(String idCercato) {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.gay", "r");
            int nRecord = (int) (file.length() / dimRecordStudente);
            for (int i = 0; i < nRecord; i++) {
                file.seek(i * dimRecordStudente);
                String nome = "";
                for (int j = 0; j < 20; j++) {
                    nome += file.readChar();
                }
                nome = nome.replace("*", "").trim();
                String cognome = "";
                for (int j = 0; j < 20; j++) {
                    cognome += file.readChar();
                }
                cognome = cognome.replace("*", "").trim();
                String id = "";
                for (int j = 0; j < 3; j++) {
                    id += file.readChar();
                }
                id = id.replace("*", "").trim();
                String classe = "";
                for (int j = 0; j < 20; j++) {
                    classe += file.readChar();
                }
                classe = classe.replace("*", "").trim();
                if (id.equals(idCercato)) {
                    file.close();
                    return new Studente(nome, cognome, id, classe);
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Errore lettura studenti");
        }
        return null;
    }

    public void aggiungiGitaFile(Gita g) {
        try {
            RandomAccessFile file = new RandomAccessFile("gite.gay", "rw");
            int nRecord = (int) (file.length() / dimRecordGita);
            file.seek(nRecord * dimRecordGita);
            file.writeChars(aggiustaLunghezzaStringa(g.getNome()));
            file.writeChars(g.getId());
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }

    public void aggiungiStudenteFile(Studente s) {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.gay", "rw");
            int nRecord = (int) (file.length() / dimRecordStudente);
            file.seek(nRecord * dimRecordStudente);
            file.writeChars(aggiustaLunghezzaStringa(s.getNome()));    // 20 char = 40 byte
            file.writeChars(aggiustaLunghezzaStringa(s.getCognome())); // 20 char = 40 byte
            file.writeChars(s.getId());                                // 3 char  =  6 byte
            file.writeChars(aggiustaLunghezzaStringa(s.getClasse())); // 20 char = 40 byte
            file.close();                                              // totale  = 126 byte
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }

    public ArrayList<Gita> leggiFileGita() {
        ArrayList<Gita> lista = new ArrayList<>();
        try {
            RandomAccessFile file = new RandomAccessFile("gite.gay", "r");
            int nRecord = (int) (file.length() / dimRecordGita);
            int recordAttuale = 0;
            while (recordAttuale < nRecord) {
                file.seek(recordAttuale * dimRecordGita);
                String nome = "";
                for (int i = 0; i < 20; i++) {
                    nome += file.readChar();
                }
                nome = nome.replace("*", "").trim();
                String id = "";
                for (int i = 0; i < 3; i++) {
                    id += file.readChar();
                }
                id = id.replace("*", "").trim();
                lista.add(new Gita(nome, id));
                recordAttuale++;
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
        return lista;
    }

    public void aggiungiCombinazione(String idStudente, String idGita) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("combinazioni.txt", true);
            fw.write(idStudente + ";" + idGita + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Errore scrittura combinazioni");
        }
    }

    public ArrayList<String> leggiStudentiPerGita(String idGita) {
        ArrayList<String> idStudenti = new ArrayList<>();
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("combinazioni.txt"));
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(";");
                if (parti.length == 2 && parti[1].equals(idGita)) {
                    idStudenti.add(parti[0]);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Errore lettura combinazioni");
        }
        return idStudenti;
    }
}
