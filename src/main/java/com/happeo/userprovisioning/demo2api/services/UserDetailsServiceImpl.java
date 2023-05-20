package com.happeo.userprovisioning.demo2api.services;

import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import com.happeo.userprovisioning.demo2api.dao.UsersRepository;
// import com.happeo.userprovisioning.demo2api.model.users.User;
// import com.happeo.userprovisioning.demo2api.model.provisioners.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	// @Autowired
	// UsersRepository userRepository;

	// @Override
	// @Transactional
	// public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// 	User user = userRepository.findByUsername(username)
	// 			.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	// 	return UserDetailsImpl.build(user);
	// }

    @Override
    @Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin".equals(username)) {
			return new User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}