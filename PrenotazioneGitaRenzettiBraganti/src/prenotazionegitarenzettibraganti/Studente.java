/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prenotazionegitarenzettibraganti;

import java.util.Objects;

/**
 *
 * @author renzetti.alessandro
 */
public class Studente {
    private String nome;
    private String cognome;
    private int eta;
    private String classe;
    private Gita gitaScelta;

    public Studente(String nome, String cognome, int eta, String classe/* Gita gitaScelta*/) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.classe = classe;
        //this.gitaScelta = gitaScelta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Gita getGitaScelta() {
        return gitaScelta;
    }

    public void setGitaScelta(Gita gitaScelta) {
        this.gitaScelta = gitaScelta;
    }
    

    @Override
    public String toString() {
        return "Studente{" + "nome=" + nome + ", classe=" + classe + ", gitaScelta=" + gitaScelta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.gitaScelta);
        return hash;
    }
    
}
