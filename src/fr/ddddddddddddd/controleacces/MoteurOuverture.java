package fr.ddddddddddddd.controleacces;

public class MoteurOuverture {
    public static void InterrogerLecteurs(LecteurInterface... lecteurs) {
        for(var lecteur : lecteurs){
            if(lecteur.ADétectéBadge()){
                for(var porte : lecteur.getPortes()){
                    try {
                        porte.Ouvrir();
                        if(porte.VérifierOuvertureDemandée()){
                            lecteur.Flash(false, true, false);
                        }else{
                            lecteur.Flash(true, false, false);
                        }
                        
                    } catch (Exception e) {
                        lecteur.Flash(true, false, true);
                    }
                }
            }  
        }       
    }
}
