package com.ycoko.kid.standard.hongjienglish.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "learn_item")
data class LearnItem(
        @Id
        @Column(name = "id")
        var id: String = UUID.randomUUID().toString(),
        @Column(name = "grade")//1-12
        var grade: Int = 1,
        @Column(name = "category")//amimal
        var category: String = "",
        @Column(name = "name")//apple,苹果
        var name: String = "",
        @Column(name = "locale")//en_us,zh_cn
        var locale: String = "zh_CN",
        @Column(name = "image")
        var image: String? = null,
        @Column(name = "audio")
        var audio: String? = null,
        @Column(name = "video")
        var video: String? = null,
        @Column(name = "description")
        var description: String? = ""


)