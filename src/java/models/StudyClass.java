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
@Table(name = "STUDY_CLASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyClass.findAll", query = "SELECT s FROM StudyClass s")
    , @NamedQuery(name = "StudyClass.findById", query = "SELECT s FROM StudyClass s WHERE s.id = :id")
    , @NamedQuery(name = "StudyClass.findByName", query = "SELECT s FROM StudyClass s WHERE s.name = :name")
    , @NamedQuery(name = "StudyClass.findByRoom", query = "SELECT s FROM StudyClass s WHERE s.room = :room")})
public class StudyClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM")
    private String room;
    @OneToMany(mappedBy = "studyClass", fetch = FetchType.LAZY)
    private List<BatchClass> batchClassList;

    public StudyClass() {
    }

    public StudyClass(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @XmlTransient
    public List<BatchClass> getBatchClassList() {
        return batchClassList;
    }

    public void setBatchClassList(List<BatchClass> batchClassList) {
        this.batchClassList = batchClassList;
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
        if (!(object instanceof StudyClass)) {
            return false;
        }
        StudyClass other = (StudyClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.StudyClass[ id=" + id + " ]";
    }
    
}
