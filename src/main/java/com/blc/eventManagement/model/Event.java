package com.blc.eventManagement.model;


//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

//import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_name", nullable = false)
    private String eventName;
   // @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "start", nullable = false)
    private String start;
   // @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "finish", nullable = false)
    private String finish;
    @Column(name = "quota", nullable = false)
    private int quota;
    @Column(name = "participants", nullable = false)
    private int participants;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
       private User user;

}
