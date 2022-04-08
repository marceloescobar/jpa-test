package com.mescobar.jpatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mescobar.jpatest.entity.Address;
import com.mescobar.jpatest.entity.projection.AddressView;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<AddressView> getAddressByState(String state);
}
