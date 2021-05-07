import business.abstracts.UserService;
import microServices.UserGoogleRegisterService;
import business.concretes.UserManager;
import business.concretes.AuthManager;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1,"Forza","Neftci","forzaneftci@gmail.com","789111");
        User user2 = new User(2,"Maqa","mmed","mmcontax@gmail.com","123456");
        UserDao userDao = new HibernateUserDao();
        UserService userService = new UserManager(userDao);
        AuthManager normalRegister = new AuthManager(new UserManager(userDao));

        normalRegister.register(user);

        normalRegister.verify(user);

        userService.login("forzaneftci@gmail.com","789111");

        AuthManager googleRegister = new AuthManager(new UserManager(userDao));

        googleRegister.register(user2);

        googleRegister.verify(user2);

        userService.login("mmcontax@gmail.com","123456");

	}

}