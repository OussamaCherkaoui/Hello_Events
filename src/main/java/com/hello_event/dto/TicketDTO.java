package com.hello_event.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private Long id;
    private Long user_id;
    private Long event_id;
    private LocalDateTime purchaseDate;
}
