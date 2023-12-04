# Microsservice Demo

O MicroCredit Demo é um projeto de demonstração desenvolvido para treinar a arquitetura de microsserviços. O objetivo principal é simular o processo de solicitação de cartão de crédito, dividindo as funcionalidades em três microsserviços distintos que interagem entre si. Cada microsserviço tem uma responsabilidade específica no gerenciamento global do sistema.

## Microsserviços

1. **Clientes Microservice**
   - Responsável pelo gerenciamento de informações dos clientes.
   - Armazena e fornece informações sobre os clientes, como nome, histórico de crédito, etc.

2. **Cards Microservice**
   - Gerencia os cartões disponíveis no sistema.
   - Mantém informações sobre os diferentes tipos de cartões de crédito oferecidos, limites, taxas, etc.

3. **msCreditEvaluator (Avaliador de Crédito) Microservice**
   - Encarregado de avaliar a solicitação de cartão de crédito de um cliente.
   - Consulta os microsserviços de Clientes e Cartões para determinar quais cartões estão disponíveis e adequados para uma determinada solicitação.

## Funcionamento

- Um cliente interessado em obter um cartão de crédito faz uma solicitação para o microsserviço de Avaliação de Crédito.
- O Avaliador de Crédito consulta os microsserviços de Clientes e Cartões para obter informações relevantes.
- Com base nessas informações, o Avaliador de Crédito determina quais cartões estão disponíveis e se o cliente atende aos requisitos para a aprovação do cartão.

## Como Executar o Projeto

1. Clone o repositório.
2. Inicie cada microsserviço separadamente.
3. Certifique-se de que os microsserviços estão se comunicando corretamente entre si.
4. Simule solicitações de cartões de crédito para observar o processo de avaliação.

## Observações

- Este projeto é destinado a fins educacionais e de treinamento na arquitetura de microsserviços.
- Cada microsserviço é independente e pode ser escalonado separadamente para otimizar o desempenho do sistema.
- As interações entre os microsserviços são fundamentais para o funcionamento correto do sistema.

Sinta-se à vontade para explorar, modificar e contribuir para o desenvolvimento contínuo do MicroCredit Demo. Dúvidas e feedbacks são bem-vindos!
