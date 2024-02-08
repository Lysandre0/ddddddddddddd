package fr.ddddddddddddd.controleacces.utilities;

import java.lang.reflect.Array;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import jdk.jshell.spi.ExecutionControl;
import fr.ddddddddddddd.controleacces.flash;

public class LecteurSpy implements LecteurInterface {
    private int nombreDeBip = 0;
    private boolean _aDétectéBadge = false;
    private flash couleurFlash = new flash("violet", 2);

    @Override
    public boolean ADétectéBadge() {
        return _aDétectéBadge;
    }

    public int getNombreDeBip(){
        return this.nombreDeBip;
    }

    public void SimulerUnBip(){
        this.nombreDeBip++;
    }

    @Override
    public void Bip() {
        this.SimulerUnBip();
    }
    @Override
    public void Flash(boolean T, boolean F, boolean E){
      if(E){this.couleurFlash.SetCouleur("violet"); this.couleurFlash.SetOccurrence(2);}
      else if(F){this.couleurFlash.SetCouleur("rouge"); this.couleurFlash.SetOccurrence(1);}
      else if(T){this.couleurFlash.SetCouleur("vert"); this.couleurFlash.SetOccurrence(1);}
    };

    public flash getFlash(){
        return this.couleurFlash;
    }
    public String getCouleurFlash(){
        return this.couleurFlash.GetCouleur();
    }
    public int getOccurrenceFlash(){
        return this.couleurFlash.GetOccurrence();
    }

    @Override
    public PorteInterface[] getPortes() {
        throw new UnsupportedOperationException("Unimplemented method 'getPortes'");
    }
    
}
