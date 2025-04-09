package com.souha.parfums.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomParf", types = { Parfum.class })
public interface ParfumProjection {
	public String getNomParfum();
}
