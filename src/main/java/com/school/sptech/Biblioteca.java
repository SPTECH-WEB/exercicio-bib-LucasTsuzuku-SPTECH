package com.school.sptech;

public class Biblioteca {

    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros = 0;
    private Boolean ativa = true;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void registrarLivro(Integer quantidade){
        if(quantidade == null) {
            return;
        }

        if(quantidade > 0  && ativa){
            qtdLivros = qtdLivros + quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if(quantidade == null) {
            return null;
        }
        if(quantidade > 0  && quantidade <= qtdLivros && ativa){
            qtdLivros = qtdLivros - quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if(quantidade == null) {
            return null;
        }
        if(quantidade > 0  && ativa){
            qtdLivros = qtdLivros + quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if (!ativa){
            return null;
        } else {
            ativa = false;
            Integer qtdAnterior = qtdLivros;
            qtdLivros = 0;
            return qtdAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(destino.ativa && ativa  && quantidade <= qtdLivros){
            qtdLivros = qtdLivros - quantidade;
            destino.qtdLivros = destino.qtdLivros + quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if (percentual == null || percentual < 0.0) {
            return false;
        } else {
            if (percentual > 0.0) {
                multaDiaria = multaDiaria * (1.0+ percentual);
                return true;
            } else {
                return false;
            }
        }
    }

}
