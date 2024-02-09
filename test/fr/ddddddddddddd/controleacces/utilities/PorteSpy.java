package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.utilities.PorteStub;
import jdk.jshell.spi.ExecutionControl;

public class PorteSpy implements PorteInterface {
    private final PorteInterface decorated;

    public PorteSpy(){
        this.decorated = new PorteStub();
    }
    public PorteSpy(PorteInterface decorated){
        this.decorated = decorated;
    }
    private boolean _ouvertureDemandée = false;

    public boolean VérifierOuvertureDemandée() {
        return _ouvertureDemandée;
    }

    @Override
    public void Ouvrir() {
        _ouvertureDemandée = true;
        this.decorated.Ouvrir();
    }
}
