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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "EMPLOYEE_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeRequest.findAll", query = "SELECT e FROM EmployeeRequest e")
    , @NamedQuery(name = "EmployeeRequest.findById", query = "SELECT e FROM EmployeeRequest e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeRequest.findByRequest", query = "SELECT e FROM EmployeeRequest e WHERE e.request = :request")
    , @NamedQuery(name = "EmployeeRequest.findByEmployee", query = "SELECT e FROM EmployeeRequest e WHERE e.employee = :employee")})
public class EmployeeRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "REQUEST")
    private Integer request;
    @Column(name = "EMPLOYEE")
    private String employee;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
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
        if (!(object instanceof EmployeeRequest)) {
            return false;
        }
        EmployeeRequest other = (EmployeeRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EmployeeRequest[ id=" + id + " ]";
    }
    
}
