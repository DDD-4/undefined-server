package com.undefined.platz.repository

import com.undefined.platz.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
