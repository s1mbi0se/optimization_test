# Teste de otimização

Há um programa que deve...
 
1. Ler cada par de linhas subjacentes e computar a intersecção entre as duas listas de inteiros
2. Computar a união entre todas estas intersecções.
3. Escrever esta união em um arquivo `output.txt` em ordem crescente. 

A classe que implementa este algoritmo é chamada `MyProcessor`.

Há uma classe `TestRunner` que executa e confere que este programa funciona corretamente usando diferentes arquivos de input e output, separados por níveis de complexidade (a constante `LEVEL` que assume valores de 0 até 3). O programa é rodado em loop por 5 vezes.


**Preparo**:

1. Descompactar o arquivo `testcases.tar.gz` na raiz deste repositório.
2. Renomear a classe `MyProcessor` para `{SEU_NOME}Processor`.
3. Usar as flags `-Xms512M -Xms512M` ao rodar a classe `TestRunner`.
4. Rodar a classe `TestRunner` no nível 0 (`TestRunner.LEVEL = 0`) e verificar que tudo está funcionando corretamente antes da sua otimização.

**Objetivo**:

Otimizar o programa tanto em uso de CPU quanto de memória o máximo possível, mantendo o comportamento do problema.

O resultado final deve ser medido no nível 3 do TestRunner (`TestRunner.LEVEL = 3`)
