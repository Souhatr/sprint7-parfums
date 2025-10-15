package com.souha.parfums.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.souha.parfums.entities.Parfum;
import com.souha.parfums.service.ParfumService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParfumRESTController {
	@Autowired
	ParfumService parfumService;
	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Parfum> getAllParfums() {
	return parfumService.getAllParfums();
	}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Parfum getParfumById(@PathVariable("id") Long id) {
	return parfumService.getParfum(id);
	}
	@RequestMapping(path="/addparf",method = RequestMethod.POST)
	public Parfum createParfum(@RequestBody Parfum parfum) {
	return parfumService.saveParfum(parfum);
	}
	@RequestMapping(path="/updateparf",method = RequestMethod.PUT)
	public Parfum updateParfum(@RequestBody Parfum parfum) {
	return parfumService.updateParfum(parfum);
	}
	@RequestMapping(value="/delparf/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		parfumService.deleteParfumById(id);
	}
	@RequestMapping(value="/parfsmarq/{idMarque}",method = RequestMethod.GET)
	public List<Parfum> getParfumsByMarqId(@PathVariable("idMarque") Long idMarque) {
	return parfumService.findByMarqueIdMarque(idMarque);
	}
	@RequestMapping(value="/parfsByName/{nom}",method = RequestMethod.GET)
	public List<Parfum> findByNomParfumContains(@PathVariable("nom") String nom) {
	return parfumService.findByNomParfumContains(nom);
	}
	@GetMapping("/auth")
	Authentication getAuth(Authentication auth)
	{
	return auth;
	}

}
