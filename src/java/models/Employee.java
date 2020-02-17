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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByPhoneNumber", query = "SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employee.findByUniversity", query = "SELECT e FROM Employee e WHERE e.university = :university")
    , @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")
    , @NamedQuery(name = "Employee.findByAvailability", query = "SELECT e FROM Employee e WHERE e.availability = :availability")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "UNIVERSITY")
    private String university;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "AVAILABILITY")
    private String availability;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<BatchClassMember> batchClassMemberList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeInterview> employeeInterviewList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<SkillSet> skillSetList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Account account;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeRole> employeeRoleList;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String name, String email, String phoneNumber, String university, Date hireDate, String status, String availability) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.university = university;
        this.hireDate = hireDate;
        this.status = status;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @XmlTransient
    public List<BatchClassMember> getBatchClassMemberList() {
        return batchClassMemberList;
    }

    public void setBatchClassMemberList(List<BatchClassMember> batchClassMemberList) {
        this.batchClassMemberList = batchClassMemberList;
    }

    @XmlTransient
    public List<EmployeeInterview> getEmployeeInterviewList() {
        return employeeInterviewList;
    }

    public void setEmployeeInterviewList(List<EmployeeInterview> employeeInterviewList) {
        this.employeeInterviewList = employeeInterviewList;
    }

    @XmlTransient
    public List<SkillSet> getSkillSetList() {
        return skillSetList;
    }

    public void setSkillSetList(List<SkillSet> skillSetList) {
        this.skillSetList = skillSetList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @XmlTransient
    public List<EmployeeRole> getEmployeeRoleList() {
        return employeeRoleList;
    }

    public void setEmployeeRoleList(List<EmployeeRole> employeeRoleList) {
        this.employeeRoleList = employeeRoleList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employee[ id=" + id + " ]";
    }
    
}
