package com.clsa.web.services.interfaces;

import com.clsa.web.domain.Account;
import com.clsa.web.domain.TransactionInfo;

public interface IService {

	TransactionInfo withdraw(String string, int i);

	Account search(String username);


}
