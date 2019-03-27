/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author joshep
 */
@Entity
@Table(name = "cadastroVoo", catalog = "dbUnit", schema = "")
@NamedQueries({
    @NamedQuery(name = "CadastroVoo.findAll", query = "SELECT c FROM CadastroVoo c")
    , @NamedQuery(name = "CadastroVoo.findByIdcadastroVoo", query = "SELECT c FROM CadastroVoo c WHERE c.idcadastroVoo = :idcadastroVoo")
    , @NamedQuery(name = "CadastroVoo.findByNome", query = "SELECT c FROM CadastroVoo c WHERE c.nome = :nome")
    , @NamedQuery(name = "CadastroVoo.findByDestino", query = "SELECT c FROM CadastroVoo c WHERE c.destino = :destino")
    , @NamedQuery(name = "CadastroVoo.findByOrigem", query = "SELECT c FROM CadastroVoo c WHERE c.origem = :origem")
    , @NamedQuery(name = "CadastroVoo.findByEscalas", query = "SELECT c FROM CadastroVoo c WHERE c.escalas = :escalas")
    , @NamedQuery(name = "CadastroVoo.findByMaxPassageiro", query = "SELECT c FROM CadastroVoo c WHERE c.maxPassageiro = :maxPassageiro")})
public class CadastroVoo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcadastroVoo")
    private Integer idcadastroVoo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "destino")
    private String destino;
    @Column(name = "origem")
    private String origem;
    @Column(name = "escalas")
    private String escalas;
    @Column(name = "maxPassageiro")
    private Integer maxPassageiro;

    public CadastroVoo() {
    }

    public CadastroVoo(Integer idcadastroVoo) {
        this.idcadastroVoo = idcadastroVoo;
    }

    public Integer getIdcadastroVoo() {
        return idcadastroVoo;
    }

    public void setIdcadastroVoo(Integer idcadastroVoo) {
        Integer oldIdcadastroVoo = this.idcadastroVoo;
        this.idcadastroVoo = idcadastroVoo;
        changeSupport.firePropertyChange("idcadastroVoo", oldIdcadastroVoo, idcadastroVoo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        String oldOrigem = this.origem;
        this.origem = origem;
        changeSupport.firePropertyChange("origem", oldOrigem, origem);
    }

    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        String oldEscalas = this.escalas;
        this.escalas = escalas;
        changeSupport.firePropertyChange("escalas", oldEscalas, escalas);
    }

    public Integer getMaxPassageiro() {
        return maxPassageiro;
    }

    public void setMaxPassageiro(Integer maxPassageiro) {
        Integer oldMaxPassageiro = this.maxPassageiro;
        this.maxPassageiro = maxPassageiro;
        changeSupport.firePropertyChange("maxPassageiro", oldMaxPassageiro, maxPassageiro);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcadastroVoo != null ? idcadastroVoo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadastroVoo)) {
            return false;
        }
        CadastroVoo other = (CadastroVoo) object;
        if ((this.idcadastroVoo == null && other.idcadastroVoo != null) || (this.idcadastroVoo != null && !this.idcadastroVoo.equals(other.idcadastroVoo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
