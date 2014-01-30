package chapter2

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner

import CollaborativeFiltering._

@RunWith(classOf[JUnitRunner])
class MinkowskiSpec extends FlatSpec with Matchers {

  // TODO: Create a fixture
  val users = Map(
    "Angelica" -> Map[String, Double](
      "Blues Traveler" -> 3.5,
      "Broken Bells" -> 2.0,
      "Norah Jones" -> 4.5,
      "Phoenix" -> 5.0,
      "Slightly Stoopid" -> 1.5,
      "The Strokes" -> 2.5,
      "Vampire Weekend" -> 2.0),
    "Bill" -> Map[String, Double](
      "Blues Traveler" -> 2.0,
      "Broken Bells" -> 3.5,
      "Deadmau5" -> 4.0,
      "Phoenix" -> 2.0,
      "Slightly Stoopid" -> 3.5,
      "Vampire Weekend" -> 3.0),
    "Chan" -> Map[String, Double](
      "Blues Traveler" -> 5.0,
      "Broken Bells" -> 1.0,
      "Deadmau5" -> 1.0,
      "Norah Jones" -> 3.0,
      "Phoenix" -> 5,
      "Slightly Stoopid" -> 1.0),
    "Dan" -> Map[String, Double](
      "Blues Traveler" -> 3.0,
      "Broken Bells" -> 4.0,
      "Deadmau5" -> 4.5,
      "Phoenix" -> 3.0,
      "Slightly Stoopid" -> 4.5,
      "The Strokes" -> 4.0,
      "Vampire Weekend" -> 2.0),
    "Hailey" -> Map[String, Double](
      "Broken Bells" -> 4.0,
      "Deadmau5" -> 1.0,
      "Norah Jones" -> 4.0,
      "The Strokes" -> 4.0,
      "Vampire Weekend" -> 1.0),
    "Jordyn" -> Map[String, Double](
      "Broken Bells" -> 4.5,
      "Deadmau5" -> 4.0,
      "Norah Jones" -> 5.0,
      "Phoenix" -> 5.0,
      "Slightly Stoopid" -> 4.5,
      "The Strokes" -> 4.0,
      "Vampire Weekend" -> 4.0),
    "Sam" -> Map[String, Double](
      "Blues Traveler" -> 5.0,
      "Broken Bells" -> 2.0,
      "Norah Jones" -> 3.0,
      "Phoenix" -> 5.0,
      "Slightly Stoopid" -> 4.0,
      "The Strokes" -> 5.0),
    "Veronica" -> Map[String, Double](
      "Blues Traveler" -> 3.0,
      "Norah Jones" -> 5.0,
      "Phoenix" -> 4.0,
      "Slightly Stoopid" -> 2.5,
      "The Strokes" -> 3.0))

  "Minkowski method" should "be able to calculate Manhattan distance" in {
    minkowski(users("Hailey"), users("Veronica"), 1) should be(2.0)
    minkowski(users("Hailey"), users("Jordyn"), 1) should be(7.5)
  }

  it should "be able to calculate Euclidean distance" in {
    minkowski(users("Hailey"), users("Veronica"), 2) should be(1.4142135623730951)
    minkowski(users("Hailey"), users("Jordyn"), 2) should be(4.387482193696061)
  }

  it should "be able to handle empty lists" in {
    minkowski(Map(), Map(), 1) should be(0)
    minkowski(Map(), Map(), 2) should be(0)
  }

  it should "return zero if there's not common interest" in {
    minkowski(users("Hailey"), Map(), 1) should be(0)
    minkowski(Map(), users("Jordyn"), 2) should be(0)
  }

}
