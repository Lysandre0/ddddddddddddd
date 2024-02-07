import unittest
import src.LecteurInterface
import src.MoteurOuverture
import src.PorteInterface

class TestStringMethods(unittest.TestCase):

    def test_upper(self):
        self.assertEqual('foo'.upper(), 'FOO')

    def test_isupper(self):
        self.assertTrue('FOO'.isupper())
        self.assertFalse('Foo'.isupper())

    def test_split(self):
        s = 'hello world'
        self.assertEqual(s.split(), ['hello', 'world'])
        # check that s.split fails when the separator is not a string
        with self.assertRaises(TypeError):
            s.split(2)

    def CasNominal(self):
        # Étant donné un lecteur relié à une porte
        lecteurFake = lecteurFake()
        porteSpy = porteSpy()
        moteurOuverture = moteurOuverture()

        # Lorsque un badge est détecter 
        lecteurFake.SimulerDetectionBadge()

        # Et que ce lecteur est interrogé
        moteurOuverture.InterrogerLecteur(lecteurFake)

        # Alors la porte est déverrouillée
        porteSpy.VérifierOuvertureDemandée()

    # Étant donné un lecteur relié à une porte
    # Lorsque un badge valide mais inactif est détecter 
    # Alors la porte reste fermé

    # Étant donné un lecteur relié à une porte
    # Lorsqu'un badge inactif est détecter 
    # Alors la porte reste fermé

    # Étant donné un lecteur relié à une porte
    # Lorsqu’un badge invalide est détecter 
    # Alors la porte reste fermé															
    # Étant donné que je suis un utilisateur ayant perdu mon badge
    # Lorsque je contacte l’assistance pour signaler la perte de mon badge.
    # Alors le badge devient inactif

    # Étant donné que j’ai retrouvé mon badge
    # Lorsque je contacte l’assistance
    # Alors le badge devient à nouveau actif

    # Étant que le lecteur est en panne
    # Lorsque un badge est détecter 
    # Alors la porte reste verrouillée

    # Etant donné que la porte se referme
    # Lorsque l’utilisateur est passé 
    # Alors le lecteur bloque à nouveau la porte



if __name__ == '__main__':
    unittest.main()