package academy.atl.customers.Controllers;

import academy.atl.customers.Entity.User;
import academy.atl.customers.Services.AuthService;
import academy.atl.customers.Util.JwtUtil;
import academy.atl.customers.dto.RequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private  AuthService service;

    @PostMapping("/auth/login")
    public String login(@RequestBody RequestLogin request){
        String email = request.getEmail();
        String password = request.getPassword();
        User user = service.login(email,password);
        String token = JwtUtil.generateToken(user);
        return token;
    }
}
