package com.scm20.demo.handlers;

import com.scm20.demo.Repository.UserRepository;
import com.scm20.demo.entities.UserEntity;
import com.scm20.demo.entities.enums.Providers;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Oauth2successhandler implements AuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(Oauth2successhandler.class);
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        String clientID = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

        DefaultOAuth2User defaultOAuth2User= (DefaultOAuth2User) authentication.getPrincipal();

        UserEntity user = new UserEntity();
        user.setEnabled(true);
        user.setEmailVerified(true);
        user.setRoles(List.of("ROLE_USER"));

        if(clientID.equalsIgnoreCase("google")){
            user.setName(defaultOAuth2User.getAttribute("name").toString());
            user.setEmail(defaultOAuth2User.getAttribute("email").toString());
            user.setProfileLink(defaultOAuth2User.getAttribute("picture").toString());
            user.setProviderUserID(defaultOAuth2User.getName());
            user.setProvider(Providers.GOOGLE);
        } else if (clientID.equalsIgnoreCase("github")) {
            user.setEmail(defaultOAuth2User.getAttribute("email") != null ? defaultOAuth2User.getAttribute("email").toString() : defaultOAuth2User.getAttribute("login").toString() + "gmail.com");
            user.setName(defaultOAuth2User.getAttribute("login").toString());
            user.setProfileLink(defaultOAuth2User.getAttribute("avatar_url").toString());
            user.setProvider(Providers.GITHUB);
            user.setProviderUserID(defaultOAuth2User.getName());
        }else {
            logger.info("Unknown provider");
        }
        UserEntity user2 = userRepository.findUserByEmail(user.getEmail()).orElse(null);
        if(user2==null) {
            logger.info("user saving");
            userRepository.save(user);
        }
        String frontEndUrl = "http://localhost:8080/user/profile";
        response.sendRedirect(frontEndUrl);
    }


}
