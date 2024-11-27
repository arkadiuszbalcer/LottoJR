package pl.lotto.domain.numberreceiver;
import org.junit.jupiter.api.Test;
import pl.lotto.domain.AdjustableClock;
import pl.lotto.domain.numberreceiver.dto.InputNumberResultDto;
import pl.lotto.domain.numberreceiver.dto.TicketDto;

import java.time.*;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberReceiverFacadeTest {
    AdjustableClock clock= new AdjustableClock(LocalDateTime.of(2022,2,15,11,0,0).toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
    NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade(
            new NumberValidator(),
            new InMemoryNumberReceiverRepository(),
        clock
    );
    @Test
    public void should_return_success_when_user_give_six_numbers()
    {
        //given
        Set<Integer> numbersFromUSer = Set.of(1,2,3,4,5,6);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUSer);
        LocalDateTime drawDate = LocalDateTime.of(2023,2,15,12,0,0);
        //when
        clock.advanceInTimeBy(Duration.ofDays(5));
        //then
        assertThat(result.message()).isEqualTo("success");
        }
    @Test
    public void should_return_failed_when_user_give_less_than_six_numbers(){
        //given
        Set<Integer> numbersFromUSer = Set.of(1,3,4,5,6);
        //when
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUSer);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }

    @Test
    public void should_return_failed_when_user_give_more_than_six_numbers() {
        //given
        Set<Integer> numbersFromUSer = Set.of(1, 2, 7, 3, 4, 5, 6);
        //when
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUSer);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }
    @Test
    public void should_return_failed_when_user_give_at_least_one_number_out_of_range_1_99(){
        //given
        Set<Integer> numbersFromUSer = Set.of(1,20000,3,4,5,6);
        //when
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUSer);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }
    @Test
    public void should_return_save_to_database_when_user_give_six_numbers() {
        //given
        Set<Integer> numbersFromUSer = Set.of(1,2,3,4,5,6);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUSer);
        LocalDateTime drawDate = LocalDateTime.of(2022,2,15,12,0,0);
        //when
        List<TicketDto> ticketDtos = numberReceiverFacade.userNumbers(drawDate);
        //then
        assertThat(ticketDtos).contains(
                TicketDto.builder()
                        .ticketId(result.ticketId())
                        .drawDate(result.drawDate())
                        .numbersFromUser(result.numbersFromUser())
                        .build()

        );
    }

}