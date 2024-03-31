package utils.dto

import play.api.libs.json.{Format, Json}

case class ClientDTO(
                      name: String,
                      email: String,
                      phoneNumber: String
                    )

object ClientDTO {
  implicit val format: Format[ClientDTO] = Json.format[ClientDTO]
}
