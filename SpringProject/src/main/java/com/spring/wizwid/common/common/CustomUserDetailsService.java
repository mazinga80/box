package com.spring.wizwid.common.common;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.wizwid.front.customer.service.CustomerService;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Resource(name="customerService")
    private CustomerService customerService;
	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        
        CustomUserDetails cud = new CustomUserDetails();
        
        //username을 입력받아서 디비에서 해시된 비밀번호를 가져온다.
        //만약 username으로 쿼리를 날려서 결과가 없다면 UsernameNotFoundException 예외를 throw 하면 된다.
        
        
        log.debug("username===>"+username);
        log.debug("userpass===>"+cud.getPassword());
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("LOGIN_ID", username);
        
        Map<String,Object> customerMap = new HashMap<String,Object>(); 
        
        try
        {
        	customerMap = customerService.getCustomer(map);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        
        if( customerMap != null)
        {
        	//비밀번호를 비교한다.
        	
        	cud.setUsername(username);
        	cud.setPassword((String)customerMap.get("LOGIN_PWD"));
        }
        else
        {
        	//결과 없음
        	throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");
        }

        return cud;
    }
}

