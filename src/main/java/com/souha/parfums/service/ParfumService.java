package com.souha.parfums.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.souha.parfums.dto.ParfumDTO;
import com.souha.parfums.entities.Marque;
import com.souha.parfums.entities.Parfum;
public interface ParfumService {
	ParfumDTO saveParfum(ParfumDTO p);
	ParfumDTO updateParfum(ParfumDTO p);
	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	ParfumDTO getParfum(Long id);
	List<ParfumDTO> getAllParfums();
	Page<Parfum> getAllParfumsParPage(int page, int size);
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByMarque (Marque marque);
	List<Parfum> findByMarqueIdMarque(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	List<Parfum> trierParfumsNomsPrix();
	List<Marque> getAllMarques();
	ParfumDTO convertEntityToDto (Parfum parfum);
	Parfum convertDtoToEntity(ParfumDTO parfumDto);
	
}
