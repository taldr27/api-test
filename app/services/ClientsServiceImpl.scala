package services

import javax.inject.Inject
import models.Client
import scala.concurrent.Future

trait ClientsService {
  def addClient(client: Any): Future[Any]
}

class ClientsServiceImpl @Inject()(clientsRepository: Any) extends ClientsService {

  override def addClient(client: Any): Future[Any] = {
    val result: Any = "Client added successfully"
    Future.successful(result)
  }
}
