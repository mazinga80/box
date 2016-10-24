package com.spring.wizwid.common.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class CustomUserDetails implements UserDetails
{
    private String username;
    private String password;
    
    // 추가적인 회원정보 항목을 추가한다. email 이나 연락처 등등...
    
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return authorities;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername() 
    {
        return username;
    }
    
    public boolean isAccountNonExpired() 
    {
        return true;
    }
    
    public boolean isAccountNonLocked() 
    { 
        return true;
    }
    
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }
    
    public boolean isEnabled() 
    {
        return true;
    }
}