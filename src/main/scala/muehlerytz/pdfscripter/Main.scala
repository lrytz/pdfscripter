package muehlerytz.pdfscripter

import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.PdfStamper

import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader

object Main {
  def main(args: Array[String]) {
    val infile = args(0)
    val outfile = args(1)
    
    val reader = new PdfReader(infile)
    val stamper = new PdfStamper(reader, new FileOutputStream(outfile))
    stamper.addJavaScript(getScript())
    // println(getScript())
    stamper.close()
    reader.close()
  }
  
  def getScript() = {
    val stream = getClass.getResourceAsStream("/script.js")
    val source = scala.io.Source.createBufferedSource(stream)
    val res = source.mkString
    source.close()
    res
  }
}
