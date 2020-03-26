
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    // aloitustalukon koko
    public final static int KOKO = 5; 
    // luotava uusi taulukko on näin paljon isompi kuin vanha
    public final static int LISAYS = 5;  

    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.    
    private int indeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 
    

    public IntJoukko() {
        this(KOKO, LISAYS);                
    }        

    public IntJoukko(int koko) {
        this(koko, LISAYS);                
    }
    
    
    public IntJoukko(int koko, int kasvatuskoko) {
        if (koko < 0 || kasvatuskoko < 0) throw new IndexOutOfBoundsException();        
        this.lukujono = new int[koko];            
        this.kasvatuskoko = kasvatuskoko;
        alustaJoukko();    
    }
    
    public void alustaJoukko() {
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
    }
    
    public int getKoko() {
        return indeksi;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) return false;        
        
        lukujono[indeksi] = luku;
        indeksi++;
        
        if (indeksi % lukujono.length == 0) kasvata();
        
        return true;                
    }
    
    public void lisaa(int[] joukko) {
        for (int i = 0; i < joukko.length; i++) lisaa(joukko[i]);
    }

    public boolean kuuluu(int luku) {                               
        for (int i = 0; i < indeksi; i++) {
            if (lukujono[i] == luku) return true;                            
        }
        return false;
    }

    public boolean poista(int luku) {                         
        for (int i = 0; i < indeksi; i++) {
            if (lukujono[i] == luku) {
                for (int j = i; j < indeksi - 1; j++) {
                    lukujono[j] = lukujono[j + 1];
                }
                indeksi--;
                return true;
            }
        }        
        return false;       
    }

    private void kasvata() {
        int[] uusiTaulukko = new int[indeksi + kasvatuskoko];
        
        for (int i = 0; i < lukujono.length; i++) {
            uusiTaulukko[i] = lukujono[i];
        }
        lukujono = uusiTaulukko;
    }

    public int[] toIntArray() {
        return Arrays.copyOf(lukujono, indeksi);        
    }
   

    public static IntJoukko yhdiste(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko joukko = new IntJoukko();
        joukko.lisaa(ensimmainen.toIntArray());
        joukko.lisaa(toinen.toIntArray());
        return joukko;
    }

    public static IntJoukko leikkaus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko joukko = new IntJoukko();                                                
        for (int luku : toinen.toIntArray()) {
            if (ensimmainen.kuuluu(luku)) joukko.lisaa(luku);                         
        }  
        return joukko;
    }
    
    public static IntJoukko erotus (IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko joukko = new IntJoukko();                                                
        for (int luku : ensimmainen.toIntArray()) {
            if (!toinen.kuuluu(luku)) joukko.lisaa(luku);                         
        }
        return joukko;
    }
        
    @Override
    public String toString() {    
        String merkkijono = "{";
                
        for (int i = 0; i < indeksi; i++) {                
            merkkijono += lukujono[i];
            if (indeksi != i + 1) merkkijono += ", ";
        }        
        merkkijono += "}";
        
        return merkkijono;       
    }
}
