package com.job.future.jobservice.utils.jwtconfig;

import com.job.future.jobservice.service.serviceIpm.UserDetailsServiceIpm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
    private final static String TOKEN_HEADER = "authorization";

    private final JwtUtils jwtUtils;
    private UserDetailsServiceIpm userDetailsServiceIpm;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(TOKEN_HEADER);
        if (jwtUtils.validateTokenLogin(authToken)) {
            String username = jwtUtils.getUsernameFromToken(authToken);
            UserDetails user = userDetailsServiceIpm.loadUserByUsername(username);
            if (user != null) {
                boolean enabled = true;
                boolean accountNonExpired = true;
                boolean credentialsNonExpired = true;
                boolean accountNonLocked = true;
                UserDetails userDetail = new User(username, user.getPassword(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked, user.getAuthorities());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
                        null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

    public JwtAuthenticationTokenFilter(JwtUtils jwtUtils, UserDetailsServiceIpm userDetailsServiceIpm){
        this.jwtUtils = jwtUtils;
        this.userDetailsServiceIpm = userDetailsServiceIpm;
    }

}
