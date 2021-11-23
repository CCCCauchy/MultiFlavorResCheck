package com.github.ccccauchy.multiflavorrescheck.listeners

import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileDeleteEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent


class FileChangedListener : BulkFileListener {

    override fun before(events: MutableList<out VFileEvent>) {
        events.forEach {
            if (it is VFileDeleteEvent && it.file.name.contains(".java")) {
                println("声明式注册 file delete... ${it.file.name}")
            }
        }

    }
}