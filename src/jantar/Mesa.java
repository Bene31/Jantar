package jantar;

import java.util.ArrayList;

public class Mesa {
    
    final ArrayList<String> _statusFilosofos;
    final ArrayList<Integer> _garfos; 
    private int interacoes = 0;
    
    public Mesa(){
        _statusFilosofos = new ArrayList<String>();
        _garfos = new ArrayList<Integer>();
        
        for(int i=0; i<5; i++){
            _statusFilosofos.add("Pensando");
            _garfos.add(2);
        }
    }
    
    public synchronized boolean pegaGarfo(int idFilosofo){
        if(_garfos.get(idFilosofo) == 2){
            retiraGarfo(idFilosofo);
            _statusFilosofos.set(idFilosofo, "Comendo");
            
            imprimiStatus();
            return true;
        }
        else
            return false;
    }
    
    private void retiraGarfo(int idFilosofo){
        //retira garfo do filosofo do lado esquerdo
        if(idFilosofo == 0)
            _garfos.set(4, _garfos.get(4) - 1);
        else 
            _garfos.set(idFilosofo - 1, _garfos.get(idFilosofo - 1) - 1);
        //retira garfo do filosofo do lado direito
        if(idFilosofo == 4)
            _garfos.set(0, _garfos.get(0) - 1);
        else 
            _garfos.set(idFilosofo + 1, _garfos.get(idFilosofo + 1) - 1);
    }
    
    public synchronized void devolveGarfo(int idFilosofo){
        //devolve garfo do filosofo da esquerda
        if(idFilosofo == 0)
            _garfos.set(4, _garfos.get(4) + 1);
        else
            _garfos.set(idFilosofo - 1, _garfos.get(idFilosofo - 1) + 1);
        //devolve garfo do filosofo da direita
        if(idFilosofo == 4)
            _garfos.set(0, _garfos.get(0) + 1);
        else
            _garfos.set(idFilosofo + 1, _garfos.get(idFilosofo + 1) + 1);
        _statusFilosofos.set(idFilosofo, "Pensando");
        imprimiStatus();
    }
    
    public synchronized void imprimiStatus(){
        String linha = interacoes+ " = ";
        for(int i = 0; i < 5; i++){
            linha = linha + _statusFilosofos.get(i)+ " ";
        }
        
        System.out.println(linha);
        interacoes++;
        
    }
    
}
