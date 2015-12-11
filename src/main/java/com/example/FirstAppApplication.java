package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import entities.Account;
import entities.Booking;
import entities.Bookmark;
import repositories.AccountRepository;
import repositories.BookingRepository;
import repositories.BookmarkRepository;

@SpringBootApplication
@EntityScan(basePackages = {"entities","restcontrollers","web"})
@EnableJpaRepositories(basePackages={"repositories"})
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"com.example","restcontrollers","web"})
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class FirstAppApplication {
	@Autowired
	BookingRepository bookingRepository;
    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
        
    }
}

@Configuration
class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
        "classpath:/META-INF/resources/", "classpath:/resources/",
        "classpath:/static/", "classpath:/public/" };

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
}
}
@Component
class BookingCommandLineRunner implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		Booking booking = new Booking("Harry Potter");
		this.bookingRepository.save(booking);
		Booking second = new Booking("Hunger Games");
		this.bookingRepository.save(second);
		
		
		Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong,davidcalle9430,armandochindoy".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,"password"));
							bookmarkRepository.save( new Bookmark(account,"http://bookmark.com/1/" + a, "Great Movie" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/2/" + a, "Learn SpringBoot" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/3/" + a, "The Hunger Games" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/4/" + a, "Xenoblade Chronicles X walkthrough" ) );
						}
						);
		Collection<Account> accounts = accountRepository.findAll();
		for (Account account : accounts) {
			System.out.println(account.toString());
			Collection<Bookmark> bookmarks = bookmarkRepository.findByAccountUsername(account.getUsername());
			for (Bookmark bookmark : bookmarks) {
				System.out.println("    "+ bookmark.toString());
			}
		}
		
		
	}
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	BookmarkRepository bookmarkRepository;
	
}
@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	  public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	  }
	
	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<Account> account = accountRepository.findByUsername(username);
				if(account.isPresent()){
					List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_ADMIND");
					return new User(username, account.get().getPassword(), true, true, true, true, roles );
				}else{
					throw new UsernameNotFoundException("Username not found");
				}
			}
		};
	}
}
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .authorizeRequests()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/login")
          .permitAll().and()
      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");;
  }
  
}


@EnableWebMvc
@ComponentScan("org.springframework.security.samples.mvc")
class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}