# Escopo e objetivo

Desenvolvimento de uma API capaz de consumir dados da API pública do GitHub, especificamente os repositórios da linguagem Java que são mais estrelados.

## Iniciando...

- `git clone https://github.com/isaquebrother90/Busca-Repositorios-Java-API-Back.git`
- `cd Busca-Repositorios-Java-API-Back`

Agora você poderá executar os vários comandos abaixo.

## Pré-requisitos
- `mvn --version`<br>
você deverá ver a indicação da versão do Maven instalada e
a versão do JDK, dentre outras. Observe que o JDK é obrigatório, assim como
a definição das variáveis de ambiente **JAVA_HOME** e **M2_HOME**.

## Limpar, compilar, executar testes de unidade e cobertura
- `mvn clean`<br>
remove diretório _target_

- `mvn compile`<br>
compila o projeto, deposita resultados no diretório _target_

- `mvn test`<br>
executa todos os testes do projeto. Para executar apenas parte dos testes, por exemplo,
aqueles contidos em uma dada classe execute `mvn -Dtest=NomeDaClasseTest test`. Observe
que o sufixo do nome da classe de teste é `Test` (padrão recomendado). Para executar um
único teste `mvn -Dtest=NomeDaClasseTest#nomeDoMetodo test`.

- `mvn verify -P cobertura`<br>
executa testes de unidade e produz relatório de
cobertura em _target/site/jacoco/index.html_ além de verificar se limite mínimo
de cobertura, conforme configurado, é satisfeito.

## Empacotando o projeto
- `mvn package`<br>
gera arquivo _exemplo.jar_ no diretório _target_. Observe que
o arquivo gerado não é executável. Um arquivo jar é um arquivo no formato
zip. Você pode verificar o conteúde deste arquivo ao executar o comando `jar vft exemplo.jar`.

- `mvn package -P executavel-dir`<br>
gera _exemplo-dir.jar_, executável, mas dependente do diretório _jars_,
 também criado no diretório _target_. Para executar basta o comando
 `java -jar target/exemplo-dir.jar`. Observe que se o diretório _jars_ for
 removido, então este comando falha. Por último, o diretório _jars_ deve
 ser depositado no mesmo diretório do arquivo _exemplo.jar_.

- `mvn package -P executavel-unico`<br>
 gera jar executável correspondente ao aplicativo a ser executado via linha de comandos,
 em um único arquivo, _target/exemplo-unico.jar_,
 suficiente para ser transferido e executado. Para executá-lo basta o
 comando `java -jar target/exemplo-unico.jar`.

 - `mvn package -P api`<br>
 gera jar executável juntamente com todas as dependências reunidas em um único arquivo, 
 _target/api.jar_. Este arquivo jar pode ser transferido para outro diretório
  ou máquina e ser executado pelo comando `java -jar target/api.jar`. A execução e exemplos
  de chamadas são fornecidos na seção seguinte.
  
  ## Itens para desenvolvimento
  - `Seleção de idioma via SearchBar ou menu suspenso`<br>
  - `Pelo menos um teste de unidade`<br>
  - `TDD`<br>
