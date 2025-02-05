package com.hospital.registration.entity;

import com.hospital.common.entity.BaseEntity;
import jakarta.persistence.*;
//import lombok.Data;

//@Data
@Entity
@Table(name ="patients",schema = "railway")
public class Registration extends BaseEntity {
	@Id
    private Long id;
    private String mpiId;
    private String mrno;
    private Long hospitalId;
//    private Date registrationDate;
//    private Date lastVisitDate;
    private String status;
    private Long locationId;
        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMpiId() {
		return mpiId;
	}
	public void setMpiId(String mpiId) {
		this.mpiId = mpiId;
	}
	public String getMrno() {
		return mrno;
	}
	public void setMrno(String mrno) {
		this.mrno = mrno;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
//	public Date getRegistrationDate() {
//		return registrationDate;
//	}
//	public void setRegistrationDate(Date registrationDate) {
//		this.registrationDate = registrationDate;
//	}
//	public Date getLastVisitDate() {
//		return lastVisitDate;
//	}
//	public void setLastVisitDate(Date lastVisitDate) {
//		this.lastVisitDate = lastVisitDate;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
    

}