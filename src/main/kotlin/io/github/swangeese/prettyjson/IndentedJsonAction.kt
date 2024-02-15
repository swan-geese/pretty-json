package io.github.swangeese.prettyjson

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.SelectionModel
import com.intellij.openapi.ui.Messages
import org.codehaus.jettison.json.JSONObject

/**
 *  @auther swan-geese
 *  @verison
 *  @date
 *
 *  @Description
 *
 */
class IndentedJsonAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val editor: Editor? = e.getDataContext().getData("editor") as Editor?
        val selectionModel: SelectionModel? = editor?.selectionModel
        val selectedText: String? = selectionModel?.selectedText

        selectedText?.let {
            try {
                val jsonObject = JSONObject(it)
                val indentedJson = jsonObject.toString()
                WriteCommandAction.runWriteCommandAction(editor.project) {
                    editor.document.replaceString(selectionModel.selectionStart, selectionModel.selectionEnd, indentedJson)
                }
            } catch (ex: Exception) {
                // 处理 JSON 解析错误
                println(ex.message)
                Messages.showErrorDialog("Invalid JSON data", "Error");
            }
        }
    }
}