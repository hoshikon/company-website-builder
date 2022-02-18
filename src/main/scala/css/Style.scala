package css

import scalatags.stylesheet._
import scalatags.generic.Styles
import scalatags.Text.all._

object Style extends CascadingStyleSheet {
  initStyleSheet()

  val displayOverride: Cls = cls(
    span(
      fontWeight := "bold"
    )
  )
}
