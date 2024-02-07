package fr.ddddddddddddd.controleacces;

public class badgeInterface {
    boolean estBloqué;

    public badgeInterface(boolean estBloqué){
        this.estBloqué = estBloqué;
    }

    public boolean estBloqué(){
        return this.estBloqué;
    }

    public void setEstBloqué(boolean estBloqué){
        this.estBloqué = estBloqué;
    }
}
    
