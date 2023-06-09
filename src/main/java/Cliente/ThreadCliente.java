/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Modelos.Mensaje;
import Servidor.Servidor;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jecheverria
 */
public class ThreadCliente extends Thread{
    boolean isrunnig = true;
    private Socket socket;
    private Cliente cliente;
    private ObjectInputStream entrada;

    public ThreadCliente(Socket socket, Cliente cliente) {
        try {
            this.socket = socket;
            this.cliente = cliente;
            entrada = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        while(isrunnig){
            try {
                Mensaje mensaje = (Mensaje) entrada.readObject();
                if(mensaje.isjugador){
                    this.cliente.jugador = mensaje.getJugador();
                    this.cliente.jugador.setLabel_acero(cliente.pantalla.getLabel_acero());
                    this.cliente.jugador.setLabel_dinero(cliente.pantalla.getLabel_dinero()); 
                    this.cliente.jugador.label_acero.setText("Acero: "+this.cliente.jugador.acero);
                    this.cliente.jugador.label_dinero.setText("Dinero: "+this.cliente.jugador.dinero);
                    this.cliente.jugador.setBoton_bomba(cliente.pantalla.getjLabel3());
                    this.cliente.jugador.setBoton_canion(cliente.pantalla.getjLabel1());
                    this.cliente.jugador.setBoton_canion_multiple(cliente.pantalla.getjLabel2()); 
                    this.cliente.jugador.setBoton_canion_barba_roja(cliente.pantalla.getjLabel4());
                    this.cliente.jugador.actualizarArmas();
                }else if(mensaje.isVenta()){
                    String[] arregloMensaje = mensaje.getMensaje().split("-");
                    cliente.jugador.recibirOferta(arregloMensaje[1],Integer.parseInt(arregloMensaje[2]),Integer.parseInt(arregloMensaje[4]),mensaje.getEnviador());
                    if(cliente.jugador.acepto_oferta){
                       cliente.salida.writeObject(new Mensaje(this.cliente.nombre,"COMPRAR-"+mensaje.getEnviador()+"-"+arregloMensaje[1]+"-"+Integer.parseInt(arregloMensaje[2])+"-"+Integer.parseInt(arregloMensaje[4])));
                    }
                }else if (mensaje.isCompra()){
                    String[] arregloMensaje = mensaje.getMensaje().split("-");
                    cliente.jugador.vender(arregloMensaje[2].toUpperCase(),Integer.parseInt(arregloMensaje[3]), Integer.parseInt(arregloMensaje[4]));
                }else if(mensaje.isComodin()){
                    
                }else
                    cliente.pantalla.write(mensaje.toString());
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
        
    }
    
    
    
    
    
}
