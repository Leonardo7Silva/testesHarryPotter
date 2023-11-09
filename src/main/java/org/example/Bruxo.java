package org.example;

import java.util.Objects;
import java.util.Random;

public class Bruxo {

    private String nome;
    private String nomeFamilia;
    private String escolaDeBruxaria;
    private String casaSelecionada;
    private String tipoVarinha;
    private String vassoura;
    private Boolean animago;

    public Bruxo(String nome) {
        this.nome = nome;
        this.animago = false;
    }
    public Bruxo(String nome, String nomeFamilia) {
        this.nome = nome;
        this.nomeFamilia = nomeFamilia;
        this.animago = false;
    }

    public Bruxo polissuco(Bruxo bruxo){
        if(this.casaSelecionada != null){
            this.nome = bruxo.getNome();
            this.nomeFamilia = bruxo.getNomeFamilia();
            this.casaSelecionada = bruxo.getCasaSelecionada();
        }else{
            System.out.println("Esse bruxo não pode tomar a poção");
        }
        return this;
    }

    public void virarAnimago(){
        this.animago = true;
    }

    public void matricular(){
        this.escolaDeBruxaria = "Hogwarts";
        definirCasa();
    }

    private void definirCasa(){
        Random random = new Random();
        int sorteador = random.nextInt(4) + 1;
        if(sorteador == 1){
            this.casaSelecionada = "Grifinória";

        } else if (sorteador == 2) {
            this.casaSelecionada = "Sonserina";

        }else if (sorteador == 3) {
            this.casaSelecionada = "Corvinal";

        }else if (sorteador == 4) {
            this.casaSelecionada = "Lufa-Lufa";

        }

    }

    public void definirVarinha(){
        Random random = new Random();
        int sorteador = random.nextInt(3) + 1;
        if(sorteador == 1){
            this.tipoVarinha = "Dragão";

        } else if (sorteador == 2) {
            this.tipoVarinha = "Fada";

        }else if (sorteador == 3) {
            this.tipoVarinha = "Fénix";

        }

    }

    public void lancarFeitico(String nomeFeitico) throws Exception{
        if (this.tipoVarinha == null){
            throw new Exception("Impossível lançar " + nomeFeitico);
        }
        System.out.println(nomeFeitico + "!");
    }

    public boolean voar(){
        if(vassoura == null){
            return false;
        }else{
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }

    public String getEscolaDeBruxaria() {
        return escolaDeBruxaria;
    }

    public void setEscolaDeBruxaria(String escolaDeBruxaria) {
        this.escolaDeBruxaria = escolaDeBruxaria;
    }

    public String getCasaSelecionada() {
        return casaSelecionada;
    }

    public void setCasaSelecionada(String casaSelecionada) {
        this.casaSelecionada = casaSelecionada;
    }

    public String getTipoVarinha() {
        return tipoVarinha;
    }

    public void setTipoVarinha(String tipoVarinha) {
        this.tipoVarinha = tipoVarinha;
    }

    public String getVassoura() {
        return vassoura;
    }

    public void setVassoura(String vassoura) {
        this.vassoura = vassoura;
    }

    public Boolean getAnimago() {
        return animago;
    }

    public void setAnimago(Boolean animago) {
        this.animago = animago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bruxo bruxo)) return false;
        return Objects.equals(nome, bruxo.nome) && Objects.equals(nomeFamilia, bruxo.nomeFamilia) && Objects.equals(casaSelecionada, bruxo.casaSelecionada);
    }

}
