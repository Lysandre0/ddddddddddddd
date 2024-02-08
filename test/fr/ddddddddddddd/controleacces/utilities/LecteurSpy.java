package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import jdk.jshell.spi.ExecutionControl;

public class LecteurSpy implements LecteurInterface {
    private int nombreDeBip = 0;

    private boolean _aDétectéBadge = false;

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
    public PorteInterface[] getPortes() {
        throw new UnsupportedOperationException("Unimplemented method 'getPortes'");
    }
    
}
