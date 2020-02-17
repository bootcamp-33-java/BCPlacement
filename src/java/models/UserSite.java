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
@Table(name = "USER_SITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSite.findAll", query = "SELECT u FROM UserSite u")
    , @NamedQuery(name = "UserSite.findById", query = "SELECT u FROM UserSite u WHERE u.id = :id")
    , @NamedQuery(name = "UserSite.findByName", query = "SELECT u FROM UserSite u WHERE u.name = :name")
    , @NamedQuery(name = "UserSite.findByProject", query = "SELECT u FROM UserSite u WHERE u.project = :project")
    , @NamedQuery(name = "UserSite.findByDivision", query = "SELECT u FROM UserSite u WHERE u.division = :division")
    , @NamedQuery(name = "UserSite.findByTeam", query = "SELECT u FROM UserSite u WHERE u.team = :team")})
public class UserSite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "TEAM")
    private String team;
    @JoinColumn(name = "SITE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Site site;
    @OneToMany(mappedBy = "userSite", fetch = FetchType.LAZY)
    private List<Interview> interviewList;
    @OneToMany(mappedBy = "userSite", fetch = FetchType.LAZY)
    private List<Request> requestList;

    public UserSite() {
    }

    public UserSite(Integer id) {
        this.id = id;
    }

  public UserSite(Integer id, String name, String project, String division, String team, Site site) {
        this.id=id;
        this.name = name;
        this.project = project;
        this.division = division;
        this.team = team;
        this.site=site;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @XmlTransient
    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    @XmlTransient
    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
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
        if (!(object instanceof UserSite)) {
            return false;
        }
        UserSite other = (UserSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.UserSite[ id=" + id + " ]";
    }
    
}
