/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prenotazionegitarenzettibraganti;

import java.util.ArrayList;

/**
 *
 * @author renzetti.alessandro
 */
public class GestioneGita {
    private ArrayList<Gita>gite;
    private GestioneFile gf= new GestioneFile();
    public GestioneGita() {
        gite=new ArrayList();
    }

    public int getLunghezza() {
        return gite.size();
    }

    public ArrayList<Gita> getGite() {
        return gite;
    }

    public void setGite(ArrayList<Gita> gite) {
        this.gite = gite;
    }

    public GestioneFile getGf() {
        return gf;
    }

    public void setGf(GestioneFile gf) {
        this.gf = gf;
    }
    
    public void aggiungi(Gita g){
        if(g!=null)gite.add(g);
        gf.aggiungiGitaFile(g);
    }
    public void elimina(Gita g){
        if(gite.contains(g))gite.remove(g);
    }
}
