# Poke_Api
Poke_API é um aplicativo desenvolvido em Kotlin que se conecta à API oficial de Pokémons para fornecer aos usuários informações detalhadas sobre seus Pokémons favoritos. Com uma interface moderna construída utilizando Jetpack Compose, o aplicativo oferece uma experiência nativa e fluida. Seguindo o padrão MVVM e uma arquitetura limpa, o Poke_API organiza os dados de forma eficiente. Com a utilização da API pública do POKÉAPI(https://pokeapi.co/) para acessar dados atualizados, o aplicativo oferece uma experiência dinâmica e interativa para todos os fãs da franquia.
## Componentes da arquitetura do Android:
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).
  * Poke_Api usa o componente ViewModel dos componentes de arquitetura do Android para gerenciar e armazenar dados relacionados à interface do usuário de maneira consciente do ciclo de vida. Isso garante que os dados persistam nas alterações de configuração e sejam facilmente acessíveis aos componentes da interface do usuário.
## Injeção de dependência:
* [Injeção de dependências com o Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
  * O aplicativo utiliza a injeção de dependência com o Hilt, uma biblioteca recomendada pelo Android para facilitar a configuração e a resolução de dependências. O Hilt simplifica a criação e o gerenciamento de objetos necessários em diferentes partes do aplicativo, tornando o desenvolvimento mais eficiente e organizado.
## Programação assíncrona:
* [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html).
* [Asynchronous Flow](https://kotlinlang.org/docs/flow.html).
  * Para tratar operações assíncronas, o Poke_Api utiliza as Kotlin Coroutines. As Coroutines são uma maneira eficiente e concisa de escrever código assíncrono em Kotlin, permitindo que tarefas demoradas sejam executadas sem bloquear a thread principal. Além disso, o aplicativo utiliza o Asynchronous Flow, que é uma extensão das Coroutines, para trabalhar com sequências de valores assíncronos de forma simples e elegante.
## Outros componentes do Android:
* [Jetpack Compose](https://developer.android.com/jetpack/compose).
  * O Poke_Api também aproveita o Jetpack Compose, um moderno toolkit de interface do usuário para a criação de interfaces nativas do Android. Com o Jetpack Compose, é possível desenvolver interfaces de usuário dinâmicas e responsivas, proporcionando uma experiência visualmente atraente e interativa aos usuários.
## Outras Bibliotecas:
* [Retrofit](https://square.github.io/retrofit/).
  * O Retrofit é utilizado no Poke_Api para facilitar a integração com a API POKÉAPI. Essa biblioteca simplifica a comunicação de rede ao converter chamadas HTTP em objetos Kotlin de maneira fácil e declarativa, tornando o processo de obtenção dos dados meteorológicos da API mais eficiente e conveniente.
* [Coil](https://coil-kt.github.io/coil/).
  * Coil (Image Loading for Android) é uma poderosa e eficiente biblioteca de carregamento de imagens para Android, projetada para ser rápida e fácil de usar. No Poke_API, o Coil é utilizado para carregar imagens de Pokémons de maneira otimizada, garantindo que as imagens sejam exibidas de forma fluida e com baixo consumo de memória. Com suporte para imagens em cache, transformação e carregamento assíncrono, o Coil permite que o aplicativo forneça uma experiência de usuário mais rápida e responsiva, sem comprometer o desempenho. Além disso, sua integração com Jetpack Compose torna o processo de exibição de imagens ainda mais simples e intuitivo.
