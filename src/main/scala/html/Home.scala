package html

import css.Style
import scalatags.Text
import scalatags.Text.all.*

object Home {
  private val BOOTSTRAP_LINK: String = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
  private val BOOTSTRAP_LINK_INTEGRITY = "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"

  private val section = tag("section")
  private val nbsp = raw("&nbsp;")

  def apply(companyName: String): Text.all.doctype = {

    doctype("html")(
      html(lang := "en",
        head(
          meta(charset := "utf-8"),
          meta(name := "viewport", content := "width=device-width, initial-scale=1, shrink-to-fit=no"),
          tag("title")(companyName),
          link(
            rel := "stylesheet",
            href := BOOTSTRAP_LINK,
            integrity := BOOTSTRAP_LINK_INTEGRITY,
            crossorigin := "anonymous"
          ),
          link(
            rel := "stylesheet",
            href := "style.css",
            crossorigin := "anonymous"
          )
        ),
        body(
          tag("main")(role := "main",
            section(`class` := "jumbotron text-center",
              div(`class` := "container",
                h1(`class` := "display-1", companyName)
              )
            ),
            div(`class` := "container", Style.displayOverride,
              div(`class` := "row text-right display-4",
                "A",
                nbsp,
                span(`class` := "text-primary", "Secure"),
                ","
              ),
              div(`class` := "row text-right display-4",
                span(`class` := "text-primary", "Hight-performace")
              ),
              div(`class` := "row text-right display-4",
                "and",
                nbsp,
                span(`class` := "text-primary", "Modular")
              ),
              div(`class` := "row text-right display-4",
                "solution, for",
                nbsp,
                span("YOU"),
                "."
              ),
              br,
              div(`class` := "row"
              )
            )
          )
        )))
  }
}
