package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "corporative_customer")
public class CorporativeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer vat;
    @Column(name = "firm_name")
    private String firmName;
    @Column(name = "firm_address")
    private String firmAddress;
    @Column(name = "customer_id")
    private Integer customerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;
}
