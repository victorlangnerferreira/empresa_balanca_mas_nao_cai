/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author augusto.martins
 */
public class Obras {
    private int idObra;
    private String Descricao;
    private String dtInicio;
    private String dtFim;
    private int idEngenheiro;
    private String dtCrea;
    private String dtDdmissaoEngenheiro;

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
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the dtInicio
     */
    public String getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public String getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(String dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * @return the idEngenheiro
     */
    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    /**
     * @param idEngenheiro the idEngenheiro to set
     */
    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    /**
     * @return the dtCrea
     */
    public String getDtCrea() {
        return dtCrea;
    }

    /**
     * @param dtCrea the dtCrea to set
     */
    public void setDtCrea(String dtCrea) {
        this.dtCrea = dtCrea;
    }

    /**
     * @return the dtDdmissaoEngenheiro
     */
    public String getDtDdmissaoEngenheiro() {
        return dtDdmissaoEngenheiro;
    }

    /**
     * @param dtDdmissaoEngenheiro the dtDdmissaoEngenheiro to set
     */
    public void setDtDdmissaoEngenheiro(String dtDdmissaoEngenheiro) {
        this.dtDdmissaoEngenheiro = dtDdmissaoEngenheiro;
    }

    public void setNrCrea(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNrCrea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}