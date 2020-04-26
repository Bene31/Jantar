package jantar;

import java.util.ArrayList;

public class Jantar {

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        
        ArrayList<Filosofo> filosofos = new ArrayList<Filosofo>(4);
        for(int i=0; i<5; i++){
            filosofos.add(new Filosofo(i, mesa));
        }
        for(int i=0; i<5; i++){
        filosofos.get(i).start();
        }
    }
    
}
