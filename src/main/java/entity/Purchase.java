package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer quantity;
    @Column
    private LocalDateTime date;

    @Column(name = "customer_id")
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "plant_id")
    private Integer plantId;
    @ManyToOne
    @JoinColumn(name = "plant_id", insertable = false, updatable = false)
    private Plant plant;

    @Column(name = "price_id")
    private Integer priceId;
    @ManyToOne
    @JoinColumn(name = "price_id", insertable = false, updatable = false)
    private PlantPrice price;
}
