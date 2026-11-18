package minharefeicao.controller;

import minharefeicao.entity.Pagamento;

public class ControladorDePagamento {
    private Pagamento entidadePagamento = new Pagamento();

    // 52 processarPagamento()
    public boolean processarPagamento(String dadosCartao) {
        // Fluxo Alternativo: Se os dados forem "0000" ou em branco, a operadora recusa
        boolean autorizacaoAprovada = !(dadosCartao == null || dadosCartao.trim().isEmpty() || dadosCartao.equals("0000"));
        
        if (autorizacaoAprovada) {
            // 55 registrarPagamento()
            entidadePagamento.registrarPagamento(dadosCartao);
            return true; // 57 pagamentoAprovado
        }
        
        return false; // Pagamento recusado pela operadora
    }
}