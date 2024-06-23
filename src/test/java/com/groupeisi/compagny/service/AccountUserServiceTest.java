 package com.groupeisi.compagny.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.groupeisi.compagny.dao.AccountUserDao;
import com.groupeisi.compagny.dto.AccountUserDto;
import com.groupeisi.compagny.entities.AccountUserEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
 public class AccountUserServiceTest {

	private AccountUserDao accountUserDao;
	@InjectMocks
	private AccountUserService accountUserService;
	
	@BeforeEach
	void init() {
		accountUserDao= mock(AccountUserDao.class);
		accountUserService.setAccountUserDao(accountUserDao);
		
	}
	@Test
	void loginSuccess() {
		AccountUserEntity accountUserEntity = new AccountUserEntity(1L, "tall@gmail.com", "passer", true);
		when(accountUserDao.login(anyString(), anyString()))
		.thenReturn(accountUserEntity);
		
		Optional<AccountUserDto> accountUserDto =accountUserService.login("tall@gmail.com", "passer");
		Assertions.assertTrue(accountUserDto.isPresent());
	}
	
	@Test
	void loginFaild() {
		Optional<AccountUserDto> accountUserDto =accountUserService.login("", "passer");
		Assertions.assertTrue(accountUserDto.isEmpty());
		
		accountUserDto =accountUserService.login("tall@gmail.com", "");
		Assertions.assertTrue(accountUserDto.isEmpty());
		
		when(accountUserDao.login(anyString(), anyString()))
		.thenReturn(null);
		
		accountUserDto =accountUserService.login("tall@gmail.com", "passer");
		Assertions.assertTrue(accountUserDto.isEmpty());
	}
}
