package com.dambroski.demo.account;

import java.util.List;

public interface AccountService {

	List<Account> getAll();

	Account post(Account account, Long userId);

	Account patchName(String newName, Long accountId);

	void delete(Long accountId);

}
