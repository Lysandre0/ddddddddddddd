package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import jdk.jshell.spi.ExecutionControl;

public class PorteSpy implements PorteInterface {
    private final PorteInterface decorated;

    public PorteSpy(){
        this.decorated = this;
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
        decorated.Ouvrir();
    }
}
