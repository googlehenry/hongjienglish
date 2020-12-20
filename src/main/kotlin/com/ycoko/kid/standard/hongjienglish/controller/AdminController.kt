package com.ycoko.kid.standard.hongjienglish.controller

import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import com.ycoko.kid.standard.hongjienglish.service.LearnItemService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.io.File
import java.nio.charset.Charset
import java.util.*
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/admin")
class AdminController(var learnItemService: LearnItemService) {

    @PostMapping("/add")
    fun upload(request: MultipartHttpServletRequest) {
        var item = LearnItem(UUID.randomUUID().toString(), request.getParameter("grade").toInt(),
                request.getParameter("category"),
                request.getParameter("name"),
                request.getParameter("locale"),
                description = request.getParameter("description"),
                image = null, audio = null, video = null)

        val image: MultipartFile? = request.getFile("image")
        val audio: MultipartFile? = request.getFile("audio")
        val video: MultipartFile? = request.getFile("video")

        val imageToString = image?.inputStream?.readAllBytes()?.let { Base64.getEncoder().encodeToString(it) }
        val audioToString = audio?.inputStream?.readAllBytes()?.let { Base64.getEncoder().encodeToString(it) }
        val videoToString = video?.inputStream?.readAllBytes()?.let { Base64.getEncoder().encodeToString(it) }

        item.image = imageToString;
        item.audio = audioToString;
        item.video = videoToString;

        learnItemService.save(item)
    }
}