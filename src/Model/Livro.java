/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cimol
 */
public class Livro {
    
    public Livro(Connection conexao){
        this.conexao = conexao;
    }

    public Livro(int idLivro, String titulo, int anoLancamento, int numeroPaginas, String resumo, String pais, String idioma, Connection conexao) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.pais = pais;
        this.idioma = idioma;
        this.conexao = conexao;
    }

    public Livro(int idLivro, String titulo, int anoLancamento, int numeroPaginas, String resumo, String pais, String idioma) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.pais = pais;
        this.idioma = idioma;
    }
    
    private int idLivro;
    private String titulo;
    private int anoLancamento;
    private int numeroPaginas;
    private String resumo;
    private String pais;
    private String idioma;
    private Connection conexao;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public ResultSet obterListaLivros() throws SQLException{
        String sql = "select * from livro";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        return requisicao.executeQuery();
        
    }
    
}
