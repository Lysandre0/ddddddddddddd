package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.badge;

public class LecteurFake implements LecteurInterface {
    private final PorteSpy[] _portes;
    boolean estOk = false;
    boolean estRefus = false;
    LecteurSpy lecteurSpy;

    public void SimulerDétectionBadge(badge badge, LecteurSpy lecteurSpy) {
        this.lecteurSpy = lecteurSpy;
        this.SimulerUnBip(lecteurSpy);
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
            this.estOk = true;
        }else{
            this.SimulerUnBip(lecteurSpy);
            this.estRefus = true;
        }
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

    public void Flash(boolean estOK, boolean estRefus, boolean estErreur){ 
    };

    public void SimulerUnFlash(boolean estErreur){ 
        if(this.lecteurSpy != null){
            this.lecteurSpy.Flash(this.estOk,this.estRefus,estErreur);
        }
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
