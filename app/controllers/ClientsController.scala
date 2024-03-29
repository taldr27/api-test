package controllers

import play.api.mvc._
import play.api.libs.json._
import models.Client
import services.ClientsServiceImpl

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ClientController @Inject()(
                                  cc: ControllerComponents,
                                  val clientService: ClientsServiceImpl
                                )(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def addClient: Action[JsValue] = Action.async(parse.json) { implicit request =>
    request.body.validate[Client].fold(
      errors => {
        Future.successful(BadRequest(Json.obj("message" -> "Invalid JSON")))
      },
      client => {
        clientService.addClient(client).map { _ =>
          Ok(Json.obj("message" -> "Client added successfully"))
        }.recover {
          case _: Exception => InternalServerError(Json.obj("message" -> "Failed to add client"))
        }
      }
    )
  }
}
