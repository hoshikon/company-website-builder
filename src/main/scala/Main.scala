import cats.effect.{ExitCode, IO, IOApp, Resource}
import com.typesafe.scalalogging.StrictLogging
import html.Home

import java.io.{File, FileOutputStream}
import java.nio.file.attribute.FileAttribute
import java.nio.file.{Files, Path, Paths}

object Main extends IOApp with StrictLogging {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      htmlPath <- IO(Paths.get("./html"))
      htmlDir <- createHtmlDir(htmlPath)
      index <- IO(Files.createFile(htmlPath.resolve("index.html")).toFile)
      html = Home()
      _ <- Resource.make(IO.blocking(new FileOutputStream(index)))(fos => IO.blocking(fos.close())).use(fos => IO(fos.write(html.render.getBytes())))
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
}
