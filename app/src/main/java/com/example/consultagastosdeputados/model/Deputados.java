package com.example.consultagastosdeputados.model;

public class Deputados {

    private String id;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private String email;

    public Deputados() {
    }

    public Deputados(String id, String nome, String siglaPartido, String siglaUf, String email) {
        this.id = id;
        this.nome = nome;
        this.siglaPartido = siglaPartido;
        this.siglaUf = siglaUf;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
