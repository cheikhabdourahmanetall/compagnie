package com.groupeisi.compagny.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.compagny.dao.AccountUserDao;
import com.groupeisi.compagny.dao.IAccountUserDao;
import com.groupeisi.compagny.dto.AccountUserDto;
import com.groupeisi.compagny.entities.AccountUserEntity;
import com.groupeisi.compagny.mapper.AccountUserMapper;

public class AccountUserService implements IAccountUserService{
	private IAccountUserDao accountUserDao= new AccountUserDao();
	
	/**
	 * Cette méthode permet de verifier les identifiants des utilisateurs à partir de son mail et de son mot de passe
	 * @email : représente l'email de l'utilisateur
	 * @password : représente le mot de passe de l'utilisateur
	 * la fonction retourne un Optional de AccountUserDto qui peut etre vide ou pas
	 */
	@Override
	public Optional<AccountUserDto> login(String email, String password) {
		
		return testLogin(email, password);
	}


	private Optional<AccountUserDto> testLogin(String email, String password) {
		if(email.isBlank() || password.isBlank()) {
		return Optional.empty();
		}
		else {
			AccountUserEntity accounUserEntity = accountUserDao.login(email, password);
			
			if(accounUserEntity !=null) {
				
				AccountUserDto accountUserDto = AccountUserMapper.toAccountUserDto(accounUserEntity);
				return Optional.of(accountUserDto);
			}
			return Optional.empty();
		}
	}
	

	@Override
	public Optional<List<AccountUserDto>> findAll() {
		
		return Optional.empty();
	}


	public void setAccountUserDao(IAccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}

	
}
