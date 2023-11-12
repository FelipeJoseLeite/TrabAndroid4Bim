package com.example.consultagastosdeputados.model;

public class GastosDeputados {

    private Long id;
    private String ano;
    private String mes;
    private String tipoDespesa;
    private String codDocumento;
    private String tipoDocumento;
    private String dataDocumento;
    private String valorDocumento;
    private String nomeFornecedor;
    private String valorLiquido;

    public GastosDeputados() {
    }

    public GastosDeputados(Long id, String ano, String mes, String tipoDespesa, String codDocumento, String tipoDocumento, String dataDocumento, String valorDocumento, String nomeFornecedor, String valorLiquido) {
        this.id = id;
        this.ano = ano;
        this.mes = mes;
        this.tipoDespesa = tipoDespesa;
        this.codDocumento = codDocumento;
        this.tipoDocumento = tipoDocumento;
        this.dataDocumento = dataDocumento;
        this.valorDocumento = valorDocumento;
        this.nomeFornecedor = nomeFornecedor;
        this.valorLiquido = valorLiquido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(String valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
}
