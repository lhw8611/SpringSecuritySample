package com.eins.security;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eins.dao.LoginMapper;
import com.eins.dto.LoginLog;
import com.eins.dto.Member;



@Service
public class UserServiceImpl implements SecurityService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);
	
	@Autowired
	LoginMapper loingMapper;
	
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
	// 시큐리티 사용자 인증
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
         Member member = loingMapper.getSelectMeberInfo(id);
         List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
         if(member != null) {
             authorities.add(new SimpleGrantedAuthority(member.getUserRole()));
             member.setAuthorities(authorities);
         }
         return member;
    }
    
    @Override
	public int setInsertMember(Member member) throws Exception{
    	member.setPassword(passwordEncoder.encode(member.getPassword()));
		return loingMapper.setInsertMember(member);
	}
  

    @Override
	public Member getSelectMeberInfo(String id) throws Exception{
		return loingMapper.getSelectMeberInfo(id);
	}
	
    
    @Override
	public int setInsertLoginLog(LoginLog loginLog) throws Exception{
		return loingMapper.setInsertLoginLog(loginLog);
	}
	
    @Override
	public int setUpdatePasswordLockCnt(String id) throws Exception{
		return loingMapper.setUpdatePasswordLockCnt(id);
	}
	
    @Override
	public int setUpdatePasswordLockCntReset(String id) throws Exception{
		return loingMapper.setUpdatePasswordLockCntReset(id);
	}

}
