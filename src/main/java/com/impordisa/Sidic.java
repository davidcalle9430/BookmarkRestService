package com.impordisa;


import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import repositories.AccountRepository;
import repositories.EmpresaRepository;
import repositories.RoleRepository;
import repositories.RolesRepository;
import repositories.RolesYMenusRepository;
import repositories.UsuarioRepository;
import sidic.entities.Rolessss;
import sidic.entities.Rolesymenus;
import sidic.entities.Usuarios;
/**
* Clase encargade de arrancar la aplicación haciendo un escan de los componentes que necesita
* Encargadad e cargar la configuración de la aplicación
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
@SpringBootApplication
@EntityScan(basePackages = {"entities","restcontrollers","web","sidic.entities"})
@EnableJpaRepositories(basePackages={"repositories"})
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"com.impordisa","restcontrollers","web"})
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Sidic {
    public static void main(String[] args) {
        SpringApplication.run(Sidic.class, args);
    }
}

/**
* Manejador de recursos estáticos
* Clase encargada de configurar cómo se manejan los archivos estáticos
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/

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

/**
* Clase encargada de la configuración de spring MVC
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
@ComponentScan("org.springframework.security.samples.mvc")
@Configuration
@EnableWebMvc
class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
@Component
class BookingCommandLineRunner implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		System.gc();
	}
	
	
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AccountRepository accountRepository;
	
}

/**
* Web Security Configuration
* Clase encargada de configurar la seguridad web de la aplicación
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolesYMenusRepository rolesYMenusRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	 }
	
	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Usuarios usuario =  null;
				try{
				 usuario = usuarioRepository.findOneByUsuariosPK_Usuario(username).get();
				}catch(Exception e){
					throw new UsernameNotFoundException("El usuario " + username + " No existe");
				}
				if(usuario != null){
					List<Rolesymenus> rolesUsuario = rolesYMenusRepository.findAllByUsuario(username);
					System.out.println(rolesUsuario);
					Set<String> roles = new HashSet<>();
					rolesUsuario.forEach( rol -> {
						Rolessss rolActual = rolesRepository.findOneByRolessssPK_codigo(rol.getRolesymenusPK().getRol());
						roles.add(rolActual.getNombre());
					});
					String[] arregloDeRoles = new String[roles.size()];
					List<GrantedAuthority> rolesSeguridad = AuthorityUtils.createAuthorityList(roles.toArray(arregloDeRoles));
					return new User(username, usuario.getPassword() , true, true, true, true, rolesSeguridad );
				}else{
					throw new UsernameNotFoundException("Nombre de Usuario no Encontrado");
				}
			}
		};
	}
}

/**
* Configración adicional de seguridad
* Clase encargada de quitarle la seguridad a los archivos estáticos
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {	
  @Override
  public void configure(WebSecurity web) throws Exception {
	 web.ignoring().antMatchers("/static/css/**");
	 web.ignoring().antMatchers("/static/js/**");
	 web.ignoring().antMatchers("/static/foundation-6/**");
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .authorizeRequests()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/login")
          .permitAll().and()
      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
  }
  
}

/* Filtro encargado de la seguridad extra de la aplicación */
@Configuration
class RequestFilter extends OncePerRequestFilter {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolesYMenusRepository rolesYMenusRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    	if (sci != null) {
            UserDetails cud = (UserDetails) sci.getAuthentication().getPrincipal();
            Usuarios elected = usuarioRepository.findOneByUsuariosPK_Usuario(cud.getUsername()).get();
            System.out.println("Sesión de " + elected.getUsuariosPK().getUsuario() + " petición a " + request.getRequestURI());
            List<Rolesymenus> rolesXMenus = rolesYMenusRepository.findAllByUsuario(elected.getUsuariosPK().getUsuario());
            System.out.println("Opciones posibles:");
            for (Rolesymenus rolymenu : rolesXMenus) {
				System.out.println("  " + rolymenu.getMenus().getMenusPK().getMenu());
			}
    	}
    	filterChain.doFilter(request, response);
	}

}


