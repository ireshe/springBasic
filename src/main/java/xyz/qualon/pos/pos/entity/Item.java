package xyz.qualon.pos.pos.entity;

import lombok.*;
import xyz.qualon.pos.pos.entity.enums.MeasuringUnitTypes;

import javax.persistence.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_unit", length = 45, nullable = false)
    private MeasuringUnitTypes measuringUnitType;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private Double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private Double supplierPrice;

    @Column(name = "selling_price", length = 100, nullable = false)
    private Double sellingPrice;

    @Column(name = "active_status", columnDefinition = "TINYINT default 0")
    private boolean isActive;
}
