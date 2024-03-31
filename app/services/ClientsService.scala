package services

import utils.dto.ClientDTO

import scala.concurrent.Future

trait ClientsService {
  def addClient(client: ClientDTO): Future[Any]
}
