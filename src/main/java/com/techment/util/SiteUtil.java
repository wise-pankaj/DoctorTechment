package com.techment.util;

import java.util.UUID;

import org.springframework.stereotype.Component;



@Component
public class SiteUtil {
	
	
	public String generateToken() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	
}