package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Operaatio extends Komento {
    protected int luku;   
    protected int tulos;
    protected int edellinen = 0;
    
    public Operaatio(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        try {
            this.luku = Integer.valueOf(syotekentta.getText());               
        } catch (Exception e) {
            this.luku = 0;
        }       
        
        this.edellinen = sovellus.tulos();
        syotekentta.setText("");        
        this.tulos = laske();
        tuloskentta.setText(Integer.toString(tulos));
        
        if (this.tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinen);        
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        
        if (this.tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        undo.disableProperty().set(true);     
    }
    
    protected abstract int laske();
}
