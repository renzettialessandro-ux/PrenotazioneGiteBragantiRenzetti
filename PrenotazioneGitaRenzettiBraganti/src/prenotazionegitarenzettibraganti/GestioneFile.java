package prenotazionegitarenzettibraganti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GestioneFile {

    private int dimRecordStudente = 160;
    private int dimRecordGita = 80;

    public GestioneFile() {
    }

    // Porta qualsiasi stringa a esattamente 20 caratteri (tronca o riempie con *)
    public String aggiustaLunghezza(String s) {
        if (s == null) s = "";
        if (s.length() > 20) return s.substring(0, 20);
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 20) sb.append('*');
        return sb.toString();
    }

    // Rimuove i caratteri di riempimento '*'
    private String pulisci(String s) {
        return s.replace("*", "").trim();
    }

    // Legge esattamente n caratteri dal file
    private String leggiChars(RandomAccessFile file, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(file.readChar());
        return sb.toString();
    }

    // ===================== GITA =====================

    public void aggiungiGitaFile(Gita g) {
        try {
            RandomAccessFile file = new RandomAccessFile("gite.fgm", "rw");
            int nRecord = (int) (file.length() / dimRecordGita);
            file.seek(nRecord * dimRecordGita);
            file.writeChars(aggiustaLunghezza(g.getNome())); 
            file.writeChars(aggiustaLunghezza(g.getId()));  
            file.close();
        } catch (IOException e) {
            System.out.println("Errore scrittura gita: " + e.getMessage());
        }
    }

    public ArrayList<Gita> leggiFileGita() {
        ArrayList<Gita> lista = new ArrayList<>();
        try {
            RandomAccessFile file = new RandomAccessFile("gite.fgm", "r");
            int nRecord = (int) (file.length() / dimRecordGita);
            for (int i = 0; i < nRecord; i++) {
                file.seek(i * dimRecordGita);
                String nome = pulisci(leggiChars(file, 20));
                String id   = pulisci(leggiChars(file, 20));
                lista.add(new Gita(nome, id));
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File gite non trovato");
        } catch (IOException e) {
            System.out.println("Errore lettura gita: " + e.getMessage());
        }
        return lista;
    }

    // ===================== STUDENTE =====================

    public void aggiungiStudenteFile(Studente s) {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.fgm", "rw");
            int nRecord = (int) (file.length() / dimRecordStudente);
            file.seek(nRecord * dimRecordStudente);
            file.writeChars(aggiustaLunghezza(s.getNome()));    
            file.writeChars(aggiustaLunghezza(s.getCognome()));
            file.writeChars(aggiustaLunghezza(s.getId()));      
            file.writeChars(aggiustaLunghezza(s.getClasse())); 
            file.close();
        } catch (IOException e) {
            System.out.println("Errore scrittura studente: " + e.getMessage());
        }
    }

    public Studente cercaStudenteById(String idCercato) {
        try {
            RandomAccessFile file = new RandomAccessFile("studenti.fgm", "r");
            int nRecord = (int) (file.length() / dimRecordStudente);
            for (int i = 0; i < nRecord; i++) {
                file.seek(i * dimRecordStudente);
                String nome    = pulisci(leggiChars(file, 20));
                String cognome = pulisci(leggiChars(file, 20));
                String id      = pulisci(leggiChars(file, 20));
                String classe  = pulisci(leggiChars(file, 20));
                if (id.equals(idCercato)) {
                    file.close();
                    return new Studente(nome, cognome, id, classe);
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Errore lettura studente: " + e.getMessage());
        }
        return null;
    }

    // ===================== COMBINAZIONI =====================

    public void aggiungiCombinazione(String idStudente, String idGita) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("combinazioni.txt", true);
            fw.write(idStudente + ";" + idGita + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Errore scrittura combinazioni: " + e.getMessage());
        }
    }

    public ArrayList<String> leggiStudentiPerGita(String idGita) {
        ArrayList<String> idStudenti = new ArrayList<>();
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("combinazioni.txt"));
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(";");
                if (parti.length == 2 && parti[1].trim().equals(idGita.trim())) {
                    idStudenti.add(parti[0].trim());
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Errore lettura combinazioni: " + e.getMessage());
        }
        return idStudenti;
    }
}
