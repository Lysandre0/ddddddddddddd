import fr.ddddddddddddd.controleacces.MoteurOuverture;
import fr.ddddddddddddd.controleacces.badge;
import fr.ddddddddddddd.controleacces.flash;
import fr.ddddddddddddd.controleacces.utilities.LecteurFake;
import fr.ddddddddddddd.controleacces.utilities.PorteSpy;
import fr.ddddddddddddd.controleacces.utilities.LecteurSpy;
import fr.ddddddddddddd.controleacces.utilities.PorteDummy;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

public class ControleAccesTest {
    @Test
    public void TestOk(){
        assertTrue(true);
    }

    @Test
    public void CasNominal() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);

        // QUAND un badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte est deverrouillée
        assertTrue(porteSpy.VérifierOuvertureDemandée());
    }

    @Test
    public void CasSansInterrogation(){
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);

        // QUAND un badge est passé devant le lecteur sans que le lecteur ne soit interrogé
        lecteurFake.SimulerDétectionBadge(badge);

        // ALORS la porte n'est pas deverrouillée
        assertFalse(porteSpy.VérifierOuvertureDemandée());
    }

    @Test
    public void CasSansDétection(){
        // ETANT DONNE un lecteur relié à une porte
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);

        // QUAND on interroge ce lecteur sans qu'il ait détecté un badge
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte n'est pas deverrouillée
        assertFalse(porteSpy.VérifierOuvertureDemandée());
    }

    @Test
    public void CasPlusieursPortes(){
        // ETANT DONNE un lecteur relié à deux portes
        var badge = new badge(false);
        var porteSpy1 = new PorteSpy();
        var porteSpy2 = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy1, porteSpy2);

        // QUAND un badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS les portes sont deverrouillées
        assertTrue(porteSpy1.VérifierOuvertureDemandée());
        assertTrue(porteSpy2.VérifierOuvertureDemandée());
    }

    @Test
    public void CasPlusieursLecteurs() {
        // ETANT DONNE plusieurs lecteurs reliés à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake1 = new LecteurFake(porteSpy);
        var lecteurFake2 = new LecteurFake(porteSpy);

        // QUAND un badge est passé devant le deuxième lecteur
        lecteurFake2.SimulerDétectionBadge(badge);

        // ET que ces lecteurs sont interrogés
        MoteurOuverture.InterrogerLecteurs(lecteurFake1, lecteurFake2);

        // ALORS la porte est deverrouillée
        assertTrue(porteSpy.VérifierOuvertureDemandée());
    }

    @Test
    public void CasPlusieursLecteursPlusieursPortes() {
        // ETANT DONNE plusieurs lecteurs reliés chacun à leur porte
        var badge = new badge(false);
        var porteSpy1 = new PorteSpy();
        var porteSpy2 = new PorteSpy();
        var lecteurFake1 = new LecteurFake(porteSpy1);
        var lecteurFake2 = new LecteurFake(porteSpy2);

        // QUAND un badge est passé devant le deuxième lecteur
        lecteurFake2.SimulerDétectionBadge(badge);

        // ET que ces lecteurs sont interrogés
        MoteurOuverture.InterrogerLecteurs(lecteurFake1, lecteurFake2);

        // ALORS seule la deuxième porte s'ouvre
        assertTrue(porteSpy2.VérifierOuvertureDemandée());
        assertFalse(porteSpy1.VérifierOuvertureDemandée());
    }

    @Test
    public void CasNominalBadgeBloqué(){
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(true);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
    
        // QUAND un badge est passé devant le lecteur 
        // ET que ce badge est inactif
        lecteurFake.SimulerDétectionBadge(badge);
    
        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte est verouillée
        assertFalse(porteSpy.VérifierOuvertureDemandée());
    };

    @Test
    public void CasBadgeChangementÉtatDébloqué () {
        // ETANT DONNE un badge bloqué
        var badge = new badge(true);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
    
        // QUAND le badge est débloqué puis passé devant le lecteur
        badge.setEstBloqué(false);
        lecteurFake.SimulerDétectionBadge(badge);
    
        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte est déverouillée
        assertTrue(porteSpy.VérifierOuvertureDemandée());
    }
    
    @Test
    public void CasBadgeChangementÉtatBloqué () {
        // ETANT DONNE un badge débloqué
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);

        // QUAND le badge est bloqué puis passé devant le lecteur
        badge.setEstBloqué(true);
        lecteurFake.SimulerDétectionBadge(badge);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte est verouillée
        assertFalse(porteSpy.VérifierOuvertureDemandée());
    }

    @Test
    public void CasLecteurBipErreur() {
        // ETANT DONNE un badge bloqué
        var badge = new badge(true);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);
        
        // ALORS le lecteur émets deux bips
        assertEquals(LecteurSpy.verifieNombreDeBip(),2);
    }

    @Test
    public void CasLecteurBip() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS le lecteur émets un bip
        assertEquals(LecteurSpy.verifieNombreDeBip(),1);
    }

    @Test
    public void CasSansDétectionBip(){
        // ETANT DONNE un lecteur relié à une porte
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();

        // QUAND on interroge ce lecteur sans qu'il ait détecté un badge
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS la porte n'est pas deverrouillée
        assertEquals(LecteurSpy.verifieNombreDeBip(),0);
    }

    @Test
    public void CasPlusieursLecteursBip() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake1 = new LecteurFake(porteSpy);
        var lecteurFake2 = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();
        var LecteurSpy2 = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake1.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake1);

        // ALORS les autres lecteurs n'émettent pas de bip
        assertEquals(LecteurSpy2.verifieNombreDeBip(),0);
    }


    @Test
    public void CasLecteurFlashOK() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var porteSpy = new PorteSpy();
        var lecteurFake = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS le lecteur émet un flash vert
        flash flashOK = new flash("vert", 1);
        assertEquals(LecteurSpy.getCouleurFlash(), flashOK.GetCouleur());
        assertEquals(LecteurSpy.getOccurrenceFlash(), flashOK.GetOccurrence());
    }

    @Test
    public void CasLecteurFlashRefus() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(true);
        var porteSpy = new PorteSpy();
        var lecteurFake1 = new LecteurFake(porteSpy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake1.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake1);

        // ALORS le lecteur émet un flash rouge
        flash flashRefus = new flash("rouge", 1);
        assertEquals(LecteurSpy.getCouleurFlash(), flashRefus.GetCouleur());
        assertEquals(LecteurSpy.getOccurrenceFlash(), flashRefus.GetOccurrence());

    }

    @Test
    public void CasLecteurFlashErreur() {
        // ETANT DONNE un lecteur relié à une porte
        var badge = new badge(false);
        var PorteDummy = new PorteSpy(new PorteDummy());
        var lecteurFake = new LecteurFake(PorteDummy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS le lecteur émet 2 flash violet
        flash flashErreur = new flash("violet", 2);
        assertEquals(LecteurSpy.getCouleurFlash(), flashErreur.GetCouleur());
        assertEquals(LecteurSpy.getOccurrenceFlash(), flashErreur.GetOccurrence());
    }

    @Test
    public void CasLecteurFlashErreurBadgeBloqué() {
        // ETANT DONNE un lecteur relié à une porte ET un badge bloqué
        var badge = new badge(true);
        var PorteDummy = new PorteSpy(new PorteDummy());
        var lecteurFake = new LecteurFake(PorteDummy);
        var LecteurSpy = new LecteurSpy();

        // QUAND le badge est passé devant le lecteur
        lecteurFake.SimulerDétectionBadge(badge,LecteurSpy);

        // ET que ce lecteur est interrogé
        MoteurOuverture.InterrogerLecteurs(lecteurFake);

        // ALORS le lecteur émet 2 flash violet
        flash flashErreur = new flash("violet", 2);
        assertEquals(LecteurSpy.getCouleurFlash(), flashErreur.GetCouleur());
        assertEquals(LecteurSpy.getOccurrenceFlash(), flashErreur.GetOccurrence());
    }
}
