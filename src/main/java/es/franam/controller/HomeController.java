package es.franam.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.franam.domain.Book;
import es.franam.domain.Editorial;
import es.franam.domain.Perfil;
import es.franam.domain.Usuario;
import es.franam.service.IBookService;
import es.franam.service.IEditorialService;
import es.franam.service.IUsuariosService;

@Controller
public class HomeController {

	@Autowired
	private IEditorialService editorialService;

	@Autowired
	private IBookService bookService;

	@Autowired
	private IUsuariosService serviceUsuarios;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String showHome(Model model) {
//		List<Book> books = bookService.buscarTodos();
//		model.addAttribute("books", books);
		// model.addAttribute("editoriales", editorialService.buscarTodas());

		return "home";
	}

	@GetMapping("/index")
	public String mostrarIndex(Authentication authentication, HttpSession session) {

		// Como el usuario ya ingreso, ya podemos agregar a la session el objeto
		// usuario.
		String username = authentication.getName();

		for (GrantedAuthority rol : authentication.getAuthorities()) {
			System.out.println("ROL: " + rol.getAuthority());
		}

		if (session.getAttribute("usuario") == null) {
			Usuario usuario = serviceUsuarios.buscarPorUsername(username);
			// System.out.println("Usuario: " + usuario);
			session.setAttribute("usuario", usuario);
		}

		return "redirect:/";
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		Book bookSearch = new Book();
		model.addAttribute("books", bookService.buscarStock());
		model.addAttribute("editoriales", editorialService.buscarTodas());
		model.addAttribute("search", bookSearch);
	}

	@GetMapping("/tabla")
	public String showTable(Model model) {

		List<Book> books = bookService.buscarTodos();
		model.addAttribute("books", books);
		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Book book = new Book();

		return "detalle";
	}

	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}

	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		// Recuperamos el password en texto plano
		String pwdPlano = usuario.getPassword();
		// Encriptamos el pwd BCryptPasswordEncoder
		String pwdEncriptado = passwordEncoder.encode(pwdPlano);
		// Hacemos un set al atributo password (ya viene encriptado)
		usuario.setPassword(pwdEncriptado);
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor

		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);

		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		serviceUsuarios.guardar(usuario);

		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");

		return "redirect:/usuarios/index";
	}

	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Book book, Model model) {
		System.out.println(book);

//		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
//			      .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase())
//			      .withIgnorePaths("destacado", "editorial.address", "editorial.name", "editorial.version","price","imagen" );
		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matching().withIgnorePaths("destacado",
				"editorial.address", "editorial.name", "editorial.version", "price", "imagen")
				.withMatcher("title", GenericPropertyMatchers.contains());
		Example<Book> example = Example.of(book, ignoringExampleMatcher);
		List<Book> lista = bookService.buscarByExample(example);

		model.addAttribute("books", lista);
		return "home";
	}

	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + " Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}

	// settea los string vacios a null
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
