package com.groupeisi.compagny.dao;

import java.util.List;

import com.groupeisi.compagny.entities.AccountUserEntity;

public interface IAccountUserDao {

	
		AccountUserEntity login(String email, String password);
		List<AccountUserEntity> findAll();
		
}
