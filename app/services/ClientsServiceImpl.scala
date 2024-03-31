package services

import utils.dto.ClientDTO

import javax.inject.Inject
import scala.concurrent.Future

class ClientsServiceImpl @Inject()() extends ClientsService {

  def addClient(client: ClientDTO): Future[Any] = {
    val result: Any = "Client added successfully"
    Future.successful(result)
  }
}
