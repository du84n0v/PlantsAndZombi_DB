package entity;

import enums.PlantType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "latin_name")
    private String latinName;
    @Column(name = "common_name")
    private String commonName;
    @Column
    private String code;
    @Enumerated(EnumType.STRING)
    private PlantType type;
    @Column(name = "exotic")
    private Boolean isExotic;
    @Column(name = "flowering")
    private Boolean isFlowering;
    @Column(name = "flower_color")
    private String flowerColor;
    @Column(name = "supplier_id")
    private Integer supplierId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", latinName='" + latinName + '\'' +
                ", commonName='" + commonName + '\'' +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", isExotic=" + isExotic +
                ", isFlowering=" + isFlowering +
                ", flowerColor='" + flowerColor + '\'' +
                ", supplierId=" + supplierId +
                '}';
    }
}
