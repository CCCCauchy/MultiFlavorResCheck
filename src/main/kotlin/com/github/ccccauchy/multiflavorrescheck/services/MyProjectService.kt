package com.github.ccccauchy.multiflavorrescheck.services

import com.github.ccccauchy.multiflavorrescheck.MyBundle
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileDeleteEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent

class MyProjectService(val project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))

        registerEventBus()
    }

    private fun registerEventBus() {
        val connection = project.messageBus.connect()
        connection.subscribe(VirtualFileManager.VFS_CHANGES, object : BulkFileListener {

            override fun before(events: MutableList<out VFileEvent>) {
                events.forEach {
                    if (it is VFileDeleteEvent && it.file.name.contains(".java")) {
                        println("监听式注册 file delete... ${it.file.name}")
                        sendNotification(it.file.name)
                        showDialog(it.file.name)
                    }
                }
            }
        })
    }

    private fun sendNotification(message: String) {
        NotificationGroupManager.getInstance().getNotificationGroup("Custom Notification Group")
            .createNotification(message, NotificationType.INFORMATION)
            .notify(project)
    }

    private fun showDialog(message: String) {
        SampleDialogWrapper(message).showAndGet()
    }
}
