package minharefeicao.entity;

import java.util.Arrays;
import java.util.List;

public class Cardapio {
    public List<String> consultarPratos(Plano plano, String preferencias) {
        return Arrays.asList("Frango Grelhado", "Strogonoff de Carne", "Picadinho de Carne", "Opção Vegana: Grão de Bico", "Lasanha de Berinjela");
    }

    public List<String> consultarAcompanhamentos() {
        return Arrays.asList("Arroz Branco", "Arroz Integral", "Feijão Carioca", "Purê de Batata", "Salada Mista", "Legumes no Vapor");
    }
    
    // NOVO: Bebidas
    public List<String> consultarBebidas() {
        return Arrays.asList("Suco de Laranja Natural", "Refrigerante Cola", "Água Mineral com Gás", "Chá Gelado de Pêssego");
    }

    // MELHORADO: Sobremesas
    public List<String> consultarSobremesas() {
        return Arrays.asList("Pudim de Leite Condensado", "Salada de Frutas", "Mousse de Maracujá", "Brownie de Chocolate");
    }
}