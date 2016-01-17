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
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
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
import converters.ClassFinder;
import converters.UsuarioPKConverter;
import repositories.MenusRepository;
import repositories.RolesRepository;
import repositories.RolesYMenusRepository;
import repositories.UsuarioRepository;
import sidic.entities.Menus;
import sidic.entities.Rolessss;
import sidic.entities.Rolesymenus;
import sidic.entities.Usuarios;
/**
 * Clase encargade de arrancar la aplicación haciendo un escaneo de los
 * componentes que necesita para la configuración
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
 */
@SpringBootApplication
@EntityScan(basePackages = { "entities", "sidic.entities" })
@EnableJpaRepositories(basePackages = { "repositories" })
@ComponentScan(basePackages = { "com.impordisa", "restcontrollers", "web" , "projections"})
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableAutoConfiguration
public class Sidic {
	public static void main(String[] args) {
		SpringApplication.run(Sidic.class, args);
	}
}

/**
 * Manejador de recursos estáticos Clase encargada de configurar cómo se manejan
 * los archivos estáticos
 *
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
 */

@Configuration
class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS).setCachePeriod(0);
	}
}

/**
 * Clase encargada de la configuración de spring MVC
 *
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
 */
@EnableWebMvc
@ComponentScan("org.springframework.security.samples.mvc")
@Configuration
@Component
class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}

@Component
class BookingCommandLineRunner implements CommandLineRunner {
	@Override
	public void run(String... arg0) throws Exception {
		System.gc();
	}
}

/**
 * Web Security Configuration Clase encargada de configurar la seguridad web de
 * la aplicación
 *
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
 */

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
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
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Usuarios usuario = null;
				try {
					usuario = usuarioRepository.findOneByUsuario(username);
				} catch (Exception e) {
					throw new UsernameNotFoundException("El usuario " + username + " No existe");
				}
				if (usuario != null) {
					List<Rolesymenus> rolesUsuario = rolesYMenusRepository.findAllByUsuario(username);
					Set<String> roles = new HashSet<>();
					rolesUsuario.forEach(rol -> {
						Rolessss rolActual = rolesRepository
								.findOneByRolessssPK_codigo(rol.getRolesymenusPK().getRol());
						roles.add(rolActual.getNombre());
					});
					String[] arregloDeRoles = new String[roles.size()];
					List<GrantedAuthority> rolesSeguridad = AuthorityUtils
							.createAuthorityList(roles.toArray(arregloDeRoles));
					return new User(username, usuario.getPassword(), true, true, true, true, rolesSeguridad);
				} else {
					throw new UsernameNotFoundException("Nombre de Usuario no Encontrado");
				}
			}
		};
	}
}

/**
 * Configración adicional de seguridad Clase encargada de quitarle la seguridad
 * a los archivos estáticos
 *
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
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
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		http.csrf().disable();
	}

}

@Configuration
class CustomRestMvcConfiguration {

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
				List<Class<?>> classes = ClassFinder.find("sidic.entities");
				for (Class<?> class1 : classes) {
					config.exposeIdsFor(class1);
				}
			}

			@Override
			public void configureConversionService(ConfigurableConversionService conversionService) {
				super.configureConversionService(conversionService);
				UsuarioPKConverter usuarioPKConverter = new UsuarioPKConverter();
				conversionService.addConverter(usuarioPKConverter);
			}

		};
	}
}

/**
 *  Filtro encargado de la seguridad extra de la aplicación
 *   
 *   */
@Configuration
class RequestFilter extends OncePerRequestFilter {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolesYMenusRepository rolesYMenusRepository;
	@Autowired
	private MenusRepository menusRepository;

	public boolean validarPermiso(String URI, Usuarios usuario) {
		String nombreMenu = URI.split("/")[1]; // se parte la url en trozos y se obtine el primer valor
		Menus menu = menusRepository.findOneByMenusPK_menu(nombreMenu);
		if(menu == null){
			return true;
		}
		String reggex = "(.)*" + menu.getMenusPK().getMenu() + "(.)*";
		if (URI.matches(reggex)) { // a final de cuentas, un rol viene siendo lo // mismo que un nivel
			List<Rolesymenus> rolXmenu = rolesYMenusRepository.findAllByRolesymenusPK_Menu(menu.getMenusPK().getMenu());
			for (Rolesymenus rolymenu : rolXmenu) {
				Long comparador = new Long(usuario.getNivel());
				if(rolymenu.getRolesymenusPK().getRol().equals(comparador)){
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		HttpSession session = request.getSession();
		SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String URI = request.getRequestURI();
		if(URI.equals("/") || URI.equals("/inicio/") || URI.equals("/login") || URI.equals("/jm/")){ // No se logrò congirar la ruta / por lo que se redirige a /inicio/
			if(URI.equals("/")){
				response.sendRedirect("/inicio/");
			}
			filterChain.doFilter(request, response);
			return;
		}
		String nombreMenu = URI.split("/")[1];
		boolean esApi = nombreMenu.equals("api") || nombreMenu.equals("static") || nombreMenu.equals("jm"); // se busca que no haga request a archivos estàticos ni al api
		if (!esApi) {
			if (sci != null) {
				UserDetails cud = (UserDetails) sci.getAuthentication().getPrincipal();
				Usuarios elected = usuarioRepository.findOneByUsuario(cud.getUsername());
				boolean permitido = false;		
				if (!esApi) {
					permitido = validarPermiso(URI, elected);
					if (!permitido) {
						response.sendError(500, "El rol del usuario actual no tiene los permisos suficientes" );
						return;
					}
				}	
			}
		}
		filterChain.doFilter(request, response);
	}
}