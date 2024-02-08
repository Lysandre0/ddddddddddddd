package fr.ddddddddddddd.controleacces;

public class flash {
    private String couleur;
    private int occurrence;

    public flash (String couleur, int occurrence) {
        this.couleur = couleur;
        this.occurrence = occurrence;
    }

    public void SetCouleur(String couleur){
        this.couleur = couleur;
    }

    public void SetOccurrence(int occurrence){
        this.occurrence = occurrence;
    }

    public void setflash(String couleur, int occurrence){
        this.couleur = couleur;
        this.occurrence = occurrence;
    }

    public String GetCouleur(){
        return this.couleur;
    }

    public int GetOccurrence(){
        return this.occurrence;
    }

    public flash getflash(){
        return this;
    }
    
}
