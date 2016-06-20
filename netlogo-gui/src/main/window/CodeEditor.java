// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.window;

import window.ShowUsageBox;

public strictfp class CodeEditor
    extends org.nlogo.editor.EditorArea {
  public CodeEditor(int rows, int columns,
                    java.awt.Font font,
                    boolean disableFocusTraversalKeys,
                    java.awt.event.TextListener listener,
                    org.nlogo.editor.Colorizer colorizer,
                    scala.Function1<String, String> i18n) {
    super(rows, columns, font, disableFocusTraversalKeys,
            listener, colorizer, i18n, null);
  }
  public CodeEditor(int rows, int columns,
                    java.awt.Font font,
                    boolean disableFocusTraversalKeys,
                    java.awt.event.TextListener listener,
                    org.nlogo.editor.Colorizer colorizer,
                    scala.Function1<String, String> i18n, ShowUsageBox showUsageBox) {
    super(rows, columns, font, disableFocusTraversalKeys,
        listener, colorizer, i18n, showUsageBox);
  }
}
