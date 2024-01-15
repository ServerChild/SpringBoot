package com.study.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			// 람다 형태 : request -> request (security 7.0부터 람다식만 사용 가능)
			http.csrf((csrf) -> csrf.disable())
				.cors((cors) -> cors.disable())
				.authorizeHttpRequests(request -> request
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() // permitAll : 모두 허용
						.requestMatchers("/").permitAll()
						.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
						.requestMatchers("/guest/**").permitAll()
						.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN") // hasAnyRole : 한명 이상 권한 줄 경우
						.requestMatchers("/admin/**").hasRole("ADMIN") // hasRole : 한명만 권한 줄 경우
						.anyRequest().authenticated() // 요청에 대한 확인
						);
			
			// 스프링부터에서 제공해주는 login Form
//			http.formLogin((formLogin) ->
//								formLogin.permitAll());
			
			// 만든 Form 사용
			http.formLogin((formLogin) -> formLogin
								.loginPage("/loginForm") // 로그인 폼 URL(default : "/login")
								.loginProcessingUrl("/login_check") // action(mapping)에 들어가있는 URL
								.usernameParameter("username") // 기본값 : j_username
								.passwordParameter("password") // 기본값 : j_password
								.permitAll());
			
			http.logout((logout) -> logout
							.logoutUrl("/logout")
							.logoutSuccessUrl("/")
							.permitAll());
			
			return http.build();
		}
		
		// 메모리에 유저 생성
		@Bean
		public UserDetailsService users() {
			// Member 유저 생성
			UserDetails user = User.builder()
								   .username("user")
								   .password(pEncoder().encode("1234"))
								   .roles("USER")
								   .build();
			
			// admin 유저 생성
			UserDetails admin = User.builder()
					   .username("admin")
					   .password(pEncoder().encode("1234"))
					   .roles("USER", "ADMIN")
					   .build();
			
			//메모리에 사용자 정보를 담음
			return new InMemoryUserDetailsManager(user, admin);
		}
		
		public PasswordEncoder pEncoder() {
			return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
		
}
