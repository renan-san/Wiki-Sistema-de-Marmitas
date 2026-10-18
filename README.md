# Projeto: Plataforma Minha Refeição 

**Universidade Presbiteriana Mackenzie**
**Curso:** Ciência da Computação
**Disciplina:** Projeto de Software

---

## Visão Geral do Projeto
A plataforma **Minha Refeição** é um serviço de alimentação por assinatura que permite aos clientes receberem refeições prontas em casa. O sistema possibilita contratar planos de assinatura, definir a periodicidade, selecionar pratos e acompanhamentos, registrar preferências alimentares, informar endereço e efetuar o pagamento.

## Objetivo desta Entrega (Entrega 1)
Apresentar o protótipo e o fluxo de navegação principal (Caminho Feliz) para o cenário de negócio **Assinar Plano de Refeições**.
*   **Ator Principal:** Assinante.
*   **Ator Secundário:** Operadora de Cartão de Crédito.

## Links Importantes
*   **Protótipo Interativo (Figma):** https://www.figma.com/proto/nE7LPY0XSAsMsOTVRmASM5/Sistema-de-Marmitas?node-id=0-1&t=L64IPhfzMGAJaKjZ-1
*   **Vídeo de Apresentação:** https://youtu.be/fcTLTQqnB_o?is=irvL3N6QeavnBn63

## Fluxo de Navegação (Caminho Feliz)
A sequência de telas prototipada reflete estritamente os passos do fluxo principal:

**1. Tela de Autenticação**
*O usuário informa o seu número de celular para iniciar o acesso à plataforma.*

![Tela 1 - Autenticação](Pagina_1.png)

**2. Tela de Validação SMS**
*O sistema solicita o código de confirmação enviado por SMS e realiza a validação de segurança.*

![Tela 2 - Validação SMS](Pagina_2.png)

**3. Tela de Planos de Assinatura**
*Apresentação dos planos disponíveis, detalhando a quantidade de refeições, a periodicidade de entrega e o valor do pacote.*

![Tela 3 - Planos de Assinatura](Pagina_3.png)

**4. Tela de Preferências Alimentares**
*Solicitação e armazenamento das restrições do cliente, com as opções: tradicional, vegetariana ou sem lactose.*

![Tela 4 - Preferências Alimentares](Pagina_4.png)

**5. Tela de Pratos Principais**
*Exibição e seleção dos pratos principais disponíveis no cardápio, filtrados pelas preferências informadas.*

![Tela 5 - Pratos Principais](Pagina_5.png)

**6. Tela de Acompanhamentos**
*Exibição e seleção das opções de acompanhamentos para compor as refeições.*

![Tela 6 - Acompanhamentos](Pagina_6.png)

**7. Tela de Sobremesas**
*Exibição e seleção das opções de sobremesas disponíveis para o plano.*

![Tela 7 - Sobremesas](Pagina_7.png)

**8. Tela de Resumo do Pedido**
*Apresentação da composição completa do pedido, agrupando os itens escolhidos para a conferência do assinante.*

![Tela 8 - Resumo do Pedido](Pagina_8.png)

**9. Tela de Endereço de Entrega**
*Formulário para o assinante informar, confirmar e armazenar o endereço onde as marmitas serão entregues.*

![Tela 9 - Endereço de Entrega](Pagina_9.png)

**10. Tela de Pagamento**
*Com a assinatura com status de Aguardando Pagamento, o sistema apresenta o valor total e solicita os dados do cartão de crédito.*

![Tela 10 - Pagamento](Pagina_10.png)

**11. Tela de Confirmação Final**
*Tela de sucesso gerada após a aprovação do pagamento, exibindo o número de protocolo gerado, o resumo do plano e a previsão da primeira entrega.*

![Tela 11 - Confirmação Final](Pagina_11.png)

---

## Lista de Classes Candidatas Identificadas

* **`Assinante`:**
  * **Descrição:** Representa o cliente que realiza a contratação do plano de refeições e a seleção dos pratos.
  * **Atributos:** `numeroCelular`, `codigoConfirmacao`, `statusValidacao`.

---

* **`PlanoAssinatura`:**
  * **Descrição:** Define as opções de pacotes disponíveis para contratação.
  * **Atributos:** `nomePlano`, `quantidadeRefeicoes`, `periodicidadeEntrega`, `valor`.
