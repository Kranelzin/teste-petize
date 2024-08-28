# Projeto de Gerenciamento de Pedidos

Este projeto é um sistema para gerenciamento de pedidos que inclui um site local e serviços de backend utilizando RabbitMQ e MySQL. 

## Endpoints

- **Alterar Status do Pedido**
  - **Descrição:** Este endpoint permite alterar o status de um pedido.
  - **Método:** GET
  - **URL:** `http://localhost:8080/pedido/alterarStatus?pedidoId=1`
  - **Parâmetros:**
    - `pedidoId` (int): ID do pedido que você deseja atualizar.
  - **Exemplo de Solicitação:**
    ```bash
    curl "http://localhost:8080/pedido/alterarStatus?pedidoId=1"
    ```

## Executar o Site Local

1. **Certifique-se de que o Java está instalado.** O site está configurado para rodar na porta 8081 por padrão.

2. **Inicie o servidor frontend localmente.** Você pode fazer isso executando o seguinte comando no diretório TestePetize do seu projeto:
    ```bash
    ./mvnw spring-boot:run
    ```

3. **Inicie o servidor backend localmente.** Você pode fazer isso executando o seguinte comando no diretório TestePetizeBackend do seu projeto:
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Acesse o site no navegador.** Abra o seu navegador e vá para:
    ```
    http://localhost:8081
    ```

## Configuração de Docker

Para configurar e iniciar os serviços de MySQL e RabbitMQ, você deve usar `docker-compose`.

1. **Inicie os serviços com o comando `docker-compose`:**

    ```bash
    docker-compose up -d
    ```

    Isso iniciará os containers do MySQL e RabbitMQ em segundo plano.

2. **Acesse o RabbitMQ Management Interface (opcional):** 
   - URL: `http://localhost:15672`
   - Usuário: `guest`
   - Senha: `guest`

## Contribuição

Se você deseja contribuir para este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request.


