package services

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import models.{Client, DatabaseModel}

class ClientService @Inject()(databaseModel: DatabaseModel)(implicit ec: ExecutionContext) {
  import databaseModel._ // Import dbConfig and profile.api from DatabaseModel

  private class ClientTable(tag: Tag) extends Table[Client](tag, "clients") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def email = column[String]("email")
    def * = (id, name, email) <> ((Client.apply _).tupled, Client.unapply)
  }

  private val clients = TableQuery[ClientTable]

  def addClient(client: Client): Future[Unit] = db.run(clients += client).map(_ => ())
}
