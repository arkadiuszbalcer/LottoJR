package pl.lotto.infrastracute.numberreceiver.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lotto.domain.numberreceiver.NumberReceiverFacade;
import pl.lotto.domain.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.domain.numberreceiver.dto.TicketDto;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Log4j2
@AllArgsConstructor
public class InputNumbersRestController {
    private final NumberReceiverFacade numberReceiverFacade;
    @PostMapping("/inputNumbers")
    public ResponseEntity<NumberReceiverResponseDto> inputNumbers(@RequestBody @Valid InputNumbersRequestDto requestDto){
        Set<Integer> collect = new HashSet<>(requestDto.inputNumbers());
       NumberReceiverResponseDto numberReceiverResponseDto = numberReceiverFacade.inputNumbers(collect);
    return ResponseEntity.ok(numberReceiverResponseDto);
    }
}
