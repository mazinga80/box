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
        
        //username�� �Է¹޾Ƽ� ��񿡼� �ؽõ� ��й�ȣ�� �����´�.
        //���� username���� ������ ������ ����� ���ٸ� UsernameNotFoundException ���ܸ� throw �ϸ� �ȴ�.
        
        
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
        	//��й�ȣ�� ���Ѵ�.
        	
        	cud.setUsername(username);
        	cud.setPassword((String)customerMap.get("LOGIN_PWD"));
        }
        else
        {
        	//��� ����
        	throw new UsernameNotFoundException("������ ������ ã�� �� �����ϴ�.");
        }

        return cud;
    }
}

