/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "BATCH_CLASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchClass.findAll", query = "SELECT b FROM BatchClass b")
    , @NamedQuery(name = "BatchClass.findById", query = "SELECT b FROM BatchClass b WHERE b.id = :id")})
public class BatchClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @OneToMany(mappedBy = "batchClass", fetch = FetchType.LAZY)
    private List<BatchClassMember> batchClassMemberList;
    @JoinColumn(name = "BATCH", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Batch batch;
    @JoinColumn(name = "STUDY_CLASS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StudyClass studyClass;

    public BatchClass() {
    }

    public BatchClass(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<BatchClassMember> getBatchClassMemberList() {
        return batchClassMemberList;
    }

    public void setBatchClassMemberList(List<BatchClassMember> batchClassMemberList) {
        this.batchClassMemberList = batchClassMemberList;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public StudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClass studyClass) {
        this.studyClass = studyClass;
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
        if (!(object instanceof BatchClass)) {
            return false;
        }
        BatchClass other = (BatchClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.BatchClass[ id=" + id + " ]";
    }
    
}
