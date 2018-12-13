package com.example.springexplorationsjava;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="LINE")
public class LineEntity {


    //@Column(name = "line_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalTime vulStart;
    private LocalTime vulEnd;
    private double flex;
    private int aircraftQuantity;

//    @Column(name = "unit_contract_id")
//    private long unitContractId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_contract_id")
    private UnitContractEntity unitContractEntity;

    public LineEntity() {
        //this(LocalTime.now(), LocalTime.now(), 0.0, 2);
    }

    public LineEntity(LocalTime vulStart, LocalTime vulEnd, double flex, int aircraftQuantity, UnitContractEntity unitContractEntity) {
        this.vulStart = vulStart;
        this.vulEnd = vulEnd;
        this.flex = flex;
        this.aircraftQuantity = aircraftQuantity;
        this.unitContractEntity = unitContractEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getVulStart() {
        return vulStart;
    }

    public void setVulStart(LocalTime vulStart) {
        this.vulStart = vulStart;
    }

    public LocalTime getVulEnd() {
        return vulEnd;
    }

    public void setVulEnd(LocalTime vulEnd) {
        this.vulEnd = vulEnd;
    }

    public double getFlex() {
        return flex;
    }

    public void setFlex(double flex) {
        this.flex = flex;
    }

    public int getAircraftQuantity() {
        return aircraftQuantity;
    }

    public void setAircraftQuantity(int aircraftQuantity) {
        this.aircraftQuantity = aircraftQuantity;
    }

    public UnitContractEntity getUnitContractEntity() {
        return unitContractEntity;
    }

    public void setUnitContractEntity(UnitContractEntity unitContractEntity) {
        this.unitContractEntity = unitContractEntity;
    }
}
