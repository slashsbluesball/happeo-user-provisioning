// package com.happeo.userprovisioning.demo2api.config;

// import java.io.IOException;
// import java.io.Serializable;

// // import javax.servlet.http.HttpServletRequest;
// // import javax.servlet.http.HttpServletResponse;

// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.stereotype.Component;

// // import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

// 	private static final long serialVersionUID = -7858869558953243875L;

// 	@Override
// 	public void commence(HttpServletRequest request, HttpServletResponse response,
// 			AuthenticationException authException) throws IOException {

// 		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
// 	}

//     // @Override
//     // public void commence(jakarta.servlet.http.HttpServletRequest request,
//     //         jakarta.servlet.http.HttpServletResponse response, AuthenticationException authException)
//     //         throws IOException, ServletException {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'commence'");
//     // }
// }