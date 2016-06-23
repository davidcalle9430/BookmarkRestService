package com.impordisa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import converters.BasesConverter;
import converters.EspeciaConverter;
import converters.NivelesPKConverter;
import converters.UsuarioPKConverter;
import repositories.MenusRepository;
import repositories.RolesRepository;
import repositories.RolesYMenusRepository;
import repositories.UsuarioRepository;
import sidic.entities.Articulo;
import sidic.entities.Cardex;
import sidic.entities.Cardexi;
import sidic.entities.Cartera;
import sidic.entities.Causales;
import sidic.entities.Causalreciboscaja;
import sidic.entities.Ciudades;
import sidic.entities.Clientes;
import sidic.entities.Correr;
import sidic.entities.Empresas;
import sidic.entities.Especia;
import sidic.entities.Genero;
import sidic.entities.Importaciones;
import sidic.entities.Lineas;
import sidic.entities.Menus;
import sidic.entities.Nfact;
import sidic.entities.NfactLog;
import sidic.entities.Niveles;
import sidic.entities.Opciones;
import sidic.entities.Plazos;
import sidic.entities.Proveedores;
import sidic.entities.RecibosCaja;
import sidic.entities.Rolessss;
import sidic.entities.Rolesymenus;
import sidic.entities.TextosFacturas;
import sidic.entities.Tipooperacion;
import sidic.entities.Tipooperacionbases;
import sidic.entities.Usuarios;
import sidic.entities.Vendedor;
import sidic.entities.VentasseguimientoOrg;
import sidic.entities.Zonas;
import projections.BasesTipoOperacion;
import projections.ClienteFactura;
import projections.ClienteRotulacion;
import projections.ClienteRotulacionCorrerciaConverter;
import projections.ClienteVendedorProjection;
import projections.EspeciaClienteConverter;
import projections.ProveedorCiudad;
import projections.RolesyMenusProjection;

/**
 * Clase encargade de arrancar la aplicación haciendo un escaneo de los
 * componentes que necesita para la configuración
 * @author David Calle
 * @version 1.0
 * @since 2015-12-14
 */
@SpringBootApplication
@EntityScan(basePackages = { "entities", "sidic.entities" } )
@EnableJpaRepositories(basePackages = { "repositories" } )
@ComponentScan(basePackages = { "com.impordisa" , "restcontrollers", "web" , "projections" , "services" } )
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableAutoConfiguration
public class Sidic {
	public static void main(String[] args) {
		SpringApplication.run(Sidic.class, args);
	}
}

/**
 *Clase encargada de configurar cómo se manejan
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
		registry.addResourceHandler("/static/**").addResourceLocations( CLASSPATH_RESOURCE_LOCATIONS ).setCachePeriod(0);
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
		registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	}
}
/**
 * clase cuyo método run se ejecuta cuando el servidor empieza a correr
 * se deja para su posterior uso
 * @author david
 *
 */
@Component
class BookingCommandLineRunner implements CommandLineRunner {
	
