package com.ycoko.kid.standard.hongjienglish.dao

import com.ycoko.kid.standard.hongjienglish.entity.LearnItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface LearnItemDao : CrudRepository<LearnItem, String> {

}