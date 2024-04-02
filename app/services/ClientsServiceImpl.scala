package services

import models.ClientModel
import utils.dto.ClientDTO

import javax.inject.Inject
import play.api.{Configuration, Logging}
import scala.concurrent.{ExecutionContext, Future}

class ClientsServiceImpl @Inject()(
                                  clientModel: ClientModel
                                  )(implicit executionContext: ExecutionContext, configuration: Configuration) extends ClientsService {

  def addClient(client: ClientDTO): Future[Any] = {
    val result: Any = "Client added successfully"
    Future.successful(result)
  }
}
