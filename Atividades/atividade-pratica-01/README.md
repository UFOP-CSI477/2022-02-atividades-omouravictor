# Blood Donation Api

API Rest criada com spring-boot e linguagem Kotlin para gerenciamento de doações de sangue.

## Requisitos para rodar a aplicação:

  - Inicialize um servidor de banco de dados MySQL na porta 3306 no seu localhost. (XAMPP pode ser utilizado para isto).
  - Tenha o driver JDBC do MySQL instalado (o driver pode ser baixado diretamente pelo Intellij).
  - Certifique-se que não exista um schema com o nome "blood_donation_db" pois ao rodar o projeto será criado automaticamente um schema com este nome.

## Algumas funcionalidades da aplicação:

Obs: Os atributos createdAt e updatedAt são salvos e gerenciados automaticamente pela aplicação.

- Crie 2 Estados com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223603909-6587b84c-1e86-4845-b979-3e361395216f.png"></td>
      <td><img src="https://user-images.githubusercontent.com/64164023/223604132-05a2a3e3-0469-491e-b5db-4a379d731126.png"></td>
    </tr>
  </table>

- Crie 2 Tipos Sanguíneos com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223604828-25785609-d161-487c-9b51-94d5b7fbec19.png"></td>
      <td><img src="https://user-images.githubusercontent.com/64164023/223605223-e6134447-a24a-4034-9c1c-ca428f9778ad.png"></td>
    </tr>
  </table>
  
- Crie 4 Cidades com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223605552-9e5b124d-43a4-4857-9795-047d76935b25.png"></td>
      <td><img src="https://user-images.githubusercontent.com/64164023/223605654-db9d5804-ee3d-4693-a842-4eff7bf0d3c3.png"></td>
    </tr>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223606235-65971f33-7256-43e1-9265-1f2260184ee8.png"></td>
      <td><img src="https://user-images.githubusercontent.com/64164023/223606323-a834f6bb-bc82-4abc-a502-7417aa6afb1b.png"></td>
    </tr>
  </table>

- Crie 1 Local de Coleta com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223606743-2a06a447-15ce-4a4c-9725-53155f8f7ecb.png"></td>
    </tr>
  </table>
  
- Crie 1 Pessoa com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223606989-4649caaf-1d66-4018-92f0-39a2bcebcc8d.png"></td>
    </tr>
  </table>
 
 - Crie 1 Doação com o método POST

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223607246-0bbe28e4-f9f7-416f-9e87-d501920aced5.png"></td>
    </tr>
  </table>

 - Atualize os dados de uma Pessoa com o método PUT

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223607469-3fe3ec8a-5450-4ff2-977e-0f321613afea.png"></td>
    </tr>
  </table>

 - Delete uma Cidade com o método DELETE

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223607628-d2097e9e-c3d1-464d-b3b7-b1b4137b8a4c.png"></td>
    </tr>
  </table>

 - Obtenha todas as Cidades com o método GET

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223607782-0d163a90-3df6-47f4-bff6-ba5231a9328a.png"></td>
    </tr>
  </table>

 - Obtenha todas as Cidades de um determinado Estado com o método GET

  <table>
    <tr>
      <td><img src="https://user-images.githubusercontent.com/64164023/223607978-1684193f-947d-4e16-a113-c435f7f356d1.png"></td>
    </tr>
  </table>
