package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.badge;

public class LecteurFake implements LecteurInterface {
    private final PorteSpy[] _portes;

    public void SimulerDétectionBadge(badge badge, LecteurSpy lecteurSpy) {
        this.SimulerUnBip(lecteurSpy);
        boolean estOK =false;
        boolean estRefus = false;
        boolean estErreur = false;
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
            estOK = true;
        }else{
            this.SimulerUnBip(lecteurSpy);
            estRefus = true;
            
        }
        for(var porte : this.getPortes()) {
            if(!(porte.VérifierOuvertureDemandée())){
                estErreur = true;
            };
        }
        this.SimulerUnFlash(estOK,estRefus,estErreur,lecteurSpy);
    }

    public void SimulerDétectionBadge(badge badge){
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
        }
    }

    public void SimulerUnBip(LecteurSpy LecteurSpy){
        LecteurSpy.Bip();
    }

    public void Bip(){
    }

    public void Flash(boolean T, boolean F, boolean E){ 
    };

    public void SimulerUnFlash(boolean T, boolean F, boolean E, LecteurSpy LecteurSpy){ 
        LecteurSpy.Flash(T, F, E);
    };

    private boolean _aDétectéBadge = false;

    @Override
    public boolean ADétectéBadge() {
        return _aDétectéBadge;
    }

    public LecteurFake(PorteSpy... portesLiées) {
        this._portes = portesLiées;
    }

    @Override
    public PorteSpy[] getPortes() {
        return _portes;
    }
}
