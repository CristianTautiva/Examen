package com.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Usuario;
import com.web.repository.IUserRepository;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	IUserRepository repo;
	@Override
	public Iterable<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
