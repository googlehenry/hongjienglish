package com.ycoko.kid.standard.hongjienglish.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "LEARN_ITEM")
class LearnItem(
        @Id
        @Column(name = "ID")
        var id: String,
        @Column(name = "GRADE")
        var grade: Int,
        @Column(name = "type")
        var type: String
)