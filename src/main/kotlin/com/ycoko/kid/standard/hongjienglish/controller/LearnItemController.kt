package com.ycoko.kid.standard.hongjienglish.controller

import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import com.ycoko.kid.standard.hongjienglish.service.LearnItemService
import org.springframework.stereotype.Controller
import org.springframework.util.CollectionUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.servlet.http.HttpServletRequest


@Controller
class LearnItemController(var learnItemService: LearnItemService) {

    @GetMapping("/")
    fun show(request: HttpServletRequest): ModelAndView {
        var localeS = request.getParameter("locale")
        var items: Iterable<LearnItem>? = null
        items = if (StringUtils.hasText(localeS)) {
            learnItemService.getByLocale(localeS)
        } else {
            learnItemService.getAll()
        }

        items?.shuffled()
        var model = ModelAndView()
        model.addObject("items", items)
        model.viewName = "show"
        return model
    }
}