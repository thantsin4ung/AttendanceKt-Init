package com.soft.attendancekt.model.repo

import com.soft.attendancekt.model.dao.MemberDao
import com.soft.attendancekt.model.entity.Member

class MemberRepo(private val dao: MemberDao) {

    fun save(m: Member) {
        if (m.id > 0) {
            dao.update(m)
        } else {
            dao.insert(m)
        }
    }

    fun getMember(id: Int) = dao.getMember(id)

    fun getAll() = dao.getAll()

}