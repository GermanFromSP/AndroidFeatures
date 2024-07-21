package com.bignerdranch.android.undoredomanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/*
This class allows you to implement redo and undo logic.
Each action that needs to be repeated or undone is written as a lambda expression, allowing you to fine-tune each step.
*/

@Composable
fun UndoRedoExample() {
    val undoRedoManager = remember { UndoRedoManager() }
    var text by remember { mutableStateOf("Hello, World!") }

    Column {
        Text(text = text)

        Row {
            Button(
                onClick = {
                    val oldText = text
                    val newText = "New Action"
                    undoRedoManager.doAction(
                        Action(
                            execute = { text = newText },
                            undo = { text = oldText }
                        )
                    )
                }
            ) {
                Text("Do Action")
            }

            Button(onClick = { undoRedoManager.undo() })
            {
                Text("Undo")
            }

            Button(onClick = { undoRedoManager.redo() })
            {
                Text("Redo")
            }
        }
    }
}