# Sistema de Assinatura de Marmitas - "Minha Refeição"

**Universidade Presbiteriana Mackenzie**  
**Faculdade de Computação e Informática (FCI) - Ciência da Computação**  
**Disciplina:** Projeto de Software  

**Equipe:**
- Renan Dos Santos Jesus (RA: 10748027)
- João Pedro Nascimento Simões (RA: 10427517)
- Mateus Fernandes de Araujo (RA: 107310580)

---

## Sobre o Projeto
Implementação em Java do caso de uso **"Assinar Plano de Refeições"**. O objetivo é traduzir os diagramas UML (Sequência e Classes) em código-fonte, garantindo a correspondência entre a modelagem de análise e o software produzido.

## Arquitetura e Mapeamento UML (Padrão BCE)
O sistema segue o padrão **BCE (Boundary, Control, Entity)**:

- **Boundary (Fronteira):** 
  * `GUI.java`: Interface do usuário. Captura os dados do assinante (plano, refeições, endereço, pagamento) e gerencia exceções.
- **Control (Controladora):** 
  * `ControladorDeAssinatura.java`: Orquestra o fluxo principal, validações e etapas do pedido.
  * `ControladorDePagamento.java`: Simula a autorização com a operadora de cartão.
- **Entity (Entidades):** 
  * `Assinatura.java`, `Pedido.java`, `Plano.java`, `Cardapio.java`, `Pagamento.java`: Mantêm o estado e as regras de negócio.
- **Persistência:** 
  * `PersistenciaCSV.java`: Grava as assinaturas aprovadas no arquivo `.csv`.

## Vídeo de Apresentação
Link do Video:

## Como Executar

**Pré-requisitos:** Java JDK 11 ou superior.

Execute os comandos abaixo sequencialmente no terminal:

```bash
# 1. Clone o repositório:
git clone [https://github.com/renan-san/Wiki-Sistema-de-Marmitas.git](https://github.com/renan-san/Wiki-Sistema-de-Marmitas.git)

# 2. Acesse a pasta do código-fonte:
cd SistemaMarmitas/src

# 3. Compile os arquivos:
javac minharefeicao/boundary/GUI.java minharefeicao/controller/*.java minharefeicao/entity/*.java minharefeicao/persistence/*.java

# 4. Execute o sistema:
java minharefeicao.boundary.GUI
