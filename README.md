# Lemonade App

O **Lemonade App** é um aplicativo Android simples que guia o usuário através de diferentes etapas de fazer uma limonada: selecionar um limão, espremê-lo, beber a limonada e reiniciar o ciclo. Ele usa o Jetpack Compose para a interface de usuário, permitindo fácil transição entre as etapas.

## Descrição do Projeto

O aplicativo funciona através de um ciclo de quatro etapas:

1. **Selecione o Limão**: O usuário começa selecionando um limão clicando na árvore de limoeiros.
2. **Esprema o Limão**: Após selecionar o limão, o usuário é levado para a etapa de espremer o limão.
3. **Beba a Limonada**: Depois de espremer o limão, a próxima etapa é beber a limonada.
4. **Reinicie o Ciclo**: Uma vez que o copo está vazio, o usuário pode reiniciar o ciclo clicando para começar de novo.

## Funcionalidades

- **Ciclo de quatro etapas** com transições entre cada uma delas.
- **Imagens** para representar cada etapa.
- **Texto descritivo** que muda conforme a etapa.
- **Interatividade**: Ao clicar na imagem, o aplicativo avança para a próxima etapa.

## Capturas de Tela

### Selecionar Limão
![Selecione o limão](https://github.com/LABELLECANDIDO/ExercicioLimonada/blob/main/app/src/main/res/imagens/selecionaLimao.png)

### Espremer o Limão
![Esprema o limão](https://github.com/LABELLECANDIDO/ExercicioLimonada/blob/main/app/src/main/res/imagens/espremerlimao.png)

### Beber a Limonada
![Beba a limonada](https://github.com/LABELLECANDIDO/ExercicioLimonada/blob/main/app/src/main/res/imagens/tomelimonada.png)

### Reiniciar o Ciclo
![Reinicie o ciclo](https://github.com/LABELLECANDIDO/ExercicioLimonada/blob/main/app/src/main/res/imagens/copovazio.png)

## Como Rodar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/usuario/lemonade-app.git
    ```
2. Abra o projeto no **Android Studio**.
3. Conecte um dispositivo físico ou inicie um emulador.
4. Execute o aplicativo.

## Estrutura do Código

O código está dividido em dois arquivos principais:

- **MainActivity.kt**: Define a `MainActivity`, que é o ponto de entrada do app. Ela configura o tema e carrega o composable `LemonApp`.
- **LemonApp**: Função que gerencia as transições entre as quatro etapas do ciclo da limonada, utilizando o estado do Compose para rastrear qual etapa está ativa.

```kotlin
val (imageResource, textResource) = when (currentStep) {
    1 -> Pair(R.drawable.lemon_tree, R.string.lemon_select)
    2 -> Pair(R.drawable.lemon_squeeze, R.string.lemon_squeeze)
    3 -> Pair(R.drawable.lemon_drink, R.string.lemon_drink)
    4 -> Pair(R.drawable.lemon_restart, R.string.lemon_empty_glass)
    else -> Pair(R.drawable.lemon_tree, R.string.lemon_select)
}
