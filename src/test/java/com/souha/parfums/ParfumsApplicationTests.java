package com.souha.parfums;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.souha.parfums.entities.Marque;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.repos.ParfumRepository;
import com.souha.parfums.service.ParfumService;

@SpringBootTest
class ParfumsApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;
	@Autowired
	private ParfumService parfumService;

	@Test
	public void testCreateParfum() {
		Parfum parf = new Parfum("channel 5", 400.00, new Date());
		parfumRepository.save(parf);
	}

	@Test
	public void testFindParfum() {
		Parfum p = parfumRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateParfum() {
		Parfum p = parfumRepository.findById(2L).get();
		p.setPrixParfum(400.0);
		parfumRepository.save(p);
	}

	@Test
	public void testDeleteParfum() {
		parfumRepository.deleteById(6L);
		;
	}

	@Test
	public void testListerTousParfums() {
		List<Parfum> parfs = parfumRepository.findAll();
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomParfum() {
		List<Parfum> parfs = parfumRepository.findByNomParfum("sauvage");
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomParfumContains() {
		/*
		 * Page<Parfum> parfs = parfumService.getAllParfumsParPage(0, 2);
		 * System.out.println(parfs.getSize());
		 * System.out.println(parfs.getTotalElements());
		 * System.out.println(parfs.getTotalPages()); parfs.getContent().forEach(p -> {
		 * System.out.println(p.toString()); });
		 * 
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
		List<Parfum> parfs = parfumRepository.findByNomParfumContains("a");
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Parfum> parfs = parfumRepository.findByNomPrix("sauvage", 400.0);
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByMarque() {
		Marque marq = new Marque();
		marq.setIdMarque(1L);
		List<Parfum> parfs = parfumRepository.findByMarque(marq);
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}
	@Test
	public void findByMarqueIdMarque()
	{
		List<Parfum> parfs = parfumRepository.findByMarqueIdMarque(1L);
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}
	@Test
	public void testfindByOrderByNomParfumAsc()
	{
		List<Parfum> parfs = parfumRepository.findByOrderByNomParfumAsc();
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}
	@Test
	public void testTrierParfumsNomsPrix()
	{
		List<Parfum> parfs = parfumRepository.trierParfumsNomsPrix();
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}
	

}
