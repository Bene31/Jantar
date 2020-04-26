package jantar;

import java.util.Calendar;
import java.util.Date;

public class Filosofo extends Thread{
    
    final int _idFilosofo;
    private String _statusFilosofo;
    final Mesa _mesa;
    
    public Filosofo(int idFilosofo, Mesa mesa){
        this._statusFilosofo = "Pensando";
        this._idFilosofo = idFilosofo;
        this._mesa = mesa;
    }
    
    @Override
    public void run(){
        Calendar calendario = Calendar.getInstance();
        
        Date timeAtual = calendario.getTime();
        calendario.set(Calendar.MINUTE, calendario.get(Calendar.MINUTE)+1);
        Date timeInicio = calendario.getTime();
        
        try{
            while(!timeAtual.after(timeInicio)){
                sleep( (long) ( (Math.random()*20)));
                
                if(_mesa.pegaGarfo(_idFilosofo)){
                    _statusFilosofo = "Comendo";
                    
                    sleep( (long) ( (Math.random()*20)));
                    
                    _mesa.devolveGarfo(_idFilosofo);
                    _statusFilosofo = "Pensando";
                }
                
                calendario = Calendar.getInstance();
                timeAtual = calendario.getTime();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
