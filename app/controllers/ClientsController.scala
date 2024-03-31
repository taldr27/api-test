package controllers

import play.api.mvc.*
import play.api.libs.json.*
import services.ClientsServiceImpl
import utils.dto.ClientDTO

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ClientController @Inject()(
  override val controllerComponents: ControllerComponents,
  val clientsService: ClientsServiceImpl
)(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

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
