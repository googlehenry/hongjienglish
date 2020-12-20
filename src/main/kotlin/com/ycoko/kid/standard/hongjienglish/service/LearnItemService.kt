package com.ycoko.kid.standard.hongjienglish.service

import com.ycoko.kid.standard.hongjienglish.dao.LearnItemDao
import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import org.springframework.stereotype.Service

@Service
class LearnItemService(var learnItemDao: LearnItemDao) {

    fun getAll(): Iterable<LearnItem> {
        return learnItemDao.findAll()
    }

    fun getByLocale(locale: String): Iterable<LearnItem> {
        return learnItemDao.findByLocale(locale)
    }

    fun save(item: LearnItem) {
        learnItemDao.save(item)
    }

    fun delete(learnItem: LearnItem) {
        learnItemDao.delete(learnItem)
    }
}