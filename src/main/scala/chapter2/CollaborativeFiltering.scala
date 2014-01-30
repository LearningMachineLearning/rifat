package chapter2

object CollaborativeFiltering {

  type Rating = Map[String, Double]

  def minkowski(rating1: Rating, rating2: Rating, r: Double) = {
    val dist = rating1.foldLeft(0.0) {
      (a, rat) =>
        (if (rating2.isDefinedAt(rat._1))
          Math.pow(Math.abs(rat._2 - rating2(rat._1)), r)
        else 0) + a
    }
    Math.pow(dist, (1.0 / r))
  }

}
