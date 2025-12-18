package tech.buildrun.springsecurity.controllers.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
