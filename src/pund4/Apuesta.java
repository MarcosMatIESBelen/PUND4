/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;
/**
 * @since 29/04/2024
 * @author Marcos
 * @version 1.0
 */

public class Apuesta {

   /**
    * Metodo para seleccionar goles locales
    * @return devuelve Goles_local
    */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Metodo para el acceso al atributo de Goles_local
     * @param goles_local 
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

   /**
    * Metodo para seleccionar goles del visitante
    * @return devuelve goles_visitante
    */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Metodo para el acceso al atributo de Goles_visitante
     * @param goles_visitante 
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Metodo para seleccionar atributo apostado
     * @return devuelve apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Metodo para el acceso al atributo apostado
     * @param apostado 
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }
    
    /**
     * Atributo de tipo entero indica dinero_disp
     */
    private int dinero_disp;
    /**
     * Atributo de tipo entero indica goles_local
     */
    private int goles_local;
    /**
     * Atributo de tipo entero indica goles_visitante
     */
    private int goles_visitante;
    /**
     * Atributo de tipo entero indica apostado
     */
    private int apostado;

    /**
     * Constructor por defecto sin parametros
     */
    public Apuesta() {
    }

    /**
     * Contructor con parámetros
     * @param dinero_disp indica el dinero_disp
     * @param goles_local indica los goles del local
     * @param goles_visitante indica los goles del visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /**
     * Metodo para seleccionar el dinero_disp
     * @return devuelve dinero_disp
     */

    public int getDinero_disp() {
        return dinero_disp;
    }
    /**
     * Método para el acceso al atributo dinero_disp
     * @param dinero_disp 
     */

    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar
     * @param dinero indica el dinero
     * @throws Exception lanza una excepcion con un mensaje si la condición se cumple
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * @param local indica el local
     * @param visitante insica el visitante
     * @return devuelve el acertado
     * @throws Exception lanza una excepcion con un mensaje si la condición se cumple
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
   
    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * @param cantidad_goles_local indica cantidad de goles del local
     * @param cantidad_goles_visit indica cantidad de goles del visitante
     * @throws Exception lanza una excepcion con un mensaje si la condición se cumple
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}