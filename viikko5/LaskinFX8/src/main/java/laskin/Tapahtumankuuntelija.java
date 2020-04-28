package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Komentotehdas tehdas;
    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {        
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.tehdas = new Komentotehdas(sovellus, tuloskentta, syotekentta, plus, miinus, nollaa, undo);
    }
    
    @Override
    public void handle(Event event) {        
        if (event.getTarget() != undo) {            
            Komento komento = tehdas.hae((Button)event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }                                  
    }

}
