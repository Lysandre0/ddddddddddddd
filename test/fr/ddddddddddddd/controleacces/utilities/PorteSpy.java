package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import jdk.jshell.spi.ExecutionControl;

public class PorteSpy implements PorteInterface {
    public PorteSpy(){
    }

    public PorteSpy(PorteDummy porteDummy) {
        //TODO Auto-generated constructor stub
    }

    private boolean _ouvertureDemandée = false;

    public boolean VérifierOuvertureDemandée() {
        return _ouvertureDemandée;
    }

    @Override
    public void Ouvrir() {
        _ouvertureDemandée = true;
    }
}
