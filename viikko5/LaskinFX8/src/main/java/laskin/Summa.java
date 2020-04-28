package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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