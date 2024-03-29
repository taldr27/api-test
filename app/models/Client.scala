package models

import play.api.libs.json._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}

case class Client(id: Long, name: String, email: String)

object Client {
  implicit val clientFormat: Format[Client] = Json.format[Client]
}
