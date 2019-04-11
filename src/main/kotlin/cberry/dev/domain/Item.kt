package cberry.dev.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @NotNull
    @Column(name = "title", nullable = false)
    val title: String = "",

    @Column(name = "body")
    val body: String = ""
)