/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Componentes.Armas;
import Componentes.Armeria;
import Componentes.Conector;
import Componentes.FuenteEnergia;
import Componentes.Mercado;
import Mar.GrafoIslas;
import Mar.Isla;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author admin
 */

public class Jugador implements Serializable{
    
    public int acero;
    public javax.swing.JLabel label_acero;
    public int dinero;
    public javax.swing.JLabel label_dinero;
    public int comodin = 1;
    public boolean acepto_oferta;
    public Armas arma_cargada;
    public int canion = 10;
    private javax.swing.JLabel boton_canion;
    public int canion_multiple = 10;
    private javax.swing.JLabel boton_canion_multiple;
    public int canion_barba_roja = 10;
    private javax.swing.JLabel boton_canion_barba_roja;
    public int bomba = 10;
    private javax.swing.JLabel boton_bomba;
    public javax.swing.JTextArea bitacora;
    public boolean tieneMercado;
 //   public GrafoIslas grafo;
    private int disparos_barba_roja;
    public boolean tiene_mercado;    
    public String nombre;
    public boolean puede_colocar_mercado = false;
    public boolean puede_colocar_armeria = false;
    public boolean puede_colocar_mina = false;
    public boolean puede_colocar_templo = false;
    public int escudos = 0;
    // GrafoIslas grafos;
    public Armeria armas;
    public boolean admin;
    public GrafoIslas grafo = new GrafoIslas();
    public Isla[][] matriz = new Isla[20][20];
    public String target;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        acero = 100000;
        this.comodin = 1;
        dinero = 100000;
        this.matriz = iniciarMatriz(matriz);
        this.grafo = iniciarGrafo(grafo, matriz);
    
        this.arma_cargada = new Armas() {
            @Override
            public Armas disparar() {
                return null;
            }
            @Override
            public void setXY(int x, int y) {
            }
            @Override
            public int getX() {
                return -1;
            }
            @Override
            public int getY() {
                return -1;
            }
            @Override
            public String getName() {
                return "";
            }

            @Override
            public void setXY(int[] pos) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int[] getXY() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
       /// grafo = new GrafoIslas();
     //   comodin = 0;
    }
    

    private GrafoIslas iniciarGrafo(GrafoIslas grafo, Isla[][] matriz) {
        Isla fuenteEnergia = null;
        Isla mercado = null;
        for (Isla[] matriz1 : matriz) {
            for (Isla matriz11 : matriz1) {
                if (matriz11 != null) {
                    Isla islaActual = matriz11;
                    Isla conector = new Isla(islaActual.getConector());
                    fuenteEnergia = new Isla(conector.getFuenteEner());
                    mercado = new Isla(conector.getMercadito());
                    grafo.agregarArista(conector, fuenteEnergia);
                    grafo.agregarArista(fuenteEnergia, conector);
                    grafo.agregarArista(conector, mercado);
                    grafo.agregarArista(mercado, conector);
                }
            }
        }
        return grafo;
    }
    private Isla[][] iniciarMatriz(Isla[][] matriz) {
        int xFuente = generarRandomX();
        int yFuente = generarRandomY();
        FuenteEnergia fuenteEner = new FuenteEnergia();
        Isla nuevo = new Isla(xFuente, yFuente, fuenteEner);

        int xMercado = generarRandomX();
        int yMercado = generarRandomY();

        while (Math.abs(xMercado - xFuente) <= 2 && Math.abs(yMercado - yFuente) <= 2) {
            xMercado = generarRandomX();
            yMercado = generarRandomY();
        }
        Mercado mercado = new Mercado();
        Isla nuevo1 = new Isla(xMercado, yMercado, mercado);

        int xConector = generarRandomX();
        int yConector = generarRandomY();

        while ((Math.abs(xConector - xFuente) <= 2 && Math.abs(yConector - yFuente) <= 2) ||
               (Math.abs(xConector - xMercado) <= 2 && Math.abs(yConector - yMercado) <= 2)) {
            xConector = generarRandomX();
            yConector = generarRandomY();
        }
        Conector conector = new Conector(nuevo, nuevo1);
        Isla nuevo2 = new Isla(xConector, yConector, conector);
        
        matriz[xFuente][yFuente] = nuevo;
        matriz[xMercado][yMercado] = nuevo1;
        matriz[xConector][yConector] = nuevo2;
        return matriz;
    }
    
