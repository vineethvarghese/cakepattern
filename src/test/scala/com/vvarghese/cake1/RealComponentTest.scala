package com.vvarghese.cake1

import org.scalatest._

class RealComponentTest extends FlatSpec with Matchers with Components{

  "UserComponents" should "be able to create a user" in {
    userService.create(User("Bruce", "Wayne", 36))
  }

  it should "also be able to delete a user" in {
    userService.delete(User("Bruce", "Wayne", 36))
  }
}
