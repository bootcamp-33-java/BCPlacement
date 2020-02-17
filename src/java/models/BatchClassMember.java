/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "BATCH_CLASS_MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchClassMember.findAll", query = "SELECT b FROM BatchClassMember b")
    , @NamedQuery(name = "BatchClassMember.findById", query = "SELECT b FROM BatchClassMember b WHERE b.id = :id")})
public class BatchClassMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "BATCH_CLASS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BatchClass batchClass;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public BatchClassMember() {
    }

    public BatchClassMember(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BatchClass getBatchClass() {
        return batchClass;
    }

    public void setBatchClass(BatchClass batchClass) {
        this.batchClass = batchClass;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchClassMember)) {
            return false;
        }
        BatchClassMember other = (BatchClassMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.BatchClassMember[ id=" + id + " ]";
    }
    
}
