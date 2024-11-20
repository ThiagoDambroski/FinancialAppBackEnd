package com.dambroski.demo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.account.Account;
import com.dambroski.demo.erros.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public List<User> getAll() {
		
		return repo.findAll();
	}

	@Override
	public User post(User user) {
		
		List<Account> emptyAccountList = new ArrayList<>();
		user.setAccounts(emptyAccountList);
		
		return repo.save(user);
	}

	@Override
	public User put(User user, Long userId) {
		User oldUser = repo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found"));
		
		if(Objects.nonNull(user.getPassword()) && user.getPassword().length() > 0 ) {
			oldUser.setPassword(user.getPassword());
		}
		if(Objects.nonNull(user.getUserName()) && user.getUserName().length() > 0) {
			oldUser.setPassword(user.getPassword());
		}
		
		return repo.save(oldUser);
	}

}
