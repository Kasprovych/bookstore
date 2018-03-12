package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.UserShipping;
import com.bookstore.repository.UserShippingRepository;
import com.bookstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository repository;

	@Override
	public UserShipping findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void removeById(Long id) {
		repository.delete(id);
	}

}
