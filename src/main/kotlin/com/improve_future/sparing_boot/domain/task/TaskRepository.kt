package com.improve_future.sparing_boot.domain.task

import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long>