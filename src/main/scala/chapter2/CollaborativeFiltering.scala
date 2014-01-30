package chapter2

import scala.collection.immutable.Nil

object CollaborativeFiltering {

  type Rating = Map[String, Double]

  def minkowski(rating1: Rating, rating2: Rating, r: Double) = {
    val dist = rating1.foldLeft(0.0) { (a, rat) =>
      (if (rating2.isDefinedAt(rat._1))
        Math.pow(Math.abs(rat._2 - rating2(rat._1)), r)
      else 0) + a
    }
    Math.pow(dist, (1.0 / r))
  }

  def computeNearestNeighbor(username: String, users: Map[String, Rating]) = {
    users.foldLeft(List.empty[(Double, String)]) { (a, user) =>
      if (username != user._1)
        (minkowski(users(username), user._2, 1), user._1) :: a
      else a
    }.sortBy(_._1)
  }

}
