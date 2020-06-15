package com.bookapp;

//@Configuration
public class WebConfig {//extends WebSecurityConfigurerAdapter{
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("Shoba")
//		.password(passwordEncoder().encode("pass123"))
//		.roles("USER")
//		.and()
//		.withUser("Raju")
//		.password(passwordEncoder().encode("admin123"))
//		.roles("USER","ADMIN");
//	}
//// authorize
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/**").permitAll();
//		//.antMatchers("/book-api/userbooks").hasAnyRole("USER","ADMIN")
//		//.antMatchers("/book-api/books").hasRole("ADMIN")
//		//.and()
//		//.formLogin();
//	}

	
}
