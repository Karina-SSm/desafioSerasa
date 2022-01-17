package com.br.Serasa.desafioSerasa.util;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ResourceUriUtil {
	
	  public static void addUriInResponseHeader(Object idResource) {
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(idResource)
	                .toUri();
	        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	        response.setHeader(HttpHeaders.LOCATION, uri.toString());
	    }


}
