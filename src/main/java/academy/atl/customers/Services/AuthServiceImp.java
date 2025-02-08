package academy.atl.customers.Services;

import academy.atl.customers.Entity.User;
import academy.atl.customers.Repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AuthServiceImp implements AuthService{

    public static final String SECRET_KEY = "Oduad";

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        String hashPassword = Hashing.sha256().
                hashString(password+ SECRET_KEY, StandardCharsets.UTF_8)
                .toString();
        List<User> result = userRepository.findByEmailAndPassword(email,hashPassword);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }
}
