package vitorr0099.SistemaEstoque.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private Long id;
    private String codigo;
    private String nome;
    private int quantidade;
    private BigDecimal precoUnitario;
    private String localizacao;
    private String unidadeMedida;

    // Construtor vazio
    public ProdutoDTO() {}

    // Construtor com parâmetros
    public ProdutoDTO(Long id, String codigo, String nome, int quantidade, BigDecimal precoUnitario, String localizacao, String unidadeMedida) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.localizacao = localizacao;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}
