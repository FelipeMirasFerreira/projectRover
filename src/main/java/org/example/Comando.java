package org.example;

public class Comando {
    private String acao;
    private String direcao;

    public Comando(String acao, String direcao) {
        this.acao = acao;
        this.direcao = direcao;
    }

    public String getAcaoInversa() {
        String acaoInvertida = acao;
        if (acao.toLowerCase().contains("avançar")) {
            acaoInvertida = acao.replace("Avançar", "Recuar");
        }

        String direcaoInvertida = direcao;
        if (direcao.equalsIgnoreCase("Frente")) direcaoInvertida = "Trás";
        else if (direcao.equalsIgnoreCase("Trás")) direcaoInvertida = "Frente";
        else if (direcao.equalsIgnoreCase("Esquerda")) direcaoInvertida = "Direita";
        else if (direcao.equalsIgnoreCase("Direita")) direcaoInvertida = "Esquerda";

        return "Ação: " + acaoInvertida + " | Direção: " + direcaoInvertida;
    }

    @Override
    public String toString() {
        return "Ação: " + acao + " | Direção: " + direcao;
    }
}