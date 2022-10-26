package com.auth.srv.security;

import com.auth.srv.dto.RequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ConfigurationProperties(prefix= "admin-paths")
public class RouteValidator {

    private List<RequestDto> paths;

    public boolean isAdminPath(RequestDto dto) {

        return paths.stream().anyMatch(requestDto ->
                //requestDto.getUri().equals(dto.getUri()) && //Sin expresiones regulares en las rutas paths del bootstrap
                Pattern.matches(requestDto.getUri(), dto.getUri()) &&
                requestDto.getMethod().equals(dto.getMethod()));
    }
}
