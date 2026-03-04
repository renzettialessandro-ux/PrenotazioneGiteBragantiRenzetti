/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prenotazionegitarenzettibraganti;

/**
 *
 * @author renzetti.alessandro
 */
public class PrenotazioneGitaRenzetti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Studente s=new Studente("marco","rossi",18,"4c");
        GestioneFile gf=new GestioneFile();
        gf.aggiungiStudenteFile(s);
    }
    
}
