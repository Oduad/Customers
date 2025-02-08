package academy.atl.customers.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private CustomAccessFilter customAccessFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Aquí se configuran las reglas de la
        //API a las que pueden ingresar los usuarios
        //También un control de inicio de sesión a partir de lo anterior.
        http.csrf(AbstractHttpConfigurer::disable);
        /*http.authorizeHttpRequests(request ->{
            request.requestMatchers("/api/register","/api/auth/login").permitAll();
            //Si una request matchea con cualquiera de esas(register o login),
            //le decimos que las permita
            request.requestMatchers("/api/**").authenticated();
            //para api/cualquier cosa, necesita estar autenticado
        });*/
        http.addFilterBefore(customAccessFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
