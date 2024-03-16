package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.PorteInterface;

public class PorteDummy implements PorteInterface {

    @Override
    public void Ouvrir() {
        throw new UnsupportedOperationException("Door can't be open");
    }
    
    public boolean VérifierOuvertureDemandée(){
        return false;
    }

}
