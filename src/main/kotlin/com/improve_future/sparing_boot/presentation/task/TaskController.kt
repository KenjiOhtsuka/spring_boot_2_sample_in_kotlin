package com.improve_future.sparing_boot.presentation.task

import com.improve_future.sparing_boot.domain.task.Task
import com.improve_future.sparing_boot.domain.task.TaskRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("task")
class TaskController(
    private val taskRepository: TaskRepository
) {
//    @Autowired
//    private lateinit var taskRepository: TaskRepository

    @ResponseBody
    @GetMapping
    fun list(modelMap: ModelMap): String {
        return TaskView.list(modelMap, taskRepository.findAll())
    }

    @ResponseBody
    @GetMapping(produces = arrayOf("application/json"))
    fun listJson(): Map<String, Any?> {
        return TaskJsonView.list(taskRepository.findAll())
    }

    @PostMapping
    fun create(
        attributes: RedirectAttributes,
        @RequestParam name: String): String {
        val task = Task()
        task.name = name
        taskRepository.save(task)
        attributes.addFlashAttribute("success", "タスクを追加しました。")
        return "redirect:/task"
    }
}
