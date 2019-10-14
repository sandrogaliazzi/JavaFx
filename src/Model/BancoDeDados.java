/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cimol
 */
public class BancoDeDados {
    private boolean statusConexao;
    private Connection conexao;
    private String mensagemErro;
    private String nomeDriver = "com.mysql.cj.jdbc.Driver";
    private String nomeServidor = "localhost";
    private String portaServidor = "3306";
    private String nomeUsuario = "acervo";
    private String senha = "acervo123";
    private String nomeBanco = "acervo";
    private String url;
    
    public BancoDeDados(){
        this.url = "jdbc:mysql://" + this.nomeServidor;
        this.url+= ":" + this.portaServidor + "/" + this.nomeBanco;
        this.url+= "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        this.realizaConexao();
    }

    public boolean getStatusConexao() {
        return statusConexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
    
    public void realizaConexao(){
        try{
            Class.forName(this.nomeDriver);
            this.conexao = DriverManager.getConnection(this.url, this.nomeUsuario, this.senha);
            this.statusConexao = true;
        }catch(ClassNotFoundException | SQLException ex){
            this.mensagemErro = ex.toString();
            this.statusConexao = false;
        }
        
       
    }
    
    public void encerraConexao(){
        try{
            this.conexao.close();
            this.statusConexao = false;
        } catch(SQLException ex){
            this.mensagemErro = ex.toString();
        }
    }
}
