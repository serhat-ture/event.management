package com.blc.eventManagement.model;



import jakarta.persistence.*;
import lombok.*;




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
     private String start;
     private String finish;
     private int quota;
     private int participants;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
       private City city;

}
