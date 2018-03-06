package models

import anorm._
import java.sql.SQLException
import java.sql.Date
import play.api.db._
import play.api.Play.current
import play.api.Logger
import controllers.routes
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter, ISODateTimeFormat}
import javax.inject._


/**
 * @param Id
 * @param name
 * @param price
 * @param imageLocation
 * @param color
 * @param material
 * @param dimensions
 * @param weight
 * @param currentStock
 * @param description
 */ 

case class Product(Id: Option[Long], name: String, price: Double, imageLocation: String, 
	color: String, material: String, dimensions: String, weight: Double, currentStock: Int, 
	description: String) {

	def create(implicit db:java.sql.Connection) = {
		println("######################################")
		SQL("""
			INSERT INTO product (name, price, imageLocation, color, material, 
			dimensions, weight, currentStock, description) VALUES ({name}, {price}, 
			{imageLocation}, {color}, {material}, {dimensions}, {weight}, 
			{currentStock}, {description});
			""").on(
			'name -> name, 'price -> price, 'imageLocation -> imageLocation, 
			'color -> color, 'material -> material, 'dimensions -> dimensions, 
			'weight -> weight, 'currentStock -> currentStock, 
			'description -> description).executeInsert()
	}
}