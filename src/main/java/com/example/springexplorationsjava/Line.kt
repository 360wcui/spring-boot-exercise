package com.example.springexplorationsjava


import java.math.BigDecimal
import java.time.LocalTime
import javax.persistence.*
import javax.persistence.GeneratedValue
import org.hibernate.annotations.GenericGenerator

@Entity
data class Line(
    var vulStart: LocalTime? = null,

    var vulEnd: LocalTime? = null,

    var flex: BigDecimal? = null,
    var aircraftQuantity: Int = 2,

    @Id
    @GenericGenerator(name = "lineIdGen", strategy = "increment")
    @GeneratedValue(generator = "lineIdGen")
    @Column(name = "line_id", nullable = false)
    private val id: Long = 0,

    @Column(name = "unit_contract_id")
    private val unit_contract_id: Long? = null
)