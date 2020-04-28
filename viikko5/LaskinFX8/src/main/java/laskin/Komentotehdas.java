package laskin;

import java.util.HashMap;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Komentotehdas {
    private Sovelluslogiikka sovellus;
    
    protected HashMap<Button, Komento> komennot;        
    protected Button plus;
    protected Button miinus;
    protected Button nollaa;
    protected Button undo;
    
    
    public Komentotehdas(Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.sovellus = sovellus;
        this.komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta,  nollaa, undo, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));        
    }
    
    public Komento hae(Button operaatio) {
        return komennot.get(operaatio);
    }
}
