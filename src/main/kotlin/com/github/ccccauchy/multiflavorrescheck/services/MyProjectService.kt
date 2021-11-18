package com.github.ccccauchy.multiflavorrescheck.services

import com.intellij.openapi.project.Project
import com.github.ccccauchy.multiflavorrescheck.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
