// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.app

import javax.swing.{Action, KeyStroke}
import javax.swing.text.TextAction

import org.nlogo.api.CompilerServices
import org.nlogo.core.I18N
import org.nlogo.ide.{AutoSuggestAction, CodeCompletionPopup, ShowUsageBox, ShowUsageBoxAction, JumpToDefinitionAction}
import org.nlogo.window.CodeEditor

import collection.JavaConversions._

class EditorFactory(compiler: CompilerServices) extends org.nlogo.window.EditorFactory {
  def newEditor(cols: Int, rows: Int, enableFocusTraversal: Boolean): CodeEditor =
    newEditor(cols, rows, enableFocusTraversal, null, false)

  def newEditor(cols: Int,
                rows: Int,
                enableFocusTraversal: Boolean,
                listener: java.awt.event.TextListener,
                isApp: Boolean): CodeEditor =
  {
    val font = new java.awt.Font(org.nlogo.awt.Fonts.platformMonospacedFont,
                                 java.awt.Font.PLAIN, 12)
    val colorizer = new org.nlogo.window.EditorColorizer(compiler)
    val codeCompletionPopup = new CodeCompletionPopup()
    val showUsageBox = new ShowUsageBox(compiler)
    val actions = Seq[Action](new ShowUsageBoxAction(showUsageBox), new JumpToDefinitionAction(showUsageBox))
    val actionMap = Map(
      KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK)
      -> new AutoSuggestAction("auto-suggest", codeCompletionPopup))

    class MyCodeEditor
    extends org.nlogo.window.CodeEditor(rows, cols, font, enableFocusTraversal,
                                        listener, colorizer, I18N.gui.get _, actionMap, actions)
    {
      override def focusGained(fe: java.awt.event.FocusEvent) {
        super.focusGained(fe)
        if(isApp && rows > 1)
          FindDialog.watch(this)
      }
      override def focusLost(fe: java.awt.event.FocusEvent) {
        super.focusLost(fe)
        if(isApp && !fe.isTemporary)
          FindDialog.dontWatch(this)
      }
    }
    new MyCodeEditor
  }
}
