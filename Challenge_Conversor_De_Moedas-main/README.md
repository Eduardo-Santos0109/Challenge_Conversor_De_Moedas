# Conversor de Moedas Online

Este projeto é um conversor de moedas simples, rápido e preciso, desenvolvido em Java. Ele permite aos usuários converter valores entre diferentes moedas utilizando taxas de câmbio atualizadas de uma API externa. Além disso, o conversor gera um arquivo JSON com os detalhes de cada conversão realizada.

## Funcionalidades

- Conversão de moedas em tempo real.
- Utilização de uma API externa para obter as taxas de câmbio mais recentes.
- Geração de um arquivo JSON (`resultadoConversao.json`) contendo os detalhes de cada conversão (valor original, valor convertido, moedas de origem e destino, e taxa de conversão).
- Interface de linha de comando interativa para seleção de moedas e entrada de valores.

## Como Funciona

O programa `Principal.java` é o ponto de entrada da aplicação. Ele interage com o usuário para obter as moedas de origem e destino, bem como o valor a ser convertido. Em seguida, ele faz uma requisição HTTP para a API `ExchangeRate-API` para obter a taxa de câmbio entre as moedas selecionadas. Com a taxa em mãos, o cálculo da conversão é realizado e o resultado é exibido ao usuário. Por fim, os detalhes da conversão são salvos em um arquivo JSON.

### Estrutura do Projeto

- `Principal.java`: Contém a lógica principal do programa, incluindo a interação com o usuário, chamadas à API e manipulação dos resultados.
- `model/ResultadoConversao.java`: (Assumido) Uma classe que representa o objeto de resultado da conversão, provavelmente contendo campos como `valorOriginal`, `valorFinal`, `codigoMoedaOrigem`, `codigoMoedaDestino` e `taxaConversao`.
- `utils/EntradaDeDados.java`: (Assumido) Uma classe utilitária responsável por lidar com a entrada de dados do usuário, como a seleção de moedas e a validação de valores.
- `utils/GeradorDeArquivos.java`: (Assumido) Uma classe utilitária responsável por gerar e salvar o arquivo JSON com os resultados da conversão.
- `utils/ObterCodigoMoeda.java`: (Assumido) Uma classe utilitária para mapear as opções numéricas de moedas selecionadas pelo usuário para seus respectivos códigos de moeda (ex: USD, BRL).

## Como Compilar e Executar

Para compilar e executar este projeto, você precisará ter o Java Development Kit (JDK) instalado em sua máquina, bem como a biblioteca `Gson` para manipulação de JSON. A biblioteca `Gson` pode ser adicionada ao seu projeto via Maven, Gradle ou baixando o JAR diretamente.

### Pré-requisitos

- JDK 11 ou superior
- Biblioteca Gson (versão 2.10.1 ou superior)

### Passos para Execução
1. **Baixe o projeto:** Clone ou baixe o repositório para sua máquina local.

2. **Adicione a biblioteca Gson:**
   - Se estiver usando Maven, adicione a seguinte dependência ao seu `pom.xml`:
     ```xml
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>2.10.1</version>
     </dependency>
     ```
   - Se estiver usando Gradle, adicione a seguinte dependência ao seu `build.gradle`:
     ```gradle
     implementation 'com.google.code.gson:gson:2.10.1'
     ```
   - Se preferir baixar o JAR, faça o download em [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) e adicione-o ao `classpath` do seu projeto.

3. **Compile o código:** Navegue até o diretório raiz do projeto no terminal e compile os arquivos Java:
   ```bash
   javac -cp "path/to/gson-2.10.1.jar:." Principal.java model/*.java utils/*.java
   ```
   (Substitua `path/to/gson-2.10.1.jar` pelo caminho real do seu arquivo Gson JAR. No Windows, use `;` em vez de `:` para separar os caminhos no `classpath`.)

4. **Execute o programa:** Após a compilação, execute a classe principal:
   ```bash
   java -cp "path/to/gson-2.10.1.jar:." conversor.Principal
   ```

## API Utilizada

Este conversor utiliza a API gratuita `ExchangeRate-API` para obter as taxas de câmbio. Você pode encontrar mais informações sobre a API em [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/).