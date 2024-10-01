package com.scm20.demo.helpers;

import com.scm20.demo.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.security.Principal;
import java.sql.SQLOutput;

public class helper {

    static Logger logger = LoggerFactory.getLogger(helper.class);
    public static String getEmailOfLoggedInUser(Authentication authentication){


        if(authentication.getPrincipal() instanceof OAuth2AuthenticatedPrincipal){
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            String clientID= oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
            DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();

            //goggle
            if(clientID.equalsIgnoreCase("google")){
               return user.getAttribute("email").toString();
            }
            //github
            else{
                return user.getAttribute("login").toString()+"@gmail.com";
            }
        }else{
            UserEntity user = (UserEntity) authentication.getPrincipal();
            return user.getEmail();
        }
    }


}
