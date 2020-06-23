package es.franam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.franam.domain.Book;
import es.franam.domain.Solicitud;
import es.franam.domain.Usuario;
import es.franam.service.IBookService;
import es.franam.service.ISolicitudesService;
import es.franam.service.IUsuariosService;
import es.franam.util.Utilidades;


@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {
	

	
    @Autowired
	private ISolicitudesService serviceSolicitudes;

   
    @Autowired
	private IBookService bookService;
    
    @Autowired
   	private IUsuariosService serviceUsuarios;
   
    @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Solicitud> lista = serviceSolicitudes.buscarTodas();
    	model.addAttribute("solicitudes", lista);
		return "solicitudes/listSolicitudes";
	}
    
   
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Solicitud> lista = serviceSolicitudes.buscarTodas(page);
		model.addAttribute("solicitudes", lista);
		return "solicitudes/listSolicitudes";
	}
    
	
	@GetMapping("/create/{id_book}")
	public String crear(Solicitud solicitud, @PathVariable Integer id_book, Model model) {
		
		Book book = bookService.buscarPorId(id_book);
		model.addAttribute("book", book);
		return "solicitudes/formSolicitud";
	}
	
	
	@PostMapping("/save")
	public String guardar(Solicitud solicitud, BindingResult result, Model model, HttpSession session,
			RedirectAttributes attributes, Authentication authentication) {	
		
		// Recuperamos el username que inicio sesión
		String username = authentication.getName();
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "solicitudes/formSolicitud";
		}	
		
		

		// Buscamos el objeto Usuario en BD	
		Usuario usuario = serviceUsuarios.buscarPorUsername(username);		
		
		solicitud.setUsuario(usuario); // Referenciamos la solicitud con el usuario 
		solicitud.setFecha(new Date());
		//solicitud.getBook().setId(solicitud.getBook().getId().intValue());;
		System.out.println(solicitud.getBook().getId());;
		// Guadamos el objeto solicitud en la bd
		serviceSolicitudes.guardar(solicitud);
		attributes.addFlashAttribute("msg", "Gracias por solicitar el libro!");
			
		//return "redirect:/solicitudes/index";
		return "redirect:/";		
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idSolicitud, RedirectAttributes attributes) {
		
		// Eliminamos la solicitud.
		serviceSolicitudes.eliminar(idSolicitud);
			
		attributes.addFlashAttribute("msg", "La solicitud fue eliminada!.");
		//return "redirect:/solicitudes/index";
		return "redirect:/solicitudes/indexPaginate";
	}
			
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
