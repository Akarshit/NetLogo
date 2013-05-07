// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.api

// What kind of object is stored in the value slot is will vary depending on the token type.  If the
// type is COMMAND or REPORTER, a Command or Reporter object will be stored.  If the type is
// Literal, the value of the literal is stored (a String or Integer or Double or LogoList or
// whatever).  And so on.  For some tokens, it will be null, for example for OpenBrace and so on.

// There are two argument lists because we won't need to pattern match on the position or filename;
// they're auxiliary information.  Also we don't want them in the toString output either since it
// makes test cases annoying to write.

object Token {
  val eof = new Token("", TokenType.EOF, "")(0, 0, "")
}
case class Token(name: String, tpe: TokenType, value: AnyRef)
                (val start: Int, val end: Int, val fileName: String) {
  // the automatically generated `copy` method wouldn't copy the auxiliary fields
  def copy(name: String = name, tpe: TokenType = tpe, value: AnyRef = value): Token =
    new Token(name, tpe, value)(start, end, fileName)
}
