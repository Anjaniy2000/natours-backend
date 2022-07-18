package com.natours.natoursbackend.config;
import com.natours.natoursbackend.services.UserDetailsServiceImpl;
import com.natours.natoursbackend.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private static final String WHITELIST_ENDPOINTS[] = {"/auth/**"};

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITELIST_ENDPOINTS)
                .permitAll()
                .anyRequest()
                .authenticated();

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
/*
Flow:
    loginRequest:
    email: anjaniy01salekar@gmail.com
    password: Anjaniy@12345
    Came to authenticationManager

    authenticationManager will send email to UserDeatilService.
    UserDeatilService: email(anjaniy01salekar@gmail.com)

    UserDeatilService will fetch the user based on email & will return AppUser object to
    authenticationManager.

    authenticationManager will have:
      email: anjaniy01salekar@gmail.com
      password: dealkjllkaajdkajkdaskdsalkjda
    after decoding password: Anjaniy@12345

    authenticationManager will compare passwords to validate the user credentials.
 */
