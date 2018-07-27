package com.improve_future.sparing_boot.presentation.task

import com.improve_future.sparing_boot.domain.task.Task
import org.springframework.ui.ModelMap

object TaskView {
    fun list(modelMap: ModelMap, taskList: List<Task>): String {
        return "a"
    }
}