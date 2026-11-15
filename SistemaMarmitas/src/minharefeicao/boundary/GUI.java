package minharefeicao.boundary;

import java.util.List;
import java.util.Scanner;
import minharefeicao.controller.ControladorDeAssinatura;
import minharefeicao.entity.Plano;

public class GUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorDeAssinatura ctrl = new ControladorDeAssinatura();

        System.out.println("=== SISTEMA MINHA REFEIÇÃO ===");
        
        String celular = "";
        while (celular.trim().isEmpty()) {
            System.out.print("Informe seu celular: ");
            celular = scanner.nextLine();
            if (celular.trim().isEmpty()) System.out.println("O celular não pode ficar em branco!");
        }
        
        ctrl.validarCelular(celular);
        System.out.println("SMS Enviado! Código: " + ctrl.getCodigoConfirmacao());
        
        boolean autenticado = false;
        int tentativas = 3;
        while (!autenticado && tentativas > 0) {
            System.out.print("Informe o código recebido: ");
            if (ctrl.conferirCodigoValido(scanner.nextLine())) {
                autenticado = true;
                System.out.println("Autenticação realizada com sucesso!\n");
            } else {
                tentativas--;
                if (tentativas > 0) System.out.println("Código inválido! Você tem mais " + tentativas + " tentativa(s).");
            }
        }
        
        if (!autenticado) {
            System.out.println("Operação cancelada.");
            scanner.close(); return; 
        }

        List<Plano> planos = ctrl.consultarPlanosDisponiveis();
        System.out.println("Planos disponíveis:");
        for (int i = 0; i < planos.size(); i++) System.out.println((i+1) + " - " + planos.get(i));
        
        Plano planoEscolhido = null;
        while (planoEscolhido == null) {
            System.out.print("Selecione o plano (número): ");
            try {
                int opcaoPlano = Integer.parseInt(scanner.nextLine());
                if (opcaoPlano >= 1 && opcaoPlano <= planos.size()) planoEscolhido = planos.get(opcaoPlano - 1);
                else System.out.println("Opção inválida!");
            } catch (NumberFormatException e) { System.out.println("Erro: Digite apenas NÚMEROS."); }
        }
        ctrl.confirmarPlano(planoEscolhido);

        System.out.print("Informe suas preferências (ex: sem lactose, vegano) ou dê Enter para pular: ");
        ctrl.registrarPreferencias(scanner.nextLine());

        ctrl.iniciarPedido();
        
        // --- SELEÇÃO DE PRATOS PRINCIPAIS ---
        boolean maisPratos = true;
        while (maisPratos) {
            List<String> pratos = ctrl.obterPratosDisponiveis(planoEscolhido, "Geral");
            System.out.println("\n=== PRATOS PRINCIPAIS DISPONÍVEIS ===");
            for (int i = 0; i < pratos.size(); i++) System.out.println((i+1) + " - " + pratos.get(i));
            
            String pratoEscolhido = null;
            while (pratoEscolhido == null) {
                System.out.print("Selecione o prato (número): ");
                try {
                    int opcaoPrato = Integer.parseInt(scanner.nextLine());
                    if (opcaoPrato >= 1 && opcaoPrato <= pratos.size()) pratoEscolhido = pratos.get(opcaoPrato - 1);
                    else System.out.println("Opção inválida!");
                } catch (NumberFormatException e) { System.out.println("Erro: Digite apenas NÚMEROS."); }
            }
            ctrl.adicionarPratoAoPedido(pratoEscolhido);
            System.out.println("-> Prato adicionado com sucesso!");
            System.out.print("Deseja adicionar outro prato principal? (S/N): ");
            if (!scanner.nextLine().trim().toUpperCase().startsWith("S")) maisPratos = false;
        }

        // --- SELEÇÃO DE ACOMPANHAMENTOS ---
        boolean maisAcomp = true;
        while (maisAcomp) {
            List<String> acomps = ctrl.obterAcompanhamentosDisponiveis();
            System.out.println("\n=== ACOMPANHAMENTOS DISPONÍVEIS ===");
            for (int i = 0; i < acomps.size(); i++) System.out.println((i+1) + " - " + acomps.get(i));
            
            String acompEscolhido = null;
            while (acompEscolhido == null) {
                System.out.print("Selecione o acompanhamento (número): ");
                try {
                    int opcaoAcomp = Integer.parseInt(scanner.nextLine());
                    if (opcaoAcomp >= 1 && opcaoAcomp <= acomps.size()) acompEscolhido = acomps.get(opcaoAcomp - 1);
                    else System.out.println("Opção inválida!");
                } catch (NumberFormatException e) { System.out.println("Erro: Digite apenas NÚMEROS."); }
            }
            ctrl.adicionarAcompanhamentoAoPedido(acompEscolhido);
            System.out.println("-> Acompanhamento adicionado com sucesso!");
            System.out.print("Deseja adicionar outro acompanhamento? (S/N): ");
            if (!scanner.nextLine().trim().toUpperCase().startsWith("S")) maisAcomp = false;
        }

        // --- SELEÇÃO DE BEBIDAS ---
        boolean maisBebidas = true;
        while (maisBebidas) {
            List<String> bebidas = ctrl.obterBebidasDisponiveis();
            System.out.println("\n=== BEBIDAS DISPONÍVEIS ===");
            for (int i = 0; i < bebidas.size(); i++) System.out.println((i+1) + " - " + bebidas.get(i));
            
            String bebidaEscolhida = null;
            while (bebidaEscolhida == null) {
                System.out.print("Selecione a bebida (número): ");
                try {
                    int opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao >= 1 && opcao <= bebidas.size()) bebidaEscolhida = bebidas.get(opcao - 1);
                    else System.out.println("Opção inválida!");
                } catch (NumberFormatException e) { System.out.println("Erro: Digite apenas NÚMEROS."); }
            }
            ctrl.adicionarBebidaAoPedido(bebidaEscolhida);
            System.out.println("-> Bebida adicionada com sucesso!");
            System.out.print("Deseja adicionar outra bebida? (S/N): ");
            if (!scanner.nextLine().trim().toUpperCase().startsWith("S")) maisBebidas = false;
        }

        // --- SELEÇÃO DE SOBREMESAS ---
        boolean maisSobremesas = true;
        while (maisSobremesas) {
            List<String> sobremesas = ctrl.obterSobremesasDisponiveis();
            System.out.println("\n=== SOBREMESAS DISPONÍVEIS ===");
            for (int i = 0; i < sobremesas.size(); i++) System.out.println((i+1) + " - " + sobremesas.get(i));
            
            String sobremesaEscolhida = null;
            while (sobremesaEscolhida == null) {
                System.out.print("Selecione a sobremesa (número): ");
                try {
                    int opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao >= 1 && opcao <= sobremesas.size()) sobremesaEscolhida = sobremesas.get(opcao - 1);
                    else System.out.println("Opção inválida!");
                } catch (NumberFormatException e) { System.out.println("Erro: Digite apenas NÚMEROS."); }
            }
            ctrl.adicionarSobremesaAoPedido(sobremesaEscolhida);
            System.out.println("-> Sobremesa adicionada com sucesso!");
            System.out.print("Deseja adicionar outra sobremesa? (S/N): ");
            if (!scanner.nextLine().trim().toUpperCase().startsWith("S")) maisSobremesas = false;
        }

        // --- FINALIZAÇÃO ---
        System.out.println("\nResumo do Pedido: \n" + ctrl.getPedidoAtual().getResumo());
        
        String endereco = "";
        while (endereco.trim().isEmpty()) {
            System.out.print("\nInforme o endereço de entrega: ");
            endereco = scanner.nextLine();
            if (endereco.trim().isEmpty()) System.out.println("O endereço não pode ficar em branco!");
        }
        ctrl.confirmarEndereco(endereco);

        System.out.println("\nValor total: R$ " + planoEscolhido.getValor());
        
        String dadosCartao = "";
        while (dadosCartao.trim().isEmpty()) {
            System.out.print("Informe os dados do cartão de crédito: ");
            dadosCartao = scanner.nextLine();
            if (dadosCartao.trim().isEmpty()) System.out.println("Os dados do cartão são obrigatórios!");
        }
        
        System.out.println("Processando pagamento...");
        if (ctrl.realizarPagamento(dadosCartao)) {
            System.out.println("\n=== ASSINATURA CONFIRMADA ===");
            System.out.println("Protocolo: " + ctrl.finalizarEGerarProtocolo());
            System.out.println("Plano: " + planoEscolhido.getNome());
            System.out.println("Previsão da primeira entrega: Próxima segunda-feira");
            System.out.println("Dados salvos no arquivo 'assinaturas_db.csv' com sucesso!");
        } else {
            System.out.println("Pagamento recusado pela operadora do cartão.");
        }
        
        scanner.close();
    }
}