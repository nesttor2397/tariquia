//package web.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import static java.util.Collections.emptyList;;
//
//public class JwtUtil {
//
//	static void addAuthentication(HttpServletResponse res, String username) {
//		String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, "P@tit0").compact();
//		res.addHeader("Authorization", "Bearer " + token);
//	}
//
//	static Authentication getAuthentication(HttpServletRequest request) {
//		String token = request.getHeader("Authorization");
//
//		if (token != null) {
//			String usuario = Jwts.parser().setSigningKey("P@tit0").parseClaimsJws(token.replace("Bearer", "")).getBody()
//					.getSubject();
//			return usuario != null ? new UsernamePasswordAuthenticationToken(usuario, null, emptyList()) : null;
//		}
//
//		return null;
//	}
//}
