# **CSI606-2021-02 - Remoto - Trabalho Final - Resultados**

## *Aluno(a): Victor Gabriel Siqueira Moura

--------------

### Resumo

O trabalho consiste em uma biblioteca de filmes consumindo a [TMDB API](https://www.themoviedb.org/documentation/api). O back-end e front-end da aplicação estão construídos em javascript, com utilização do React no front. A aplicação oferece ao usuário uma experiência de descoberta e detalhamento de filmes.

### 1. Funcionalidades implementadas

- Descoberta de filmes populares.
- Descoberta de filmes melhores avaliados.
- Descoberta de filmes através de gêneros.
- Possibilidade de assistir o TRAILER de um filme.
- Filtragem personalizada de filmes.
- Visualização detalhada de filmes como sinopse, gênero relacionado, nota de avaliação, elenco, tempo de duração, ano de lançamento etc.

### 2. Funcionalidades previstas e não implementadas

- Felizmente todas as funcionalidades foram implementadas. O próximo passo da aplicação será criar uma lista de filmes para assistir mais tarde.

### 3. Outras funcionalidades implementadas

- Exibição de filmes recomendados na consulta de um filme.
- Possibilidade de acesso ao IMDB (The Internet Movie Database) do filme consultado.
- Exibição da página "elenco" ao clicar em alguma pessoa do elenco de um filme, possibilitando a visualização da bibliografia, IMDB e exibição de outros filmes que ela participou.

### 4. Principais desafios e dificuldades

Meu principal desafio foi lidar com o gerenciamento de estado do React para lidar com a lógica da aplicação e a comunicação com a API. Outro desafio foi a configuração inicial das rotas com o React Router. 

### 5. Instruções para instalação e execução

A aplicação foi construída com o NodeJs na versão **14.21.2**. Entretanto, a aplicação pode não funcionar caso a versão do Node seja mais recente. Uma dica é instalar o **NVM**  que permite você ter várias versões do Node instaladas e trocar de versão quando quiser. [Link Windows](https://github.com/coreybutler/nvm-windows/releases), [Link Linux](https://github.com/nvm-sh/nvm)

- Tenha uma chave de acesso para API TMDB. Caso não tenha, é possível criar uma gratuitamente através deste [Link](https://developers.themoviedb.org/3/getting-started/introduction).
- Crie um arquivo **.env** na pasta raiz do projeto e adicione a sua chave da API TMDB da seguinte forma:
    ```
    REACT_APP_TMDB_API=sua_chave_da_api_tmdb
    ```
- Abra a pasta my-movies do projeto pelo terminal e rode o comando `npm install` ou `yarn install` para adicionar todas as dependências do projeto.
- Agora basta rodar o comando `npm start` ou `yarn start` e aguardar o projeto ser inicializado no navegador (localhost).

### 6. Referências

- Norouzii, Mohammad Reza. TopCine. Disponível em: https://github.com/mohammadrezanorouzii/topcine. Acesso em: 26 fev. 2023.
- Tohirovich, Otabek. React-movie-app. Disponível em: https://github.com/OtabekTohirovich/React-movie-app. Acesso em: 26 fev. 2023.
