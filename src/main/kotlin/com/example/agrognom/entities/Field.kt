package com.example.agrognom.entities

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal

@Entity
@Table(name = "fields")
open class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    open var user: User? = null

    @Column(name = "name", nullable = false, length = 150, unique = true)
    open var name: String? = null

    @Column(name = "area", nullable = false, precision = 10, scale = 2)
    open var area: BigDecimal? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    open var crop: Crop? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soil_id")
    open var soil: Soil? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    open var region: Region? = null
}