	@Override
	public void run(String... arg0) throws Exception {
		System.gc( );
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
	/**
	 * funcionalidad de inciio de sesión
	 * @return
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Usuarios usuario = null;
				try {
					usuario = usuarioRepository.findOneByUsuario( username );
				} catch (Exception e) {
					e.printStackTrace();
					throw new UsernameNotFoundException("El usuario " + username + " No existe");
				}
				if (usuario != null) {
					List<Rolesymenus> rolesUsuario = rolesYMenusRepository.findAllByUsuario(username);
					Set<String> roles = new HashSet<>();
					rolesUsuario.forEach(rol -> {
						Rolessss rolActual = rolesRepository
								.findOneByRolessssPK_codigo( rol.getRolesymenusPK( ).getRol( ) );
						if(rolActual  != null){
							roles.add( rolActual.getNombre( ) );
						}
						
					});
					String[] arregloDeRoles = new String[roles.size()];
					List<GrantedAuthority> rolesSeguridad = AuthorityUtils
							.createAuthorityList(roles.toArray( arregloDeRoles ) );
					return new User( username, usuario.getPassword(), true, true, true, true, rolesSeguridad );
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
/**
 * clase de configuracion del api rest
 * se encarga de exponer los ids de las clases necesarias
 * tambien de agregar los convertidores de llave primaria a string
 * esto es para representar el identificador de un objeto como un string que se pueda
 * poner en una url
 * @author david
 *
 */
@Configuration
class CustomRestMvcConfiguration {

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
				config.exposeIdsFor( Articulo.class );
				config.exposeIdsFor( Cardexi.class );
				config.exposeIdsFor( Cardex.class );
				config.exposeIdsFor( Cartera.class );
				config.exposeIdsFor( Ciudades.class );
				config.exposeIdsFor( Clientes.class );
				config.exposeIdsFor( Correr.class );
				config.exposeIdsFor( Empresas.class );
				config.exposeIdsFor( Especia.class );
				config.exposeIdsFor( Genero.class );
				config.exposeIdsFor( Importaciones.class );
				config.exposeIdsFor( Lineas.class );
				config.exposeIdsFor( Menus.class );
				config.exposeIdsFor( Nfact.class );
				config.exposeIdsFor( Niveles.class );
				config.exposeIdsFor( Opciones.class );
				config.exposeIdsFor( Plazos.class );
				config.exposeIdsFor( Rolessss.class );
				config.exposeIdsFor( Rolesymenus.class );
				config.exposeIdsFor( TextosFacturas.class );
			    config.exposeIdsFor( Usuarios.class );
			    config.exposeIdsFor( Vendedor.class );
			    config.exposeIdsFor( VentasseguimientoOrg.class );
			    config.exposeIdsFor( Zonas.class );
			    config.exposeIdsFor( NfactLog.class );
			    config.exposeIdsFor( Proveedores.class ); 
			    config.exposeIdsFor( Tipooperacion.class );
			    config.exposeIdsFor( Tipooperacionbases.class );
			    config.exposeIdsFor( Causales.class );
			    config.exposeIdsFor( Causalreciboscaja.class );
			    config.exposeIdsFor( RecibosCaja.class );
			    // registro de proyecciones
			    config.getProjectionConfiguration().addProjection( ClienteRotulacion.class );
			    config.getProjectionConfiguration().addProjection( ClienteFactura.class );
			    config.getProjectionConfiguration().addProjection( RolesyMenusProjection.class );
			    config.getProjectionConfiguration().addProjection( ProveedorCiudad.class );
			    config.getProjectionConfiguration().addProjection( BasesTipoOperacion.class );
			    config.getProjectionConfiguration().addProjection( EspeciaClienteConverter.class );
			    config.getProjectionConfiguration().addProjection( ClienteRotulacionCorrerciaConverter.class );
			    config.getProjectionConfiguration().addProjection( ClienteVendedorProjection.class );
			}

			@Override
			public void configureConversionService(ConfigurableConversionService conversionService) {
				super.configureConversionService( conversionService );
				UsuarioPKConverter usuarioPKConverter = new UsuarioPKConverter( );
				EspeciaConverter espcia = new EspeciaConverter( );
				NivelesPKConverter nivelesConverter = new NivelesPKConverter( );
				BasesConverter basesConverter = new BasesConverter( );
				conversionService.addConverter( usuarioPKConverter );
				conversionService.addConverter( espcia );
				conversionService.addConverter( nivelesConverter );
				conversionService.addConverter( basesConverter );
			}
		};
	}
}

/**
 *  Filtro encargado de la seguridad extra de la aplicación
 *  Se hace seguridad por controlador web
 *  para el api la seguridad es solo de inciio de sesión
 * */
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
	public boolean necesitaCambioPassword(SecurityContextImpl sci){
		if (sci != null) {
			UserDetails cud = ( UserDetails ) sci.getAuthentication( ).getPrincipal( );
			Usuarios elected = usuarioRepository.findOneByUsuario( cud.getUsername( ) );
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechaPassword = LocalDate.parse( DATE_FORMAT.format( elected.getFechapassword( ) ) );
			fechaPassword = fechaPassword.plusDays(new Long(elected.getMaxdias()));
			LocalDate fechaActual = LocalDate.now();
			if(fechaActual.isAfter(fechaPassword)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * método que se encarga de hacer un filtrado de los request que llegan al serviodr y decide si tiene
	 * los permisos suficientes para que la sesión actual acceda al controlador
	 * también se encarga de revisar si un usuario necesita cmabio de contrasenia
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		HttpSession session = request.getSession();
		SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String URI = request.getRequestURI();
		String nombreMenu = "";
		if( URI.split("/").length > 1 ){ // se valida que el uri no sea origen /
			nombreMenu = URI.split("/")[1];
		}
		boolean cambio = necesitaCambioPassword(sci);
		 if(cambio){
			 if(!URI.equals("/") && !URI.equals("/logout/") && !URI.equals("/mnucampass/") && !nombreMenu.equals("static") && !nombreMenu.equals("api") ){ //urls que no se ven afectadas
				 response.sendRedirect("/mnucampass/");
				 filterChain.doFilter(request, response); // se redirige a credenciales porque necesita cambiar la contrasenia
				 return;
			 }	 
		 }
		if(URI.equals("/") || URI.equals("/inicio/") || URI.equals("/login") || URI.equals("/jm/")){ // No se logrò confugirar la ruta / por lo que se redirige a /inicio/
			if(URI.equals("/")){
				response.sendRedirect("/inicio/");
			}
			filterChain.doFilter(request, response);
			return;
		}
		
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