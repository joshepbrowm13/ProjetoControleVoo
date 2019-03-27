/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author joshep
 */
@Entity
@Table(name = "efetuaReversa", catalog = "dbUnit", schema = "")
@NamedQueries({
    @NamedQuery(name = "EfetuaReversa.findAll", query = "SELECT e FROM EfetuaReversa e")
    , @NamedQuery(name = "EfetuaReversa.findByIdefetuaReversa", query = "SELECT e FROM EfetuaReversa e WHERE e.idefetuaReversa = :idefetuaReversa")
    , @NamedQuery(name = "EfetuaReversa.findByData", query = "SELECT e FROM EfetuaReversa e WHERE e.data = :data")
    , @NamedQuery(name = "EfetuaReversa.findByHora", query = "SELECT e FROM EfetuaReversa e WHERE e.hora = :hora")
    , @NamedQuery(name = "EfetuaReversa.findByClienteIdcliente", query = "SELECT e FROM EfetuaReversa e WHERE e.clienteIdcliente = :clienteIdcliente")
    , @NamedQuery(name = "EfetuaReversa.findByCadastroVooidcadastroVoo", query = "SELECT e FROM EfetuaReversa e WHERE e.cadastroVooidcadastroVoo = :cadastroVooidcadastroVoo")})
public class EfetuaReversa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idefetuaReversa")
    private Integer idefetuaReversa;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
   
    //@Basic(optional = false) alteração para chave segundaria muito para muitos
    @ManyToOne
    @JoinColumn(name = "cliente_idcliente")
    private Cliente clienteIdcliente; // colocar a classe cliente
   
    //@Basic(optional = false) alteração para chave segundaria muito para muitos
    @ManyToOne
    @JoinColumn(name = "cadastroVoo_idcadastroVoo")
    private CadastroVoo cadastroVooidcadastroVoo; //colocar class cadastro do voo

    public EfetuaReversa() {
    }

    public EfetuaReversa(Integer idefetuaReversa) {
        this.idefetuaReversa = idefetuaReversa;
    }
        //troca o int pelo classe cliente e casdatro 
    public EfetuaReversa(Integer idefetuaReversa, Cliente clienteIdcliente, CadastroVoo cadastroVooidcadastroVoo) {
        this.idefetuaReversa = idefetuaReversa;
        this.clienteIdcliente = clienteIdcliente;
        this.cadastroVooidcadastroVoo = cadastroVooidcadastroVoo;
    }

    public Integer getIdefetuaReversa() {
        return idefetuaReversa;
    }

    public void setIdefetuaReversa(Integer idefetuaReversa) {
        Integer oldIdefetuaReversa = this.idefetuaReversa;
        this.idefetuaReversa = idefetuaReversa;
        changeSupport.firePropertyChange("idefetuaReversa", oldIdefetuaReversa, idefetuaReversa);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        Cliente oldClienteIdcliente = this.clienteIdcliente;
        this.clienteIdcliente = clienteIdcliente;
        changeSupport.firePropertyChange("clienteIdcliente", oldClienteIdcliente, clienteIdcliente);
    }

    public CadastroVoo getCadastroVooidcadastroVoo() {
        return cadastroVooidcadastroVoo;
    }

    public void setCadastroVooidcadastroVoo(CadastroVoo cadastroVooidcadastroVoo) {
        CadastroVoo oldCadastroVooidcadastroVoo = this.cadastroVooidcadastroVoo;
        this.cadastroVooidcadastroVoo = cadastroVooidcadastroVoo;
        changeSupport.firePropertyChange("cadastroVooidcadastroVoo", oldCadastroVooidcadastroVoo, cadastroVooidcadastroVoo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idefetuaReversa != null ? idefetuaReversa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EfetuaReversa)) {
            return false;
        }
        EfetuaReversa other = (EfetuaReversa) object;
        if ((this.idefetuaReversa == null && other.idefetuaReversa != null) || (this.idefetuaReversa != null && !this.idefetuaReversa.equals(other.idefetuaReversa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.EfetuaReversa[ idefetuaReversa=" + idefetuaReversa + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
