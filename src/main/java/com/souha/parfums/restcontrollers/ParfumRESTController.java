package com.souha.parfums.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.souha.parfums.dto.ParfumDTO;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.service.ParfumService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParfumRESTController {
	@Autowired
	ParfumService parfumService;
	@RequestMapping(method = RequestMethod.GET)
	public List<ParfumDTO> getAllParfums() {
	return parfumService.getAllParfums();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ParfumDTO getParfumById(@PathVariable("id") Long id) {
	return parfumService.getParfum(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ParfumDTO createParfum(@RequestBody ParfumDTO parfumDTO) {
	return parfumService.saveParfum(parfumDTO);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ParfumDTO updateParfum(@RequestBody ParfumDTO parfumDTO) {
	return parfumService.updateParfum(parfumDTO);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		parfumService.deleteParfumById(id);
	}
	@RequestMapping(value="/parfsmarq/{idMarque}",method = RequestMethod.GET)
	public List<Parfum> getProduitsByCatId(@PathVariable("idMarque") Long idMarque) {
	return parfumService.findByMarqueIdMarque(idMarque);
	}

}
