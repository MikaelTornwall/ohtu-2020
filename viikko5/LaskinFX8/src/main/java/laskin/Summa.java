package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Operaatio;
import laskin.Sovelluslogiikka;

public class Summa extends Operaatio {
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);                
    }
    
    @Override
    public int laske() {
        sovellus.plus(luku);
        return sovellus.tulos();
    }
}