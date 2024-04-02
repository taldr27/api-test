package models

import utils.dto.ClientDTO

import javax.inject.Inject
import models.Tables.{Clients, ClientsRow}
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class ClientModelImpl @Inject()(
                                 protected val dbConfigProvider: DatabaseConfigProvider
                               )(implicit executionContext: ExecutionContext) extends ClientModel with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val clients = Tables.Clients

  def getId(table: Clients): Rep[Int] = table.id

  def add(client: ClientsRow): Future[Int] = {
    val query = (clients returning clients.map(getId)) += client

    db.run(query.transactionally)
  }
}
