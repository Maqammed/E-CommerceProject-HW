package business.abstracts;

import entities.concretes.User;

public interface AuthService {

	boolean checkRegister (User user);
	void register(User user);
	void verify(User user);
}