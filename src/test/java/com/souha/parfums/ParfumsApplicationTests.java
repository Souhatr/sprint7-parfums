package com.souha.parfums;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

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
	public void testCreateProduit() {
		Parfum parf = new Parfum("channel 5", 400.00, new Date());
		parfumRepository.save(parf);
	}

	@Test
	public void testFindProduit() {
		Parfum p = parfumRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Parfum p = parfumRepository.findById(2L).get();
		p.setPrixParfum(400.0);
		parfumRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		parfumRepository.deleteById(6L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Parfum> parfs = parfumRepository.findAll();
		for (Parfum p : parfs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		Page<Parfum> parfs = parfumService.getAllParfumsParPage(0, 2);
		System.out.println(parfs.getSize());
		System.out.println(parfs.getTotalElements());
		System.out.println(parfs.getTotalPages());
		parfs.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}
}
