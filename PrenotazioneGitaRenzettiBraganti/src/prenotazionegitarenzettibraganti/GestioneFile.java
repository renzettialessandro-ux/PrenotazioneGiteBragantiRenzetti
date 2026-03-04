/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prenotazionegitarenzettibraganti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author renzetti.alessandro
 */
public class GestioneFile {
    private int dimRecordStudente = 124;
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

    public void aggiungiStudenteFile(Studente s) {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.gay", "rw");
            int nRecord = (int) (file.length() / dimRecordStudente);
            file.seek(nRecord * dimRecordStudente);
            file.writeChars(aggiustaLunghezzaStringa(s.getNome()));    
            file.writeChars(aggiustaLunghezzaStringa(s.getCognome())); 
            file.writeInt(s.getEta());                                  
            file.writeChars(aggiustaLunghezzaStringa(s.getClasse()));  
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
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

    public void leggiFileStudente() {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.gay", "r");
            int nRecord = (int) (file.length() / dimRecordStudente);
            if (nRecord > 0) {
                int recordAttuale = 0;
                while (recordAttuale < nRecord) {          
                    file.seek(recordAttuale * dimRecordStudente);
                    String nome = "";
                    for (int i = 0; i < 20; i++) { 
                        nome = nome.replace("*", "");
                        nome += file.readChar();
                    }
                    String cognome = "";
                    for (int i = 0; i < 20; i++) {  
                        cognome = cognome.replace("*", "");
                        cognome += file.readChar();
                    }
                    int eta = file.readInt();                
                    String classe = "";
                    for (int i = 0; i < 20; i++) { 
                        classe = classe.replace("*", "");
                        classe += file.readChar();
                    }
                    System.out.println(nome + " ; " + cognome + " ; " + classe + " ; " + eta);
                    recordAttuale++;                         
                }
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }

    public void leggiFileGita() {
        try {
            RandomAccessFile file = new RandomAccessFile("gite.gay", "r");
            int nRecord = (int) (file.length() / dimRecordGita); 
            if (nRecord > 0) {
                int recordAttuale = 0;
                while (recordAttuale < nRecord) {               
                    file.seek(recordAttuale * dimRecordGita);   
                    String nome = "";
                    for (int i = 0; i < 20; i++) {  
                        nome = nome.replace("*", "");
                        nome += file.readChar();
                    }
                    String id = "";
                    for (int i = 0; i < 3; i++) { 
                        id = id.replace("*", "");
                        id += file.readChar();
                       
                    }
                    System.out.println(nome + " ; " + id);
                    recordAttuale++;                             
                }
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
}