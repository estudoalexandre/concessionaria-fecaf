# Projeto Gerenciador de Veículos

## Descrição
Este projeto é um sistema de gerenciador de veículos desenvolvido em **Spring Boot** com integração ao **Thymeleaf** para renderização de templates dinâmicos. Ele permite o cadastro, visualização, edição e exclusão de veículos no sistema.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Thymeleaf**
- **Bootstrap 5**
- **Hibernate** (para persistência de dados)
- **MySQL** (banco de dados)

## Funcionalidades
- Cadastro de veículos de diferentes tipos: carros e motos.
- Edição dos dados de veículos existentes.
- Exclusão de veículos.
- Visualização detalhada dos veículos.
- Renderização condicional de atributos dinâmicos com Thymeleaf.

## Estrutura do Projeto
1. **Configuração inicial**
   - Projeto criado com **Maven**.
   - Configuração do `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/veiculos_db
     spring.datasource.username=usuario
     spring.datasource.password=senha
     spring.jpa.hibernate.ddl-auto=validate
     spring.jpa.show-sql=true
     ```

2. **Modelos**
   - Entidade `Veiculo` foi definida como uma classe abstrata.
   - Subclasses `Carro` e `Moto` foram criadas para representar os tipos específicos de veículos, cada uma com atributos exclusivos.

3. **Controller**
   - Criado um **Controller** para lidar com rotas como:
     - `/veiculos` - Listar todos os veículos.
     - `/veiculos` - Cadastro de novos veículos apartir de um formulario na propria pagina da lista de veiculos.
     - `/veiculos/editar/{id}` - Edição de veículos.
     - `/veiculos/deletar` - Exclusão de veículos.

4. **Templates Thymeleaf**
   - **Thymeleaf** foi usado para renderizar os dados dinâmicos no HTML, como listar os veículos em uma tabela e exibir detalhes de um veículo.
   - Exemplo de uso:
     ```html
     <tr th:each="veiculo : ${veiculos}">
         <td th:text="${veiculo.modelo}"></td>
         <td th:text="${veiculo.marca}"></td>
     </tr>
     ```

5. **CSS e Bootstrap**
   - Estilização feita com **Bootstrap 5**.
   - CSS adicional configurado no diretório `src/main/resources/static/css` e referenciado no HTML usando `th:href`.

6. **Banco de Dados**
   - Estrutura de tabelas para `veiculos`, `carros` e `motos` foi criada manualmente.
   - Tipos dinâmicos tratados pelo relacionamento de herança no Hibernate.

7. **Regras de Negócio**
   - Validação do tipo do veículo no backend.
   - Renderização condicional no frontend com Thymeleaf para exibir campos específicos de acordo com o tipo do veículo.

8. **Integração do HTML com Thymeleaf**
   - Integração para preencher valores dinâmicos nos formulários e tabelas.
   - Exemplo de renderização condicional:
     ```html
     <tr th:if="${veiculo.tipo} == 'carro'">
         <td th:text="${veiculo.motor}">Motor</td>
     </tr>
     ```

## Passo a Passo do Desenvolvimento
1. **Iniciação do projeto**
   - Criação do projeto Maven no **Spring Initializr**.
   - Dependências adicionadas: Spring Web, Spring Data JPA, Thymeleaf, MySQL Driver.

2. **Configuração do Banco de Dados**
   - Conexão configurada no arquivo `application.properties`.
   - Tabelas criadas manualmente no MySQL e validadas pelo Hibernate.

3. **Modelagem das Entidades**
   - Criadas as classes `Veiculo`, `Carro` e `Moto`.
   - Relacionamento de herança mapeado no JPA.

4. **Desenvolvimento do Backend**
   - Criação das rotas REST no Controller.
   - Implementação de lógica para cadastro, edição, visualização e exclusão.

5. **Integração com Thymeleaf**
   - Templates criados para listar, visualizar e editar veículos.
   - Dados dinâmicos renderizados usando expressões Thymeleaf.

6. **Teste e Ajustes Finais**
   - Testes realizados para garantir que todos os fluxos estavam funcionando corretamente.
   - Problemas como inconsistências no tipo do veículo resolvidos com ajustes na lógica.

## Como Executar o Projeto
1. Clone o repositório para sua máquina local.
2. Configure o arquivo `application.properties` com suas credenciais do banco de dados.
3. Execute o projeto com:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a aplicação no navegador em: `http://localhost:8080/veiculos`.

## Melhorias Futuras
- Implementar autenticação e autorização para gerenciar veículos.
- Adicionar upload de imagens para os veículos.
- Melhorar os relatórios e filtros de busca.

---

**Autor:** Alexandre Oliveira

