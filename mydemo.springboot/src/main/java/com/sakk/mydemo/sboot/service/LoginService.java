package com.sakk.mydemo.sboot.service;

import com.sakk.mydemo.sboot.model.UserDTO;

public interface LoginService {
      public UserDTO login(String email,String password);	
}
