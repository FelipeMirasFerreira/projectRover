package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Rover {
    private final double PESO_MAXIMO = 50.0;
    private double[] sensoresProximidade = new double[4];
    private ArrayList<Amostra> compartimentoCarga = new ArrayList<>();
    private Stack<Comando> historicoNavegacao = new Stack<>();

    public void atualizarSensores(double frente, double tras, double esq, double dir) {
        sensoresProximidade[0] = frente;
        sensoresProximidade[1] = tras;
        sensoresProximidade[2] = esq;
        sensoresProximidade[3] = dir;

        String[] posicoes = {"Frente", "Trás", "Esquerda", "Direita"};
        for (int i = 0; i < sensoresProximidade.length; i++) {
            if (sensoresProximidade[i] < 2.0) { // Regra do alerta de 2 metros
                System.out.println("⚠️ ALERTA: Obstáculo detectado na direção " + posicoes[i] + " a " + sensoresProximidade[i] + "m!");
            }
        }
    }

    public void coletarAmostra(Amostra amostra) {
        double pesoAtual = calcularPesoTotal();
        if (pesoAtual + amostra.getPeso() > PESO_MAXIMO) {
            System.out.println("❌ Carga máxima atingida! Descartando amostra ID: " + amostra.getId() + ".");
            ativarEmergencia(); // Retorna à base se estourar o peso
        } else {
            compartimentoCarga.add(amostra);
            System.out.println("✅ Amostra ID " + amostra.getId() + " armazenada com sucesso.");
        }
    }

    public void descartarAmostra(int id) {
        for (int i = 0; i < compartimentoCarga.size(); i++) {
            if (compartimentoCarga.get(i).getId() == id) {
                System.out.println("🗑️ Descartando amostra ID: " + id);
                compartimentoCarga.remove(i);
                return;
            }
        }
    }

    public void exibirCarga() {
        System.out.println("--- COMPARTIMENTO DE CARGA ---");
        for (Amostra a : compartimentoCarga) {
            System.out.println(a.toString());
        }
        System.out.println("Peso Total: " + calcularPesoTotal() + "kg / " + PESO_MAXIMO + "kg");
        System.out.println("------------------------------");
    }

    private double calcularPesoTotal() {
        double total = 0;
        for (Amostra a : compartimentoCarga) {
            total += a.getPeso();
        }
        return total;
    }

    public void movimentar(Comando comando) {
        historicoNavegacao.push(comando); // push() empilha a ação
        System.out.println("Movimento realizado: " + comando.toString());
    }

    public void ativarEmergencia() {
        System.out.println("\n🌪️ !!! TEMPESTADE DE AREIA DETECTADA !!! 🌪️");
        System.out.println("Iniciando protocolo de emergência. Retornando à base...\n");

        while (!historicoNavegacao.isEmpty()) {
            Comando comandoAnterior = historicoNavegacao.pop();
            System.out.println("Retrocedendo -> " + comandoAnterior.getAcaoInversa());
        }
        System.out.println("\n🏁 Rover Ares-1 chegou em segurança à base.");
    }
}
