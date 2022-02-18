import cats.effect.{ExitCode, IO, IOApp, Resource}
import com.typesafe.scalalogging.StrictLogging
import css.Style
import html.Home

import java.io.{File, FileOutputStream}
import java.nio.file.attribute.FileAttribute
import java.nio.file.{Files, Path, Paths}

object Main extends IOApp with StrictLogging {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      docsPath <- IO(Paths.get("./docs"))
      docsDir <- createHtmlDir(docsPath)
      index <- IO(Files.createFile(docsPath.resolve("index.html")).toFile)
      style <- IO(Files.createFile(docsPath.resolve("style.css")).toFile)
      html = Home("SamuraiDev")
      _ <- Resource.make(IO.blocking(new FileOutputStream(index)))(fos => IO.blocking(fos.close())).use(fos => IO(fos.write(html.render.getBytes())))
      _ <- Resource.make(IO.blocking(new FileOutputStream(style)))(fos => IO.blocking(fos.close())).use(fos => IO(fos.write(Style.styleSheetText.getBytes())))
      done = ExitCode.Success
    } yield done
  }

  private def createHtmlDir(path: Path): IO[File] = {
    val file = path.toFile

    for {
      cleared <- IO { if (file.exists()) (file.listFiles() :+ file).forall(_.delete()) else true }
      _ <- IO { if (cleared) logger.info(s"cleared ${path.getFileName} directory")  else () }
      _ <- IO { Files.createDirectory(path) }
    } yield file
  }

// breadcrumbs
// nav bar
// company name
// what we do
// and other stuff
// A Secure, High-performance, and Modular system for you.
}
