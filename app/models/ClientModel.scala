package models

import models.Tables.ClientsRow

import scala.concurrent.Future
import com.google.inject.ImplementedBy

@ImplementedBy(classOf[ClientModelImpl])
trait ClientModel {
  def add(client: ClientsRow): Future[Int]
}
