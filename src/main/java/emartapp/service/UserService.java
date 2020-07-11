package emartapp.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import emartapp.dao.UserDAO;
import emartapp.model.User;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserDAO userDAO;
	
	public String getCurrentUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public void save(User theUser) {
		userDAO.save(theUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = userDAO.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				Stream.of(user.getRoles())
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList()));
	}
}
