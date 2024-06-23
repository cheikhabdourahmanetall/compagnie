package com.groupeisi.compagny.dao;






import java.util.List;

import com.groupeisi.compagny.entities.AccountUserEntity;


public class AccountUserDao implements IAccountUserDao {

	@Override
	public AccountUserEntity login(String email, String password) {
		return new AccountUserEntity(1L, "tall@gmail.com", "passer", true);
	} 

	@Override
	public List<AccountUserEntity> findAll() {
		
		return List.of( 
				new AccountUserEntity(1L, "tall@gmail.com", "passer", true),
				new AccountUserEntity(1L, "ousmane@gmail.com", "passer", false),
				new AccountUserEntity(1L, "doudou@gmail.com", "passer", true),
				new AccountUserEntity(1L, "fallou@gmail.com", "passer", false)
				
				);
				
				
	}


	}


