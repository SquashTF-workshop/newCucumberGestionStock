package concombre;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {
    int lot1;
    int lot2;
    int total;
    String item;
    int itemValue;
    final int minExpected = 5;

    @Etantdonnéque("j'ai {int} lot de marchandises")
    public void j_ai_lot_de_marchandises(int qte) {
        lot1 = qte;
    }

    @Etantdonnéque("j'en récupère {int} autres")
    public void j_en_recupere_autres(int qte) {
        lot2 = qte;
    }

    @Quand("je compte la totalité du stock")
    public void je_compte_la_totalite_du_stock() {
        total = lot1 + lot2;
    }

    @Alors("j'ai au moins {int} lots de marchandise en stock")
    public void j_ai_au_moins_lots_de_marchandise_en_stock(int expected) {
        Assertions.assertTrue(total >= expected, "Il n'y a pas assez de stock");
    }

    @Etantdonnéque("je dois ajouter des {string}")
    public void je_dois_ajouter_des_elements(String newItem) {
        item = newItem;
    }

    @Etantdonnéque("je détermine sa quantité")
    public void je_determine_sa_quantite() {
        switch (item) {
            case "Echelles":
                itemValue = 3;
                break;
            case "Coffres":
                itemValue = 2;
                break;
            case "Planches":
                itemValue = -2;
                break;
            default:
                itemValue = 0;
                break;
        }
    }

    @Quand("je l'ajoute à mon stock")
    public void je_l_ajoute_a_mon_stock() {
        total = lot1 + lot2 + itemValue;
    }

    @Alors("je dois avoir un minimum de marchandises")
    public void je_dois_avoir_un_minimum_de_marchandises() {
        Assertions.assertTrue(total >= minExpected, "Le stock est en dessous de l'attendu, il faut au moins "+ minExpected +" objets en stock, le stock disponible ne contient que "+ total + " objets");
    }
}