* **`PreferenciasAlimentares`:**
  * **Descrição:** Agrupa as restrições e tipos de alimentação definidos pelo assinante.
  * **Atributos:** `tipoPreferencial` (ex: Tradicional, Vegetariana, Sem Lactose).
* **`CardapioSemana`:**
  * **Descrição:** Estrutura as refeições disponíveis no período ativo, filtradas conforme o plano e preferências.
  * **Atributos:** `dataInicio`, `dataFim`, `listaRefeicoes`.
* **`Refeicao`:**
  * **Descrição:** Item individual disponível no cardápio.
  * **Atributos:** `idRefeicao`, `nome`, `categoria`.
  * **Especializações / Subclasses:**
    * **`PratoPrincipal`:** Opções de pratos principais disponíveis.
    * **`Acompanhamento`:** Opções de acompanhamentos disponíveis.
    * **`Sobremesa`:** Opções de sobremesas disponíveis.

---

* **`Assinatura`:**
  * **Descrição:** Representa o contrato de assinatura ativo ou pendente do usuário no sistema.
  * **Atributos:** `numeroProtocolo`, `statusAssinatura`, `dataAtivacao`.
* **`PedidoPlano` / `Carrinho`:**
  * **Descrição:** Agrupa as seleções feitas pelo assinante para o ciclo contratado.
  * **Atributos:** `pratosPrincipaisSelecionados`, `acompanhamentosSelecionados`, `sobremesasSelecionadas`
* **`EnderecoEntrega`:**
  * **Descrição:** Armazena as informações do local onde as marmitas serão entregues.
  * **Atributos:** `endereço`, `complemento`, `bairro`, `cidade`,`estado`, `cep`.
* **`Pagamento`:**
  * **Descrição:** Modela a transação financeira da assinatura e a interação com a operadora de cartão.
  * **Atributos:** `dadosCartao`, `statusPagamento`, `dataHoraTransacao`.

---

## Equipe e Distribuição de Responsabilidades
*   **Renan Dos Santos Jesus (RA: 10748027)** Estruturação da WIKI e criação de telas.
*   **João Pedro Nascimento Simões (RA: 10427517)** Estruturação do fluxo no Figma e criação de telas.
# Modelo de Domínio — Serviço de Assinatura de Marmitas

## Participantes 

João Pedro Nascimento Simões - 10427517  
Renan Dos Santos Jesus - 10748027

Caso de uso: **Assinar Plano de Refeições**

## Dicionário de Classes

| Classe | Descrição | Atributos |
|---|---|---|
| Assinante | Contrata o serviço, identificado por celular validado via SMS | `numeroCelular`, `preferenciaAlimentar` |
| EnderecoEntrega | Endereço de entrega vinculado ao assinante | `logradouro`, `numero`, `cep` |
| Assinatura | Contrato ativo do assinante com um plano | `numeroProtocolo`, `status` |
| PlanoAssinatura | Regras comerciais contratadas | `nome`, `quantidadeRefeicoes`, `periodicidade`, `valor` |
| Pedido | Seleção de itens do cardápio gerada dentro de uma assinatura | `status` |
| Pagamento | Tentativa/transação de cobrança da assinatura | `dadosCartaoCredito`, `statusAutorizacao` |
| ItemCardapio | Prato/acompanhamento/sobremesa, diferenciado por `categoria` | `nome`, `categoria` |

Operadora de Cartão de Crédito não entrou como classe: é ator externo, fora do domínio interno.

## Diagrama

<img width="1450" height="1151" alt="WhatsApp Image 2026-09-20 at 16 51 04" src="https://github.com/user-attachments/assets/91dd0105-e15e-49e4-abdc-2b0fac45f329" />

## Associações

| Associação | Sentido | Multiplicidade | Tipo |
|---|---|---|---|
| possui | Assinante → EnderecoEntrega | 1 — 1..* | Simples |
| realiza | Assinante → Assinatura | 1 — 0..* | Simples |
| vincula | Assinatura → PlanoAssinatura | 0..* — 1 | Simples |
| contém | Assinatura → Pedido | 1 — 1..* | Composição |
| processa | Assinatura → Pagamento | 1 — 1..* | Simples |
| contém | Pedido → ItemCardapio | 1 — 1..* | Composição |

