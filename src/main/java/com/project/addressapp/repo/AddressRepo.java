package com.project.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.addressapp.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	// address based on a employee ID
	
	/*
	 * SELECT * FROM emplyeedb.address ea join emplyeedb.employee e on
	 * e.id=ea.employee_id where ea.employee_id=1 ;
	 */
	/*
	 * SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM emplyeedb.address ea join
	 * emplyeedb.employee e on e.id=ea.employee_id where ea.employee_id=1 ;
	 */
	@Query(nativeQuery = true, value="SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM emplyeedb.address ea join emplyeedb.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
