package model;


public class Engenheiros {
    private int idEngenheiro;
    private String dsNome;
    private String  nrCrea;
    private String dtAdmissao;

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
     * @return the dsNome
     */
    public String getDsNome() {
        return dsNome;
    }

    /**
     * @param dsNome the dsNome to set
     */
    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    /**
     * @return the nrCrea
     */
    public String getNrCrea() {
        return nrCrea;
    }

    /**
     * @param nrCrea the nrCrea to set
     */
    public void setNrCrea(String nrCrea) {
        this.nrCrea = nrCrea;
    }

    /**
     * @return the dtAdmissao
     */
    public String getDtAdmissao() {
        return dtAdmissao;
    }

    /**
     * @param dtAdmissao the dtAdmissao to set
     */
    public void setDtAdmissao(String dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }
}