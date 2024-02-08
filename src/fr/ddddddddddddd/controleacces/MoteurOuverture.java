package fr.ddddddddddddd.controleacces;

import fr.ddddddddddddd.controleacces.utilities.LecteurFake;

public class MoteurOuverture {
    public static void InterrogerLecteurs(LecteurFake... lecteurs) {
        for(var lecteur : lecteurs){
        var estErreur = false;
            if(lecteur.ADétectéBadge()){
                for(var porte : lecteur.getPortes()){
                    porte.Ouvrir();
                    if(!porte.VérifierOuvertureDemandée()){
                        estErreur = true;
                    }
                }
            }  
        lecteur.SimulerUnFlash(estErreur);
        }       
    }
}
