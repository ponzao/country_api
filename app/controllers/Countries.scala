package controllers

import play.api._
import play.api.mvc._
import services.CountryService

object Countries extends Controller {
  
  def all = Action {
    Ok(CountryService.getAll())
  }
  
  def getById(id: String) = Action {
    CountryService.getById(id) match {
      case Some(country) => Ok(country)
      case None => NotFound
    }
  }
  
}