    public int generarRandomX(){
        Random random = new Random();
        int x = random.nextInt(20);
        return x;
    }
    public int generarRandomY(){
        Random random = new Random();
        int y = random.nextInt(20);
        return y;
    }
    /*
    Confirma si se tiene suficiente de lo que quiere vender
    */
    public boolean confirmaVenta(String clase, int cantidad){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                return this.acero >= cantidad;
            }
            case "CANION" -> {
                return this.canion >= cantidad;
            }
            case "CANION MULTIPLE" -> {
                return this.canion_multiple >= cantidad;
            }
            case "BOMBA" -> {
                return this.bomba >= cantidad;
            }
            case "CANION BARBA ROJA" -> {
                return this.canion_barba_roja >= cantidad;
            } 
        }
        return false;
    }
    
    
    public void recibirOferta(String clase,int cantidad ,int precio, String nombre_vendedor){
        this.acepto_oferta = false;
        int option = JOptionPane.showOptionDialog(null,
                "El jugador "+nombre_vendedor+" te quiere vender "+cantidad+ " de "+clase+" por "+precio+" unidades",
                "Oferta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if (option == JOptionPane.OK_OPTION) {
            if(confirmarCompra(precio)){
                comprar(clase,cantidad,precio);
                JOptionPane.showMessageDialog(null, "Compra exitosa", "Aviso", JOptionPane.WARNING_MESSAGE);
                acepto_oferta = true;
            }else 
                JOptionPane.showMessageDialog(null, "No tienes suficiente dinero", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            
        }
    }
    
    public void comprar(String clase,int cantidad, int precio){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                this.dinero -= precio;
                this.acero += cantidad;
                this.label_acero.setText("Acero: "+this.acero);
                this.label_dinero.setText("Dinero: "+this.dinero);
            }
            case "CANION" -> {
                this.dinero -= precio;
                this.canion += cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION MULTIPLE" -> {
                this.dinero -= precio;
                this.canion_multiple += cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "BOMBA" -> {
                this.dinero -= precio;
                this.bomba += cantidad;            
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION BARBA ROJA" -> {
                this.dinero -= precio;
                this.canion_barba_roja += cantidad;
                actualizarArmas();
                actualizar_dinero();
            } 
        }
    }

    
    public void vender(String clase,int cantidad, int precio){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                this.dinero += precio;
                this.acero -= cantidad;
                actualizar_acero();
                actualizar_dinero();
            }
            case "CANION" -> {
                this.dinero += precio;
                this.canion -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION MULTIPLE" -> {
                this.dinero += precio;
                this.canion_multiple -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "BOMBA" -> {
                this.dinero += precio;
                this.bomba -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION BARBA ROJA" -> {
                this.dinero += precio;
                this.canion_barba_roja -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
        }
    }
    

    public void actualizarArmas(){
        this.boton_canion.setText("Canion * "+this.canion);
        this.boton_canion_multiple.setText("Canion multiple * "+this.canion_multiple);
        this.boton_canion_barba_roja.setText("Canion barba roja * "+this.canion_barba_roja);
        this.boton_bomba.setText("Bomba * "+this.bomba);
    }
    
    public void cargar_arma(String arma){
        switch(arma){
            case "CANION" -> {
                this.arma_cargada = arma_cargada.cargarCanion();
                JOptionPane.showMessageDialog(null, "Has cargado el canion, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "CANION MULTIPLE" -> {
                this.arma_cargada = arma_cargada.cargarCanionMultiple();
                JOptionPane.showMessageDialog(null, "Has cargado el canion multiple, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "BOMBA" -> {
                this.arma_cargada = arma_cargada.cargarBomba();
                JOptionPane.showMessageDialog(null, "Has cargado el bomba, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "CANION BARBA ROJA" -> {
                this.arma_cargada = arma_cargada.cargarCanionBarbaRoja();
                JOptionPane.showMessageDialog(null, "Has cargado el canion barba roja, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void restarArma(String nombre){
        switch(nombre.toUpperCase()){
            case "CANION" -> {
                this.canion--;
                break;
            }
            case "CANION MULTIPLE" -> {
                this.canion_multiple--;
                break;
            }
            case "BOMBA" -> {
                this.bomba--;
                break;
            }
            case "CANION BARBA ROJA" -> {
                this.canion_barba_roja--;
                break;
            }
        }
    }
    
    //deberia de restar a la arma que tenia cargada
    public void disparar_arma_cargada(){
        escribirDisparoBitacora();
        String name = arma_cargada.getName();
        this.arma_cargada = arma_cargada.disparar();
        if(this.arma_cargada.getX() == -1){
            restarArma(name);
            actualizarArmas();
        }
    }
    
    public ArrayList<ArrayList<Integer>> recibir_disparo(int x, int y){
        Isla isla = this.grafo.buscarIslaPorCoordenadas(x, y);
        ArrayList<Isla> temp;
        ArrayList<ArrayList<Integer>> aaa = new ArrayList<>();
        if(isla != null){
            if(isla.componente.getNombre().equals("un conector")||isla.componente.getNombre().equals("una fuente de energia")){
                temp = this.grafo.getDestinos(isla);
                temp.add(grafo.borrarIsla(isla));
                for(Isla islatemp : temp){
                    aaa.add(new ArrayList<>(Arrays.asList(islatemp.getX(), islatemp.getY(), islatemp.tipoToInt())));
                }
            }else{
                Isla porborrar = grafo.borrarIsla(isla);
                aaa.add(new ArrayList<>(Arrays.asList(porborrar.getX(), porborrar.getY(), porborrar.tipoToInt())));
            }
        }
        return aaa;
    }
    
    
    public void AñadirIslas(Isla isla) {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (this.matriz[i][j] == null) {
                    matriz[i][j] = isla;
                    isla.setX(i);
                    isla.setY(j);
                }
            }
        }
    }
    
    void escribirDisparoBitacora(){
        if(arma_cargada.getName().equals("Bomba"))
            this.bitacora.append("Has explotado una bomba en las posiciones ("+arma_cargada.getXY()[0]+","+arma_cargada.getXY()[1]+") y ("+arma_cargada.getXY()[2]+","+arma_cargada.getXY()[3]+")\n");
        else
            this.bitacora.append("Has disparado " + arma_cargada.getName()+" en la posicion: ("+arma_cargada.getX()+","+arma_cargada.getY()+")\n");
    }
    public JLabel getLabel_acero() {
        return label_acero;
    }

    public void setLabel_acero(JLabel label_acero) {
        this.label_acero = label_acero;
    }

    public JLabel getLabel_dinero() {
        return label_dinero;
    }

    public void setLabel_dinero(JLabel label_dinero) {
        this.label_dinero = label_dinero;
    }
    
    public void setBoton_canion(JLabel boton_canion) {
        this.boton_canion = boton_canion;
    }

    public void setBoton_canion_multiple(JLabel boton_canion_multiple) {
        this.boton_canion_multiple = boton_canion_multiple;
    }

    public void setBoton_canion_barba_roja(JLabel boton_canion_barba_roja) {
        this.boton_canion_barba_roja = boton_canion_barba_roja;
    }

    public void setBoton_bomba(JLabel boton_bomba) {
        this.boton_bomba = boton_bomba;
    }
    
    public void actualizar_dinero(){
        this.label_dinero.setText("Dinero: "+this.dinero);
    }
    public void actualizar_acero(){
        this.label_acero.setText("Acero: "+this.acero);
    }
    public void jugadorInexistente(){
        JOptionPane.showMessageDialog(null, "El jugador no existe", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public boolean confirmarCompra(int precio){
        return this.dinero >= precio;
    }
    public void avisarComodinDisponible(){
        String comodin;
        if(this.comodin == 1){
            comodin = "KRAKEN";
        }else{
            comodin = "ESCUDO";
        }
        JOptionPane.showMessageDialog(null, "Gracias al templo de bruja puedes usar el comodin de "+comodin, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    public void avisarEscudoActivo(){
        JOptionPane.showMessageDialog(null, "Has utilizado el comodin de escudos ahora eres inmune a "+this.escudos+" disparos", "Aviso", JOptionPane.WARNING_MESSAGE);

    }

    public JTextArea getBitacora() {
        return bitacora;
    }

    public void setBitacora(JTextArea bitacora) {
        this.bitacora = bitacora;
    }
    
}
