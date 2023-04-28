package com.project.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.addressapp.Entity.Address;
import com.project.addressapp.addressresponse.AddressResponse;
import com.project.addressapp.repo.AddressRepo;

@Service
public class AddressService {
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse= modelMapper.map(address, AddressResponse.class);
		return addressResponse;
	}
	
}
