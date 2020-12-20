package com.ycoko.kid.standard.hongjienglish.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "learn_item")
class LearnItem(
        @Id
        @Column(name = "id")
        var id: String,
        @Column(name = "grade")//1-12
        var grade: Int,
        @Column(name = "category")//amimal
        var category: String,
        @Column(name = "name")//apple,苹果
        var name: String,
        @Column(name = "locale")//en_us,zh_cn
        var locale: String,
        @Column(name = "image")
        var image: String,
        @Column(name = "audio")
        var audio: String,
        @Column(name = "video")
        var video: String,
        @Column(name = "description")
        var description: String


)