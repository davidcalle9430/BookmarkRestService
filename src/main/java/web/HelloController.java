package web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Bookmark;
import repositories.BookmarkRepository;

@Controller
public class HelloController {
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	@RequestMapping("/login")
	public String greting(){
		return "login";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN3') or hasRole('WOASD') ")
	@RequestMapping("/greeting/")
	public String greting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		model.addAttribute("name", name);
		List<Bookmark> allBookmarks = bookmarkRepository.findAll();
		model.addAttribute("bookmarks", allBookmarks ); 
		return "greeting";
	}
}
