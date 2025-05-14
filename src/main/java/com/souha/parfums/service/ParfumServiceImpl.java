package com.souha.parfums.service;
import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.souha.parfums.entities.Marque;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.repos.MarqueRepository;
import com.souha.parfums.repos.ParfumRepository;
@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	ParfumRepository parfumRepository;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);
	}
	@Override
	public Parfum updateParfum(Parfum p) {
		return parfumRepository.save(p);
	}
	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
	}
	@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
	}
	@Override
	public Parfum getParfum(Long id) {
		return parfumRepository.findById(id).get();
	}
	@Override
	public List<Parfum> getAllParfums() {
		return parfumRepository.findAll();
	}
	@Override
	public Page<Parfum> getAllParfumsParPage(int page, int size) {
		return parfumRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Parfum> findByNomParfum(String nom) {
		return parfumRepository.findByNomParfum(nom);
	}
	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
		
		return parfumRepository.findByNomParfumContains(nom);
	}
	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
		
		return parfumRepository.findByNomPrix(nom,prix);
	}
	@Override
	public List<Parfum> findByMarque(Marque marque) {
		
		return  parfumRepository.findByMarque(marque);
	}
	@Override
	public List<Parfum> findByMarqueIdMarque(Long id) {
		
		return  parfumRepository.findByMarqueIdMarque(id);
	}
	@Override
	public List<Parfum> findByOrderByNomParfumAsc() {
		
		return parfumRepository.findByOrderByNomParfumAsc();
	}
	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		
		return parfumRepository.trierParfumsNomsPrix();
	}
	@Autowired
	MarqueRepository marqueRepository;
	@Override
	public List<Marque> getAllMarques()
	{
		return marqueRepository.findAll();
	}
	/*@Override
	public ParfumDTO convertEntityToDto(Parfum parfum) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ParfumDTO parfumDTO=modelMapper.map(parfum,ParfumDTO.class);
		return parfumDTO;
		/*ParfumDTO parfumDTO = new ParfumDTO();
		parfumDTO.setIdParfum(parfum.getIdParfum());
		parfumDTO.setNomParfum(parfum.getNomParfum());
		parfumDTO.setPrixParfum(parfum.getPrixParfum());
		parfumDTO.setDateCreation(parfum.getDateCreation());
		//parfumDTO.setNomMarque(parfum.getMarque().getNomMarque());
		parfumDTO.setMarque(parfum.getMarque()); 
		return parfumDTO;
		 
		
	}
	@Override
	public Parfum convertDtoToEntity(ParfumDTO parfumDTO) {
		Parfum parfum= new Parfum();
		parfum = modelMapper.map(parfumDTO, Parfum.class);
		return parfum;
		/*parfum.setIdParfum(parfumDTO.getIdParfum());
		parfum.setNomParfum(parfumDTO.getNomParfum());
		parfum.setPrixParfum(parfumDTO.getPrixParfum());
		parfum.setDateCreation(parfumDTO.getDateCreation());
		//parfumDTO.setNomMarque(parfum.getMarque().getNomMarque());
		parfum.setMarque(parfumDTO.getMarque()); 
		return parfum; 
	} */
}
