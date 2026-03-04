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

    public GestioneGita() {
        gite=new ArrayList();
    }
    public void aggiungi(Gita g){
        if(g!=null)gite.add(g);
    }
    public void elimina(Gita g){
        if(gite.contains(g))gite.remove(g);
    }
}
