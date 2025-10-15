package com.souha.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souha.parfums.entities.Marque;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.service.ParfumService;

import jakarta.validation.Valid;

@Controller
public class ParfumController {

	@Autowired
	ParfumService parfumService;

	@RequestMapping("/ListeParfums")
	public String listeParfums(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Parfum> parfs = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", parfs);
		modelMap.addAttribute("pages", new int[parfs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeParfums";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Marque> marqs = parfumService.getAllMarques();
		modelMap.addAttribute("parfum", new Parfum());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", marqs);
		return "formParfum";
	}

	@RequestMapping("/saveParfum")
	public String saveParfum(@Valid Parfum parfum, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formParfum";
		if (parfum.getIdParfum() == null) // ajout
			isNew = true;
		parfumService.saveParfum(parfum);
		if (isNew) // ajout
		{
			Page<Parfum> parfs = parfumService.getAllParfumsParPage(page, size);
			currentPage = parfs.getTotalPages() - 1;
		} else // modif
			currentPage = page;
		return ("redirect:/ListeParfums?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerParfum")
	public String supprimerParfum(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		parfumService.deleteParfumById(id);
		Page<Parfum> parfs = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", parfs);
		modelMap.addAttribute("pages", new int[parfs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeParfums";
	}

	@RequestMapping("/modifierParfum")
	public String editerParfum(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Parfum p = parfumService.getParfum(id);
		List<Marque> marqs = parfumService.getAllMarques();
		modelMap.addAttribute("parfum", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", marqs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formParfum";
	}

	@RequestMapping("/updateParfum")
	public String updateParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		parfum.setDateCreation(dateCreation);

		parfumService.updateParfum(parfum);
		List<Parfum> parfs = parfumService.getAllParfums();
		modelMap.addAttribute("produits", parfs);
		return "listeParfums";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
	@GetMapping("/auth")
	Authentication getAuth(Authentication auth)
	{
	return auth;
	}
}
