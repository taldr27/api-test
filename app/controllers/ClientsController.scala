package controllers

import play.api.mvc._
import play.api.libs.json._

import services.ClientsServiceImpl
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

case class ClientDTO(
                       name: String,
                       email: String,
                       phoneNumber: String
                     )

object ClientDTO {
  implicit val format: Format[ClientDTO] = Json.format[ClientDTO]
}

class ClientController @Inject()(
                                  cc: ControllerComponents,
                                  val clientsService: ClientsServiceImpl
                                )(implicit executionContext: ExecutionContext) extends AbstractController(cc) {

  def addClient: Action[JsValue] = Action.async(parse.json) { implicit request =>
    request.body.validate[ClientDTO].fold(
      errors => {
        Future.successful(BadRequest(Json.obj("message" -> "Invalid JSON")))
      },
      client => {
        clientsService.addClient(client).map { _ =>
          Ok(Json.obj("message" -> "Client added successfully"))
        }.recover {
          case _: Exception => InternalServerError(Json.obj("message" -> "Failed to add client"))
        }
      }
    )
  }
}
