package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.MySQLProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Clients.schema ++ Pets.schema ++ PlayEvolutions.schema ++ Veterinaries.schema

  /** Entity class storing rows of table Clients
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param lastname Database column lastname SqlType(VARCHAR), Length(255,true)
   *  @param phoneNumber Database column phone_number SqlType(VARCHAR), Length(20,true)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param numberOfVisits Database column number_of_visits SqlType(INT), Default(None)
   *  @param uniqueId Database column unique_id SqlType(VARCHAR), Length(10,true), Default(None) */
  case class ClientsRow(id: Int, name: String, lastname: String, phoneNumber: String, address: Option[String] = None, email: String, createdAt: java.sql.Timestamp, numberOfVisits: Option[Int] = None, uniqueId: Option[String] = None)
  /** GetResult implicit for fetching ClientsRow objects using plain SQL queries */
  implicit def GetResultClientsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp], e4: GR[Option[Int]]): GR[ClientsRow] = GR{
    prs => import prs._
    (ClientsRow.apply _).tupled((<<[Int], <<[String], <<[String], <<[String], <<?[String], <<[String], <<[java.sql.Timestamp], <<?[Int], <<?[String]))
  }
  /** Table description of table clients. Objects of this class serve as prototypes for rows in queries. */
  class Clients(_tableTag: Tag) extends profile.api.Table[ClientsRow](_tableTag, Some("test"), "clients") {
    def * = ((id, name, lastname, phoneNumber, address, email, createdAt, numberOfVisits, uniqueId)).mapTo[ClientsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(lastname), Rep.Some(phoneNumber), address, Rep.Some(email), Rep.Some(createdAt), numberOfVisits, uniqueId)).shaped.<>({r=>import r._; _1.map(_=> (ClientsRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get, _8, _9)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column lastname SqlType(VARCHAR), Length(255,true) */
    val lastname: Rep[String] = column[String]("lastname", O.Length(255,varying=true))
    /** Database column phone_number SqlType(VARCHAR), Length(20,true) */
    val phoneNumber: Rep[String] = column[String]("phone_number", O.Length(20,varying=true))
    /** Database column address SqlType(VARCHAR), Length(255,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true) */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column number_of_visits SqlType(INT), Default(None) */
    val numberOfVisits: Rep[Option[Int]] = column[Option[Int]]("number_of_visits", O.Default(None))
    /** Database column unique_id SqlType(VARCHAR), Length(10,true), Default(None) */
    val uniqueId: Rep[Option[String]] = column[Option[String]]("unique_id", O.Length(10,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Clients */
  lazy val Clients = new TableQuery(tag => new Clients(tag))

  /** Entity class storing rows of table Pets
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param clientId Database column client_id SqlType(INT)
   *  @param breed Database column breed SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param age Database column age SqlType(INT), Default(None)
   *  @param dateOfBirth Database column date_of_birth SqlType(DATE)
   *  @param petType Database column pet_type SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param allergies Database column allergies SqlType(TEXT)
   *  @param extraInformation Database column extra_information SqlType(TEXT) */
  case class PetsRow(id: Int, name: String, clientId: Int, breed: Option[String] = None, age: Option[Int] = None, dateOfBirth: java.sql.Date, petType: Option[String] = None, allergies: String, extraInformation: String)
  /** GetResult implicit for fetching PetsRow objects using plain SQL queries */
  implicit def GetResultPetsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[java.sql.Date]): GR[PetsRow] = GR{
    prs => import prs._
    (PetsRow.apply _).tupled((<<[Int], <<[String], <<[Int], <<?[String], <<?[Int], <<[java.sql.Date], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table pets. Objects of this class serve as prototypes for rows in queries. */
  class Pets(_tableTag: Tag) extends profile.api.Table[PetsRow](_tableTag, Some("test"), "pets") {
    def * = ((id, name, clientId, breed, age, dateOfBirth, petType, allergies, extraInformation)).mapTo[PetsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(clientId), breed, age, Rep.Some(dateOfBirth), petType, Rep.Some(allergies), Rep.Some(extraInformation))).shaped.<>({r=>import r._; _1.map(_=> (PetsRow.apply _).tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7, _8.get, _9.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column client_id SqlType(INT) */
    val clientId: Rep[Int] = column[Int]("client_id")
    /** Database column breed SqlType(VARCHAR), Length(100,true), Default(None) */
    val breed: Rep[Option[String]] = column[Option[String]]("breed", O.Length(100,varying=true), O.Default(None))
    /** Database column age SqlType(INT), Default(None) */
    val age: Rep[Option[Int]] = column[Option[Int]]("age", O.Default(None))
    /** Database column date_of_birth SqlType(DATE) */
    val dateOfBirth: Rep[java.sql.Date] = column[java.sql.Date]("date_of_birth")
    /** Database column pet_type SqlType(VARCHAR), Length(50,true), Default(None) */
    val petType: Rep[Option[String]] = column[Option[String]]("pet_type", O.Length(50,varying=true), O.Default(None))
    /** Database column allergies SqlType(TEXT) */
    val allergies: Rep[String] = column[String]("allergies")
    /** Database column extra_information SqlType(TEXT) */
    val extraInformation: Rep[String] = column[String]("extra_information")

    /** Foreign key referencing Clients (database name pets_ibfk_1) */
    lazy val clientsFk = foreignKey("pets_ibfk_1", clientId, Clients)(r => r.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table Pets */
  lazy val Pets = new TableQuery(tag => new Pets(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param hash Database column hash SqlType(VARCHAR), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(TIMESTAMP)
   *  @param applyScript Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param revertScript Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    (PlayEvolutionsRow.apply _).tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends profile.api.Table[PlayEvolutionsRow](_tableTag, Some("test"), "play_evolutions") {
    def * = ((id, hash, appliedAt, applyScript, revertScript, state, lastProblem)).mapTo[PlayEvolutionsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem)).shaped.<>({r=>import r._; _1.map(_=> (PlayEvolutionsRow.apply _).tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(VARCHAR), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(TIMESTAMP) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Length(16777215,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))

  /** Entity class storing rows of table Veterinaries
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true)
   *  @param city Database column city SqlType(VARCHAR), Length(100,true)
   *  @param state Database column state SqlType(VARCHAR), Length(100,true)
   *  @param country Database column country SqlType(VARCHAR), Length(100,true)
   *  @param phoneNumber Database column phone_number SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param website Database column website SqlType(VARCHAR), Length(255,true), Default(None) */
  case class VeterinariesRow(id: Int, name: String, address: String, city: String, state: String, country: String, phoneNumber: Option[String] = None, email: Option[String] = None, website: Option[String] = None)
  /** GetResult implicit for fetching VeterinariesRow objects using plain SQL queries */
  implicit def GetResultVeterinariesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[VeterinariesRow] = GR{
    prs => import prs._
    (VeterinariesRow.apply _).tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table veterinaries. Objects of this class serve as prototypes for rows in queries. */
  class Veterinaries(_tableTag: Tag) extends profile.api.Table[VeterinariesRow](_tableTag, Some("test"), "veterinaries") {
    def * = ((id, name, address, city, state, country, phoneNumber, email, website)).mapTo[VeterinariesRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(address), Rep.Some(city), Rep.Some(state), Rep.Some(country), phoneNumber, email, website)).shaped.<>({r=>import r._; _1.map(_=> (VeterinariesRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column address SqlType(VARCHAR), Length(255,true) */
    val address: Rep[String] = column[String]("address", O.Length(255,varying=true))
    /** Database column city SqlType(VARCHAR), Length(100,true) */
    val city: Rep[String] = column[String]("city", O.Length(100,varying=true))
    /** Database column state SqlType(VARCHAR), Length(100,true) */
    val state: Rep[String] = column[String]("state", O.Length(100,varying=true))
    /** Database column country SqlType(VARCHAR), Length(100,true) */
    val country: Rep[String] = column[String]("country", O.Length(100,varying=true))
    /** Database column phone_number SqlType(VARCHAR), Length(20,true), Default(None) */
    val phoneNumber: Rep[Option[String]] = column[Option[String]]("phone_number", O.Length(20,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column website SqlType(VARCHAR), Length(255,true), Default(None) */
    val website: Rep[Option[String]] = column[Option[String]]("website", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Veterinaries */
  lazy val Veterinaries = new TableQuery(tag => new Veterinaries(tag))
}
