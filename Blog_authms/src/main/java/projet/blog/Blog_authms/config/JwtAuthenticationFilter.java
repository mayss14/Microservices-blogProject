package projet.blog.Blog_authms.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import projet.blog.Blog_authms.services.JwtService;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtservice;
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response
            , @NotNull FilterChain filterChain) throws ServletException, IOException {
final String authHeader=request.getHeader("Authorization");
final String jwtToken;
final String userLogin;
if(authHeader==null || !authHeader.startsWith("Bearer ")){
    filterChain.doFilter(request,response);
    return;
}
jwtToken=authHeader.substring(7);
userLogin=jwtservice.extractUsername(jwtToken);
if(userLogin!=null && SecurityContextHolder.getContext().getAuthentication()==null){
    UserDetails userDetails=this.userDetailsService.loadUserByUsername(userLogin);
    if(jwtservice.isTokenValid(jwtToken,userDetails)){
        UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
authToken.setDetails(
        new WebAuthenticationDetailsSource().buildDetails(request)
);
SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
filterChain.doFilter(request,response);
    }
}
