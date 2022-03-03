package com.training.pms.dao;

import com.training.pms.model.Login;

public interface LoginDAO {
		public boolean register(Login login);
		public boolean validate(String username,String password);

}