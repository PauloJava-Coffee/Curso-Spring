/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.security;

import io.github.paulojava_coffee.libraryapi.model.Usuario;
import io.github.paulojava_coffee.libraryapi.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@Component
public class LoginSocialSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static String SENHA_PADRAO = "123";
    private final UsuarioService usuarioService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws ServletException, IOException {

        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        Usuario usuario = usuarioService.obterPorEmail(email);
        if (usuario == null) {
           usuario =  cadastrarUsuarioNaBase(email);
        }
        CustomAuthentication CustomAuthentication = new CustomAuthentication(usuario);

        SecurityContextHolder.getContext().setAuthentication(CustomAuthentication);

        super.onAuthenticationSuccess(request, response, CustomAuthentication);

        System.out.println(email);
    }

    private Usuario cadastrarUsuarioNaBase(String email) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(email);
        novoUsuario.setLogin(email);
        novoUsuario.setSenha(SENHA_PADRAO);
        usuarioService.salvar(novoUsuario);
        return novoUsuario;
    }
}
