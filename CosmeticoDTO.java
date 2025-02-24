/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsertaope.cs.crud_farmaciaGASA.dto;

import javax.swing.JOptionPane;

/**
 *
 * @author talit
 */
public class CosmeticoDTO {
    

    private int CodCosmetico;
    private String nome;
    private float preco;
    private int quantidade;

    public CosmeticoDTO(int CodCosmetico, String nome, float preco, int quantidade) {
        this.CodCosmetico= CodCosmetico;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public CosmeticoDTO(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodCosmetico() {
        return CodCosmetico;
    }

    public void setCodCosmetico(int CodCosmetico) {
        this.CodCosmetico = CodCosmetico;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public float getpreco() {
        return preco;
    }

    public void setpreco(float preco) {
        this.preco = preco;
    }

    public int getquantidade() {
        return quantidade;
    }

    public void setquantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.CodCosmetico;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CosmeticoDTO other = (CosmeticoDTO) obj;
        return this.CodCosmetico== other.CodCosmetico;
    }

}