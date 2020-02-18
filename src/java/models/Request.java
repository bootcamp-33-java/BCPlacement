/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByQuantity", query = "SELECT r FROM Request r WHERE r.quantity = :quantity")
    , @NamedQuery(name = "Request.findByStartDate", query = "SELECT r FROM Request r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "Request.findByEndDate", query = "SELECT r FROM Request r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "Request.findByNote", query = "SELECT r FROM Request r WHERE r.note = :note")
    , @NamedQuery(name = "Request.findByStep", query = "SELECT r FROM Request r WHERE r.step = :step")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "STEP")
    private String step;
    @JoinColumn(name = "SKILL", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;
    @JoinColumn(name = "USER_SITE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserSite userSite;

    public Request() {
    }

    public Request(Integer id) {
        this.id = id;
    }
    public Request(Integer id, String step) {
        this.id = id;
        this.step = step;
    }
    
    public Request(Integer id, Integer quantity, Date startDate, Date endDate, String note, Skill skill, UserSite userSite, String step) {
        this.id = id;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.userSite = userSite;
        this.skill = skill;
        this.step = step;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public UserSite getUserSite() {
        return userSite;
    }

    public void setUserSite(UserSite userSite) {
        this.userSite = userSite;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Request[ id=" + id + " ]";
    }
    
}
