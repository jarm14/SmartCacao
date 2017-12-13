/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.enums;

/**
 *
 * @author TMET
 */
public enum TipoUsuarioEnum {
    
    ADM("ADMINISTRADOR"),
    OPE("OPERACIONAL");
    
    private String texto;

    private TipoUsuarioEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
