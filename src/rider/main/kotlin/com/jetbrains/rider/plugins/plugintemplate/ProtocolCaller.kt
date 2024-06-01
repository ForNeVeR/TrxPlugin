package com.jetbrains.rider.plugins.plugintemplate

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.jetbrains.rider.plugins.plugintemplate.model.RdCallRequest
import com.jetbrains.rider.plugins.plugintemplate.model.templatePluginModel
import com.jetbrains.rider.projectView.solution

@Service(Service.Level.PROJECT)
class ProtocolCaller(private val project: Project) {

    suspend fun doCall(input: String): Int {
        val model = project.solution.templatePluginModel
        val request = RdCallRequest(input)
        val response = model.myCall.startSuspending(request)
        return response.myResult
    }
}
