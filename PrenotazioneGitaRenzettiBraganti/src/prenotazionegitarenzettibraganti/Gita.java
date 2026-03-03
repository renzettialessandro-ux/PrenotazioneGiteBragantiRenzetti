/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prenotazionegitarenzettibraganti;

import java.util.*;

/**
 *
 * @author renzetti.alessandro
 */
public class Gita {
    private ArrayList<Studente>partecipanti;
    private String nome;
    private String id;

    public Gita(String id, String nome) {
        this.id = id;
        this.nome = nome;
        partecipanti=new ArrayList();
    }

    public ArrayList<Studente> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(ArrayList<Studente> partecipanti) {
        this.partecipanti = partecipanti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void aggiungi(Studente s){
        if(s!=null)partecipanti.add(s);
    }
    public void elimina(Studente s){
        if(partecipanti.contains(s))partecipanti.remove(s);
    }

    @Override
    public String toString() {
        return "Gita{" + "partecipanti=" + partecipanti + ", id=" + id + '}';
    }
    
}
