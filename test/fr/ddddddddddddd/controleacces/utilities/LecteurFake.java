package fr.ddddddddddddd.controleacces.utilities;

import fr.ddddddddddddd.controleacces.LecteurInterface;
import fr.ddddddddddddd.controleacces.PorteInterface;
import fr.ddddddddddddd.controleacces.badgeInterface;

public class LecteurFake implements LecteurInterface {
    private final PorteInterface[] _portes;

    public void SimulerDétectionBadge(badgeInterface badge) {
        if(!(badge.estBloqué())){
            _aDétectéBadge = true;
        }
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
