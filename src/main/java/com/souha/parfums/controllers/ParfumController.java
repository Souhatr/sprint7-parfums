package com.souha.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.service.ParfumService;

@Controller
public class ParfumController {

	@Autowired
	ParfumService parfumService;

	@RequestMapping("/ListeParfums")
	public String listeParfums(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Parfum> parfs = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", parfs);
		modelMap.addAttribute("pages", new int[parfs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeParfums";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createParfum";
	}

	@RequestMapping("/saveParfum")
	public String saveParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		parfum.setDateCreation(dateCreation);

		Parfum saveParfum = parfumService.saveParfum(parfum);
		String msg = "parfum enregistré avec Id " + saveParfum.getIdParfum();
		modelMap.addAttribute("msg", msg);
		return "createParfum";
	}

	@RequestMapping("/supprimerParfum")
	public String supprimerParfum(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		parfumService.deleteParfumById(id);
		Page<Parfum> parfs = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", parfs);
		modelMap.addAttribute("pages", new int[parfs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeParfums";
	}

	@RequestMapping("/modifierParfum")
	public String editerParfum(@RequestParam("id") Long id, ModelMap modelMap) {
		Parfum p = parfumService.getParfum(id);
		modelMap.addAttribute("parfum", p);
		return "editerParfum";
	}

	@RequestMapping("/updateParfum")
	public String updateParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		parfum.setDateCreation(dateCreation);

		parfumService.updateParfum(parfum);
		List<Parfum> parfs = parfumService.getAllParfums();
		modelMap.addAttribute("produits", parfs);
		return "listeParfums";
	}
}
