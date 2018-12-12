package com.example.springexplorationsjava

import java.time.LocalDate
import javax.persistence.*

@Entity
data class UnitContract(
    var unitId: String? = null,
    var callword: String? = null,
    var aircraftType: String? = null,
    var standardConventionalLoad: String? = null,

    var countryCode: String? = null,
    var service: String? = null,

    var atoStartDate: LocalDate? = null,
    var atoEndDate: LocalDate? = null,

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="unit_contract_id", referencedColumnName="unit_contract_id")
    private var lines: List<Line>,

    var deployedBaseIcao: String? = null,
    var restrictions: String? = null,

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private val id: Int? = null
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_contract_id", nullable=false)
    private val id: Long
)