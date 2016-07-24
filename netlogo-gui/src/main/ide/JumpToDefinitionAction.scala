// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.ide

import java.awt.event.ActionEvent
import javax.swing.{AbstractAction, Action}

import org.nlogo.editor.EditorArea

class JumpToDefinitionAction(showUsageBox: ShowUsageBox) extends AbstractAction {
  putValue(Action.NAME, "Jump to definition")
  def actionPerformed(e: ActionEvent): Unit = {
    val editorArea = getValue("editor").asInstanceOf[EditorArea]
    val cursorLocation = getValue("cursorLocation").asInstanceOf[Int]
    showUsageBox.init(editorArea)
    showUsageBox.jumpToDeclaration(cursorLocation)
  }
}
