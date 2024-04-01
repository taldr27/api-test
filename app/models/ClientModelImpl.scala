//package models
//
//import utils.dto.ClientDTO
//
//import javax.inject.Inject
//import models.Tables.{Clients, ClientsRow}
//import scala.concurrent.{ExecutionContext, Future}
//import play.api.Play
//import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
//import slick.jdbc.JdbcProfile
//
//class ClientModelImpl @Inject()(
//                                 protected val dbConfigProvider: DatabaseConfigProvider
//                               )(implicit executionContext: ExecutionContext) extends ClientModel with HasDatabaseConfigProvider[JdbcProfile] {
//
////  import profile.api._
//
////  override def table: TableQuery[Client] = ???
////
////  override def getId(row: ClientRow): Int = row.id
////
////  override def active(row: Client): Rep[Boolean] = row.active
////
//  private val clients = TableQuery[Clients]
//  def getId(table: Clients): Rep[Int] = table.id
//  def add(client: ClientDTO): Future[Any] = {
//    val query = (clients returning clients.map(getId)) += client
//
//    db.run(query.transactionally)
////  val result: Any = "Client added successfusllyss"
////  Future.successful(result)
//  }
//
//}
