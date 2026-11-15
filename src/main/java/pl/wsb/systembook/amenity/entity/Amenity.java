package pl.wsb.systembook.amenity.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "amenity")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "description", length = 120)
    private String description;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "available", nullable = false)
    private Boolean available;

    protected Amenity() {
    }

    public Amenity(String name, String description, BigDecimal unitPrice, Boolean available) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Boolean getAvailable() {
        return available;
    }
}