package com.ycoko.kid.standard.hongjienglish.controller

import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import com.ycoko.kid.standard.hongjienglish.service.LearnItemService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hongji/english")
class LearnItemController(var learnItemService: LearnItemService) {

    @GetMapping("/get/all")
    fun getAll(): Iterable<LearnItem> {
        return learnItemService.getAll()
    }
}