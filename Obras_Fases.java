/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author augusto.martins
 */
public class Obras_Fases {
    private int idObra;
    private int idFase;
    private String dtInicioFase;
    private String dtTerminoFase;

    /**
     * @return the idObra
     */
    public int getIdObra() {
        return idObra;
    }

    /**
     * @param idObra the idObra to set
     */
    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    /**
     * @return the idFase
     */
    public int getIdFase() {
        return idFase;
    }

    /**
     * @param idFase the idFase to set
     */
    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    /**
     * @return the dtInicioFase
     */
    public String getDtInicioFase() {
        return dtInicioFase;
    }

    /**
     * @param dtInicioFase the dtInicioFase to set
     */
    public void setDtInicioFase(String dtInicioFase) {
        this.dtInicioFase = dtInicioFase;
    }

    /**
     * @return the dtTerminoFase
     */
    public String getDtTerminoFase() {
        return dtTerminoFase;
    }

    /**
     * @param dtTerminoFase the dtTerminoFase to set
     */
    public void setDtTerminoFase(String dtTerminoFase) {
        this.dtTerminoFase = dtTerminoFase;
    }
}