/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "INTERVIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i")
    , @NamedQuery(name = "Interview.findById", query = "SELECT i FROM Interview i WHERE i.id = :id")
    , @NamedQuery(name = "Interview.findByInterviewer", query = "SELECT i FROM Interview i WHERE i.interviewer = :interviewer")
    , @NamedQuery(name = "Interview.findByInterviewDate", query = "SELECT i FROM Interview i WHERE i.interviewDate = :interviewDate")
    , @NamedQuery(name = "Interview.findByTime", query = "SELECT i FROM Interview i WHERE i.time = :time")})
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INTERVIEWER")
    private String interviewer;
    @Column(name = "INTERVIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interviewDate;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY)
    private List<EmployeeInterview> employeeInterviewList;
    @JoinColumn(name = "USER_SITE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserSite userSite;

    public Interview() {
    }

    public Interview(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @XmlTransient
    public List<EmployeeInterview> getEmployeeInterviewList() {
        return employeeInterviewList;
    }

    public void setEmployeeInterviewList(List<EmployeeInterview> employeeInterviewList) {
        this.employeeInterviewList = employeeInterviewList;
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
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Interview[ id=" + id + " ]";
    }
    
}
