package com.pdm0126.labo4.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pdm0126.labo4.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel () {
    private val _task = MutableStateFlow<MutableList<Task>> (mutableStateListOf())
    val task = _task.asStateFlow()

fun addTask(task: Task) {
    _task.value = _task.value.toMutableList().apply { add(task) } }

}