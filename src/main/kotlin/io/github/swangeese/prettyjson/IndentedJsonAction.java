//package io.github.swangeese.prettyjson;
//
//import com.intellij.openapi.actionSystem.AnAction;
//import com.intellij.openapi.actionSystem.AnActionEvent;
//import com.intellij.openapi.command.WriteCommandAction;
//import com.intellij.openapi.editor.Editor;
//import com.intellij.openapi.editor.SelectionModel;
//import com.intellij.openapi.ui.Messages;
//import org.codehaus.jettison.json.JSONObject;
//
///**
// * @auther swan-geese
// * @verison
// * @date 2024 02:48
// * @Description java 版本实现该插件，注意直接打开该类是无效的，因为读取的项目路径中不是src，而是kotlin开头的路径
// */
//public class IndentedJsonAction extends AnAction {
//    @Override
//    public void actionPerformed(AnActionEvent e) {
//        Editor editor = (Editor)e.getDataContext().getData("editor");
//        SelectionModel selectionModel = editor.getSelectionModel();
//        String selectedText = selectionModel.getSelectedText();
//
//        if (selectedText != null) {
//            try {
//                JSONObject jsonObject = new JSONObject(selectedText);
//                String indentedJson = jsonObject.toString();
//                WriteCommandAction.runWriteCommandAction(editor.getProject(), () -> {
//                    editor.getDocument().replaceString(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd(), indentedJson);
//                });
//            } catch (Exception ex) {
//                // 处理 JSON 解析错误
//                // 处理 JSON 解析错误
//                System.out.println("JSON 解析错误: " + ex.getMessage());
//                Messages.showErrorDialog("Invalid JSON data", "Error");
//            }
//        }
//    }
//}
