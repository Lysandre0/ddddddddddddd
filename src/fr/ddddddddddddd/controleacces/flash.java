package fr.ddddddddddddd.controleacces;

public class flash {
    private boolean R;
    private boolean G;
    private boolean B;

    public flash (boolean R, boolean G, boolean B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public void SetCouleur(boolean R, boolean G, boolean B){
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public void SetFlash(boolean R, boolean G, boolean B){
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public Boolean GetR(){
        return this.R;
    }
    public Boolean GetG(){
        return this.G;
    }
    public Boolean GetB(){
        return this.B;
    }
    public flash GetFlash(){
        return this;
    }

    public int GetOccurence(){
        if(this.R && this.B){
            return 2;
        }else{
            return 1;
        }
    }
    
}
