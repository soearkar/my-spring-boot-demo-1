package com.sakk.mydemo.sboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakk.mydemo.sboot.dao.LoginDao;
import com.sakk.mydemo.sboot.entity.User;
import com.sakk.mydemo.sboot.model.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	
    @Override
	public UserDTO login(String email, String password) {
		User user = loginDao.findByEmail(email);
		if (user != null) {
			if (password.equals(user.getPassword()) && user.getStatus() != 0) {
				return new UserDTO(user);
			}
		}
		return null;
	}
	


}
