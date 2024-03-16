package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.flash;

public class LecteurSpy implements LecteurInterface {
    private int nombreDeBip = 0;
    private boolean _aDétectéBadge = false;
    private flash couleurFlash = new flash(false,false,false);

    @Override
    public boolean ADétectéBadge() {
        return _aDétectéBadge;
    }

    public int verifieNombreDeBip(){
        return this.nombreDeBip;
    }
    @Override
    public void Bip() {
        this.nombreDeBip++;
    }
    @Override
    public void Flash(boolean R, boolean G, boolean B){
      this.couleurFlash.SetCouleur(R, G, B);
    };

    public flash getFlash(){
        return this.couleurFlash;
    }
    public Boolean GetR(){
        return this.couleurFlash.GetR();
    }
    public Boolean GetG(){
        return this.couleurFlash.GetG();
    }
    public Boolean GetB(){
        return this.couleurFlash.GetB();
    }
    public int GetFlashOccurence(){
        if(this.couleurFlash.GetR() && this.couleurFlash.GetB()){
            return 2;
        }else{
            return 1;
        }
    }

    @Override
    public PorteInterface[] getPortes() {
        throw new UnsupportedOperationException("Unimplemented method 'getPortes'");
    }
    
}
