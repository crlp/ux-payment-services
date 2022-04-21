package bcp.bootcamp.uxpaymentservice.entities;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private Integer id;
    private String code;
    private String supply;
    private Double amount;
    private int favorite;
    private LocalDateTime date;
    private String channel;
}
