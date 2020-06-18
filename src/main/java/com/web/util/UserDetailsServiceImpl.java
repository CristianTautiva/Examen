package com.web.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.entities.*;
import com.web.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	IUserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario appUser = repo.findByUsuario(username);
		
		 List<GrantedAuthority> roles = new ArrayList<>();
		    GrantedAuthority authority = new SimpleGrantedAuthority("Administrador");
		    roles.add(authority);
	
		
		UserDetails userDet = (UserDetails) new User(appUser.getUsuario(), appUser.getPassword(), roles);
		System.out.print(userDet);
		System.out.print(userDet.getUsername());
		System.out.print(userDet.getPassword());
		System.out.print(userDet.getAuthorities());
		return userDet;
	}
}
