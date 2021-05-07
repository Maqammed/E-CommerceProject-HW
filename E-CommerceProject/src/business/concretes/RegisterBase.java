package business.concretes;

import business.abstracts.AuthService;
import entities.concretes.User;

public class RegisterBase implements AuthService{

	protected final UserManager userManager;
	public RegisterBase(UserManager userManager) {
		this.userManager = userManager;
	}


	
	public void register(User user) {
		if(checkRegister(user)) {
			 System.out.println(user.getFirstName()+" "+user.getLastName()+" succesfully registered to the system. The verification email has been sent to your e-mail. Please verify to login.");
			 userManager.save(user);
		}
		else {
			System.out.println("You entered wrong information.Try again");
		}
		
	}
	

	@Override
	public void verify(User user) {
		 System.out.println("Verification successfully done. You can login");
		
	}



	@Override
	public boolean checkRegister(User user) {
		return false;
	}

}