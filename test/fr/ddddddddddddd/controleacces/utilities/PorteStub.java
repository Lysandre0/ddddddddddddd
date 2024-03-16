package fr.ddddddddddddd.controleacces.utilities;
import fr.ddddddddddddd.controleacces.PorteInterface;


public class PorteStub implements PorteInterface {
    public PorteStub(){

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