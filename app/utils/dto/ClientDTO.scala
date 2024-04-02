package utils.dto

import play.api.libs.json.{Format, Json}

case class ClientDTO(
                      name: String,
                      lastname: String,
                      phoneNumber: String,
                      address: Option[String],
                      email: String,
                      numberOfVisits: Option[Int],
                      unique_id: String
                    )

object ClientDTO {
  implicit val format: Format[ClientDTO] = Json.format[ClientDTO]
}
