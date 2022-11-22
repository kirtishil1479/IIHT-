package com.token.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;






@Component
public class JWTUtility implements Serializable {
	
	private static final long serialversionUid=234234523523L;
	 
	private static final long JWT_TOKEN_VALIDITY=5*30*30;
	
	

    private String secreteKey="kirtishil1479";
	
	
	public String getUsernameFromToken(String token){
		return getClaimFromToken(token,Claims::getSubject);
	}
     
     
	// retrive expiration date from token
	
	public Date getExpirationdateFromToken(String token) {
		return getClaimFromToken(token,Claims::getExpiration);
	}
	
	//to get the claim from token
	public <T> T getClaimFromToken(String token,Function<Claims,T> claimsResolver) {
		final Claims claims=getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
		
	}


	private Claims getAllClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(secreteKey).parseClaimsJws(token).getBody();
	}
	
	
	// to check if token  is expired or not
	
	private boolean isTokenExpired(String token) {
		final Date expiration= getExpirationdateFromToken(token);
		return expiration.before(new Date());
	}
	
	
	// generate token
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<>();
		return doGenerateToken(claims,userDetails.getUsername());
	}


	private String doGenerateToken(Map<String, Object> claims, String subject) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
				.signWith(SignatureAlgorithm.HS512,secreteKey).compact();
	}
	
	// validate  token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username=getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
	}
	
	

}
