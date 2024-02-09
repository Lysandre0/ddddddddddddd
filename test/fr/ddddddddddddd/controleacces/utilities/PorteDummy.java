package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import jdk.jshell.spi.ExecutionControl;

public class PorteDummy implements PorteInterface {

    @Override
    public void Ouvrir() {
        throw new UnsupportedOperationException("Door can't be open");
        }    
}
