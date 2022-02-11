package html

import scalatags.Text
import scalatags.Text.all.*

object Home {
  def apply(): Text.all.doctype = doctype("html")(html(body("hello world")))
}
