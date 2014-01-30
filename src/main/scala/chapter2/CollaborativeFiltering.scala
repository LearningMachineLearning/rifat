package chapter2

import common.DoubleOps._
import common.StringOps._

object CollaborativeFiltering {

  type Rating = Map[String, Double]

  def minkowski(rating1: Rating, rating2: Rating, r: Double) = {
    rating1.filterKeys(rating2.isDefinedAt)
      .foldLeft(0.0)((a, rating) =>
        ((rating._2 - rating2(rating._1)).abs ** r) + a) ** (1.0 / r)
  }

  def computeNearestNeighbor(username: String, users: Map[String, Rating]) = {
    users.filterKeys(username.notEquals)
      .foldLeft(List.empty[(Double, String)])((a, user) =>
        (minkowski(users(username), user._2, 1), user._1) :: a)
      .sortBy(_._1)
  }

}
