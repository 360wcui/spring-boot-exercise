package com.example.springexplorationsjava;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="UNIT_CONTRACT")
public class UnitContractEntity {

    //@Column(name = "unit_contract_id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String unitId;
    private String callword;
    private String aircraftType;
    private String standardConventionalLoad;

    private String countryCode;
    private String service;

    private LocalDate atoStartDate;
    private LocalDate atoEndDate;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="unit_contract_id",  referencedColumnName="unit_contract_id")
    @OneToMany(mappedBy = "unitContractEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineEntity> lineEntities;

    private String deployedBaseIcao;
    private String restrictions;

    public UnitContractEntity() {
       // this(0, "", "", "","","",
       //         "", LocalDate.now(), LocalDate.now(),new ArrayList<>(), "","");
    }

    public UnitContractEntity(String unitId, String callword, String aircraftType, String standardConventionalLoad, String countryCode, String service,
                              LocalDate atoStartDate, LocalDate atoEndDate, String deployedBaseIcao, String restrictions) {
        this.unitId = unitId;
        this.callword = callword;
        this.aircraftType = aircraftType;
        this.countryCode = countryCode;
        this.standardConventionalLoad = standardConventionalLoad;
        this.service = service;
        this.atoStartDate = atoStartDate;
        this.atoEndDate = atoEndDate;
        this.deployedBaseIcao = deployedBaseIcao;
        this.restrictions = restrictions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getCallword() {
        return callword;
    }

    public void setCallword(String callword) {
        this.callword = callword;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getStandardConventionalLoad() {
        return standardConventionalLoad;
    }

    public void setStandardConventionalLoad(String standardConventionalLoad) {
        this.standardConventionalLoad = standardConventionalLoad;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDate getAtoStartDate() {
        return atoStartDate;
    }

    public void setAtoStartDate(LocalDate atoStartDate) {
        this.atoStartDate = atoStartDate;
    }

    public LocalDate getAtoEndDate() {
        return atoEndDate;
    }

    public void setAtoEndDate(LocalDate atoEndDate) {
        this.atoEndDate = atoEndDate;
    }

    public List<LineEntity> getLineEntities() {
        return lineEntities;
    }

    public void setLineEntities(List<LineEntity> lineEntities) {
        this.lineEntities = lineEntities;
    }

    public String getDeployedBaseIcao() {
        return deployedBaseIcao;
    }

    public void setDeployedBaseIcao(String deployedBaseIcao) {
        this.deployedBaseIcao = deployedBaseIcao;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }


}
