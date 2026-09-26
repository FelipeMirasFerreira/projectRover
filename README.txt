# Projeto Rover Ares-1 (Controlo de Bordo)

## 📌 Como Executar o Projeto
1. Certifique-se de ter o Java Development Kit (JDK) instalado.
2. Coloque os quatro arquivos (`Amostra.java`, `Comando.java`, `Rover.java` e `Main.java`) no mesmo diretório.
3. Abra o terminal (ou prompt de comando) na pasta onde os arquivos estão localizados.
4. Compile o código executando: `javac *.java`
5. Execute a simulação rodando: `java Main`

## 🧠 Justificativa Técnica: O Uso da Pilha (Stack) na Emergência
A escolha da estrutura de dados Pilha (Stack) para gerenciar o histórico de navegação foi fundamental para garantir a integridade do retorno à base. 

A Pilha opera sob o princípio **LIFO (Last-In, First-Out / Último a Entrar, Primeiro a Sair)**. No contexto de navegação de um veículo autônomo, o último movimento realizado pelo Rover no terreno deve ser obrigatoriamente o primeiro movimento a ser desfeito (retrocedido) para que ele refaça exatamente a mesma trilha de volta. Ao usar o método `.push()` para cada avanço e o método `.pop()` na emergência, o software garante, de forma nativa e segura, que os passos mais recentes sejam revertidos antes dos mais antigos, evitando colisões e garantindo o retorno seguro.