package services

import play.api.libs.json.Json
import play.api.libs.json.JsValue
import play.api.libs.json.JsArray

object CountryService {
  val data: JsValue = {
    val source = scala.io.Source.fromFile("countries.json")
    val lines = source.mkString
    source.close()
    Json.parse(lines)
  }
  
  def getAll(): JsValue = {
    data
  }
  
  def getById(id: String): Option[JsValue] = {
    val coll = data.as[Seq[JsValue]]
    coll.filter { x =>
      val currId = x \ "cca3"
      currId.as[String].equalsIgnoreCase(id)
    }.headOption
  }
}
