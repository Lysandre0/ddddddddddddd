package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.badge;

public class LecteurFake implements LecteurInterface {
    private final PorteInterface[] _portes;
    private int nombreDeBip = 0;
    public void SimulerDétectionBadge(badge badge) {
        SimulerUnBip();
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
        }else{
            SimulerUnBip();
        }
    }

    public int getNombreDeBip(){
        return this.nombreDeBip;
    }

    public void SimulerUnBip(){
        this.nombreDeBip++;
    }

    private boolean _aDétectéBadge = false;

    @Override
    public boolean ADétectéBadge() {
        return _aDétectéBadge;
    }

    public LecteurFake(PorteInterface... portesLiées) {
        this._portes = portesLiées;
    }

    @Override
    public PorteInterface[] getPortes() {
        return _portes;
    }
}
