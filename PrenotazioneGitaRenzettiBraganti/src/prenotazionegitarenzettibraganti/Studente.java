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
    private String classe;
    private Gita gitaScelta;

    public Studente(String nome, String classe, Gita gitaScelta) {
        this.nome = nome;
        this.classe = classe;
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
