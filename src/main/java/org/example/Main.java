package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DO ROVER ARES-1 ===\n");
        Rover ares1 = new Rover();

        // a) Inicializar o Rover e ler os 4 sensores iniciais
        System.out.println("[ETAPA 1: Leitura de Sensores]");
        ares1.atualizarSensores(5.0, 10.0, 1.5, 8.0); // O 1.5m vai disparar o alerta na Esquerda

        // b) Movimentar o Rover 4 vezes
        System.out.println("\n[ETAPA 2: Movimentação]");
        ares1.movimentar(new Comando("Avançar 10m", "Frente"));
        ares1.movimentar(new Comando("Avançar 5m", "Esquerda"));
        ares1.movimentar(new Comando("Avançar 15m", "Frente"));
        ares1.movimentar(new Comando("Avançar 2m", "Direita"));

        // c) Coletar 3 amostras geológicas diferentes
        System.out.println("\n[ETAPA 3: Coleta de Amostras]");
        Amostra am1 = new Amostra(101, "Basalto", 15.0);
        Amostra am2 = new Amostra(102, "Hematita", 25.0);
        Amostra am3 = new Amostra(103, "Sílica", 8.0);

        ares1.coletarAmostra(am1);
        ares1.coletarAmostra(am2);
        ares1.coletarAmostra(am3);
        ares1.exibirCarga();

        // d) Descartar a amostra mais pesada (Hematita - ID 102)
        System.out.println("\n[ETAPA 4: Descarte de Amostra]");
        ares1.descartarAmostra(102);
        ares1.exibirCarga();

        // e) Simular tempestade de areia (Emergência)
        System.out.println("\n[ETAPA 5: Simulação de Emergência]");
        ares1.ativarEmergencia();
    }
}
