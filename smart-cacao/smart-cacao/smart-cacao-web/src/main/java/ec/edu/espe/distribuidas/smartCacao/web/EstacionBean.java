/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import ec.edu.espe.distribuidas.smartCacao.model.Mes;
import ec.edu.espe.distribuidas.smartCacao.service.EstacionService;
import ec.edu.espe.distribuidas.smartCacao.service.MesService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joel
 */
@Named
@ViewScoped
public class EstacionBean extends BaseBean implements Serializable{
    
    private List<Mes> meses;
    private Mes mes;
    private List<Estacion> estaciones;
    private Estacion estacion;
    private Estacion estacionSel;
    
    @Inject
    private MesService mesService;
    
    @Inject
    private EstacionService estacionService;
    
    @PostConstruct
    public void init() {
        this.estaciones = this.estacionService.obtenerTodos();
        this.estacion = new Estacion();
        this.meses = this.mesService.obtenerTodos();
        this.mes = new Mes();
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.listaTipoU = new ArrayList<>();
        TipoUsuario aux = new TipoUsuario();

        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            listaTipoU.add(aux.getDescripcion());
        }

        this.usuario = new Usuario();
        this.usuario.setCodigo(this.usuarioSel.getCodigo());
        this.usuario.setCodTipoUsuario(this.usuarioSel.getCodTipoUsuario());
        this.usuario.setNombre(this.usuarioSel.getNombre());
        this.usuario.setApellido(this.usuarioSel.getApellido());
        this.usuario.setPassword(this.usuarioSel.getPassword());
        this.usuario.setTelefono(this.usuarioSel.getTelefono());
        this.usuario.setEmail(this.usuarioSel.getEmail());
    }

    public void eliminar() {
        try {
            this.estacionService.eliminar(this.estacionSel.getEstacionPK());
            this.estaciones = this.estacionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.estacionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            this.usuario.setCodTipoUsuario(tiposUsuario.get(getIdTipoU(this.tipoUsuario.getDescripcion())));

            if (this.enAgregar) {
                this.usuarioService.crear(this.usuario);
                FacesUtil.addMessageInfo("Se agrego el Usuario: " + this.usuario.getNombre());
            } else {
                this.usuarioService.modificar(usuario);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Usuario con c\u00f3digo: " + this.usuario.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.usuarios = this.usuarioService.obtenerTodos();
    }
}
