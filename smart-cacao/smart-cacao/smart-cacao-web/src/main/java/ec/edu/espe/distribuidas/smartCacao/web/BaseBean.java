/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import javax.ejb.Stateless;

/**
 *
 * @author joel
 */
@Stateless
public class BaseBean {
    
    protected boolean enAgregar;
    protected boolean enModificar;
    protected boolean enDetalles;
    protected String titulo;
    
    public boolean isEnAgregar() {
        return enAgregar;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnDetalles() {
        return enDetalles;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void agregar()
    {
        this.enAgregar = true;
        this.titulo="Agregar";
    }
    
    public void modificar(){
        this.enModificar = true;
        this.titulo = "Modificar ";
    }
    
    public void detalles() {
        this.enDetalles = true;
        this.titulo = "Detalles - ";
    }
    
    public void reset() {
        this.enAgregar = false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public boolean isHabilitaForm() {
        return this.enAgregar || this.enDetalles || this.enModificar;
    }
}
