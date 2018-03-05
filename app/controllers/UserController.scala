package controllers

import javax.inject._
import play.api.db._
import play.api.mvc._
import anorm._
import models._


@Singleton
class UserController @Inject()(db: Database, cc: ControllerComponents) extends AbstractController(cc) {

  def create = Action {
  	implicit val conn = db.getConnection()
  	//val user = User().create
  	println("*********************************************************")
  	conn.close()
  	Ok
  }

}