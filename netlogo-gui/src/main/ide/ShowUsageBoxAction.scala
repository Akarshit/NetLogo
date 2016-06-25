// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.ide

import java.awt.event.{ActionEvent, MouseEvent}
import javax.swing.text.TextAction

import org.nlogo.editor.EditorArea

class ShowUsageBoxAction(showUsageBox: ShowUsageBox) {
  def actionPerformed(me: MouseEvent): Unit = {
    val editorArea = me.getSource.asInstanceOf[EditorArea]
    showUsageBox.init(editorArea)
    showUsageBox.showBox(me, editorArea.getCaretPosition)
  }
}
