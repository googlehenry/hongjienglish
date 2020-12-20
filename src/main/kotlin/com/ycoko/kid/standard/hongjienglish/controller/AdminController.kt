package com.ycoko.kid.standard.hongjienglish.controller

import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import com.ycoko.kid.standard.hongjienglish.service.LearnItemService
import javassist.expr.NewArray
import net.coobird.thumbnailator.Thumbnails
import net.coobird.thumbnailator.makers.ThumbnailMaker
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.charset.Charset
import java.util.*
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping("/admin")
class AdminController(var learnItemService: LearnItemService) {

    @GetMapping("/add")
    fun redirectToAdd(): String {
        return "newitem"
    }

    @PostMapping("/add")
    fun upload(request: MultipartHttpServletRequest): String {
        var idS = request.getParameter("id")
        var gradeS = request.getParameter("grade")
        var categoryS = request.getParameter("category")
        var nameS = request.getParameter("name")
        var localeS = request.getParameter("locale")
        var descriptionS = request.getParameter("description")

        //delete
        if (StringUtils.hasText(idS) &&
                !StringUtils.hasText(gradeS) &&
                !StringUtils.hasText(categoryS) &&
                !StringUtils.hasText(nameS) &&
                !StringUtils.hasText(localeS) &&
                !StringUtils.hasText(descriptionS)) {
            learnItemService.delete(LearnItem(id = idS))
        } else {

            //insert or update
            var item = LearnItem(if (!StringUtils.hasText(request.getParameter("id"))) UUID.randomUUID().toString() else idS,
                    gradeS.toInt(),
                    categoryS,
                    nameS,
                    localeS,
                    description = descriptionS,
                    image = null, audio = null, video = null)


            val image: MultipartFile? = request.getFile("image")
            val audio: MultipartFile? = request.getFile("audio")
            val video: MultipartFile? = request.getFile("video")

            var outS: ByteArrayOutputStream = ByteArrayOutputStream(2048)


            val imageToString = image?.let {
                Thumbnails.fromInputStreams(mutableListOf(it.inputStream)).size(128, 128).toOutputStream(outS);
                outS.toByteArray().let { Base64.getEncoder().encodeToString(it) }
            }
            val audioToString = audio?.inputStream?.readAllBytes()?.let { Base64.getEncoder().encodeToString(it) }
            val videoToString = video?.inputStream?.readAllBytes()?.let { Base64.getEncoder().encodeToString(it) }

            item.image = imageToString;
            item.audio = audioToString;
            item.video = videoToString;

            learnItemService.save(item)
        }
        return "newitem";
    }
}