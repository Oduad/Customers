package academy.atl.customers.Services;

import academy.atl.customers.Entity.User;

public interface AuthService {

    User login(String email, String password);

}
