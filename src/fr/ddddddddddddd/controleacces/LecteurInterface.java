package fr.ddddddddddddd.controleacces;

public interface LecteurInterface {
    boolean ADétectéBadge();

    void Bip();

    PorteInterface[] getPortes();

    void Flash(boolean R, boolean G, boolean B);
}
