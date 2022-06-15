package ua.edu.op.webapplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Настройка аутентификации
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("adminpass")
                .roles("ADMIN");
    }


    //Настройка авторизации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/news/control").hasRole("ADMIN")
                .antMatchers("/news/add_news").hasRole("ADMIN")
                .antMatchers("/news/control/add_news/{id}").hasRole("ADMIN")
                .antMatchers("/news/control/edit_news").hasRole("ADMIN")
                .antMatchers("/news/control/delete_news").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/fantas").permitAll()
                .antMatchers("/history").permitAll()
                .antMatchers("/filmography").permitAll()
                .and().formLogin();
    }
}