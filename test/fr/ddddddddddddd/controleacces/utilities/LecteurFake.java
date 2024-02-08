package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.badge;

public class LecteurFake implements LecteurInterface {
    private final PorteInterface[] _portes;

    public void SimulerDétectionBadge(badge badge, LecteurSpy lecteurSpy) {
        this.SimulerUnBip(lecteurSpy);
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
        }else{
            this.SimulerUnBip(lecteurSpy);
        }
    }
    public void SimulerDétectionBadge(badge badge){
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
        }
    }

    public void SimulerUnBip(LecteurSpy LecteurSpy){
        LecteurSpy.SimulerUnBip();
    }

    public void Bip(){
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
