package pl.lotto.infrastracute.resultannouncer.controller.error;

import org.springframework.http.HttpStatus;

public record ResultAnnouncerErrorResponse(String message, HttpStatus status) {
}
