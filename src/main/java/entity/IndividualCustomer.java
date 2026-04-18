package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "individual_customer")
public class IndividualCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String address;
    @Column(name = "customer_id")
    private Integer customerId;
    @OneToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;
}
