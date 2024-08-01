# JWT Validation API

Esta é uma API desenvolvida com Spring Boot que valida JSON Web Tokens (JWTs) com base em regras específicas. A API está configurada para rodar em um container Docker e está hospedada na Azure.

## Funcionalidades

- **Valida JWTs**: Recebe um JWT e verifica se ele é válido de acordo com regras definidas.
- **Regras de Validação**:
  - Deve ser um JWT válido.
  - Deve conter exatamente 3 claims: Name, Role e Seed.
  - A claim `Name` não pode conter caracteres numéricos.
  - A claim `Role` deve conter apenas um dos três valores: Admin, Member ou External.
  - A claim `Seed` deve ser um número primo.
  - O tamanho máximo da claim `Name` é de 256 caracteres.

## Requisitos

- Java 21
- Maven
- Docker
- Azure

## Construindo o Projeto

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/guipetena/back-challenge.git
   cd back-challenge
   ```

2. **Construir o Projeto**

   Execute o comando abaixo para compilar o projeto e gerar o JAR:

   ```bash
   mvn clean package
   ```

## Docker

### Construindo a Imagem Docker

1. **Criar a Imagem Docker**

   No diretório do projeto, execute:

   ```bash
   docker build -t your-app .
   ```

### Executando a Imagem Docker

1. **Rodar o Container**

   Após construir a imagem, execute o container com o seguinte comando:

   ```bash
   docker run -d -p 8080:8080 your-app
   ```

## Azure

A API está hospedada na Azure e pode ser acessada pelo IP público fornecido. Para interagir com a API, use o seguinte endpoint:

### Endpoint

```
http://petena.brazilsouth.cloudapp.azure.com:8080/api/validate-jwt?jwt={jwt}
```

Substitua `{jwt}` pelo token JWT que deseja validar.

### Exemplos de Requisição

**Exemplo 1:**

```
GET http://petena.brazilsouth.cloudapp.azure.com:8080/api/validate-jwt?jwt=eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg
```

**Resposta:**

```json
{
  "result": true
}
```

**Exemplo 2:**

```
GET http://petena.brazilsouth.cloudapp.azure.com:8080/api/validate-jwt?jwt=eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs
```

**Resposta:**

```json
{
  "result": false
}
```

## Logs e Diagnóstico

Para acessar os logs do container Docker, siga os passos abaixo:

1. **Acesse o Container**

   Primeiro, obtenha o ID ou nome do container:

   ```bash
   docker ps
   ```

2. **Visualize os Logs**

   Use o comando abaixo para visualizar os logs:

   ```bash
   docker logs <container_id_or_name>
   ```

## Configuração de Segurança

Certifique-se de que as regras de firewall e segurança estejam configuradas para permitir o tráfego na porta 8080, e que a aplicação esteja protegida adequadamente para evitar acessos não autorizados.

## Contribuição

Sinta-se à vontade para contribuir com o projeto. Para fazer isso, faça um fork do repositório, crie uma branch para suas alterações e envie um pull request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
