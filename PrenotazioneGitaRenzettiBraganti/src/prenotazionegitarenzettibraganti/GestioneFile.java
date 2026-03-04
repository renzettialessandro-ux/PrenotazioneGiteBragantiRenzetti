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
    private int dimRecord=28;
    public GestioneFile(){
        
    }
    public String aggiustaLunghezzaStringa(String s) {
        String aggiustata=s;
        if (s.length() < 20) {
            for (int i = 0; i < (20 - s.length()); i++) {
                aggiustata += "*";
            }
            return aggiustata;
        } else if (s.length() > 20) {
            aggiustata = s.substring(0, 19);
            return aggiustata;
        }
        return s;
    }
    public void aggiungiStudenteFile(Studente s){
        try{
            RandomAccessFile file = new RandomAccessFile("studenti.dat", "rw");
            int nRecord = (int) (file.length() / dimRecord);
            file.seek(nRecord *dimRecord);
            file.writeChars(s.getNome());
            file.writeChars(s.getCognome());
            file.writeInt(s.getEta());
            file.writeChars(s.getClasse());
            file.close();
            
            
            
            
            
            
            
            
            
            
        }catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
    public void aggiungiGitaFile(Studente s){
        try{
            RandomAccessFile file = new RandomAccessFile("gite.gay", "rw");
        }catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
}


