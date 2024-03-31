package models

import utils.dto.ClientDTO

import scala.concurrent.Future

trait ClientModel {
  def add(client: ClientDTO): Future[Any]
}
//case class ClientModel(id: String, name: String, email: String, phoneNumber: String)
