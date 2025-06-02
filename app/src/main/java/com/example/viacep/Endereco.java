package com.example.viacep;

public class Endereco {
    public String cep, logradouro, bairro, cidade, uf;

    public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "CEP: " + cep + "\n" +
                logradouro + ", " + bairro + "\n" +
                cidade + " - " + uf;
    }
}
