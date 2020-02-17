
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito extends KirjanpitoRajapinta {

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
}
