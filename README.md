# Teste de otimização

Há um programa que deve...
 
1. Ler cada par de linhas subjacentes e computar a intersecção entre as duas listas de inteiros
2. Computar a união entre todas estas intersecções.
3. Escrever esta união em um arquivo `output.txt` em ordem crescente. 

## Exemplo:
**Input:**
```
55,0,1,2,3,4,5,6,7,8,9,
88,0,2,4,6,8,99,
77,10,11,12,13,
99,11,13,
```

**Output esperado**:
```
0,2,4,6,8,11,13,
```

**Explicação:**

1. A intersecção entre `55,0,1,2,3,4,5,6,7,8,9,` e `88,0,2,4,6,8,99,` é `0,2,4,6,8,`;
2. A intersecção entre `77,10,11,12,13,` e `99,11,13,` é `11,33,`;
3. A união entre `0,2,4,6,8,` e `11,33,` é `0,2,4,6,8,11,13,` (resposta final).

---

A classe que implementa este algoritmo é chamada `MyProcessor`. A implementação atual usa [RoaringBitmaps](https://github.com/RoaringBitmap/RoaringBitmap) ([docs](https://www.javadoc.io/doc/org.roaringbitmap/RoaringBitmap/0.7.13)) para fazer uniões e intersecções nos conjuntos de inteiros. (Pode-se entender que a classe `RoaringBitmap` é uma como implementação de `Set<Integer>`).

Há uma classe `TestRunner` que executa e confere que este programa funciona corretamente usando diferentes arquivos de input e output, separados por níveis de complexidade (a constante `LEVEL` que assume valores de 0 até 3). O programa é rodado em loop por 5 vezes.


**Preparo**:

1. Baixar o arquivo [testcases.tar.gz](https://transfer.sh/yRJWr/testcases.tar.gz) e descompactá-lo na raiz deste repositório.
2. Renomear a classe `MyProcessor` para `{SEU_NOME}Processor`.
3. Usar as flags `-Xms512M -Xms512M` ao rodar a classe `TestRunner`.
4. Rodar a classe `TestRunner` no nível 0 (`TestRunner.LEVEL = 0`) e verificar que tudo está funcionando corretamente antes da sua otimização.

**Objetivo**:

Otimizar o programa tanto em uso de CPU quanto de memória o máximo possível, mantendo o comportamento do problema.

O resultado final deve ser medido no nível 3 do TestRunner (`TestRunner.LEVEL = 3`)
