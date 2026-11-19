/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author augusto.martins
 */
public class Orcamentos {
    private int idOrcamento;
    private String dtAprovacao;
    private int idEngenheiroResponsavel;

    /**
     * @return the idOrcamento
     */
    public int getIdOrcamento() {
        return idOrcamento;
    }

    /**
     * @param idOrcamento the idOrcamento to set
     */
    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    /**
     * @return the dtAprovacao
     */
    public String getDtAprovacao() {
        return dtAprovacao;
    }

    /**
     * @param dtAprovacao the dtAprovacao to set
     */
    public void setDtAprovacao(String dtAprovacao) {
        this.dtAprovacao = dtAprovacao;
    }

    /**
     * @return the idEngenheiroResponsavel
     */
    public int getIdEngenheiroResponsavel() {
        return idEngenheiroResponsavel;
    }

    /**
     * @param idEngenheiroResponsavel the idEngenheiroResponsavel to set
     */
    public void setIdEngenheiroResponsavel(int idEngenheiroResponsavel) {
        this.idEngenheiroResponsavel = idEngenheiroResponsavel;
    }
}