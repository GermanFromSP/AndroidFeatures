package com.bignerdranch.android.undoredomanager

import java.util.Stack

data class Action(val execute: () -> Unit, val undo: () -> Unit)

class UndoRedoManager {
    private val undoStack = Stack<Action>()
    private val redoStack = Stack<Action>()

    fun doAction(action: Action) {
        action.execute()
        undoStack.push(action)
        redoStack.clear()
    }

    fun undo() {
        if (undoStack.isNotEmpty()) {
            val action = undoStack.pop()
            action.undo()
            redoStack.push(action)
        }
    }

    fun redo() {
        if (redoStack.isNotEmpty()) {
            val action = redoStack.pop()
            action.execute()
            undoStack.push(action)
        }
    }
}
