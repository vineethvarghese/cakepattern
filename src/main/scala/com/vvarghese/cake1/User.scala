package com.vvarghese.cake1

case class User(firstName: String, lastName: String, age: Int)

trait UserRepositoryComponent {
  val userRepository: UserRepository

  trait UserRepository {

    def create(user: User): Unit

    def delete(user: User): Unit
  }
}

trait UserRepositoryComponentImpl extends UserRepositoryComponent {

  override val userRepository = new UserRepositoryImpl

  private class UserRepositoryImpl extends UserRepository {
    override def create(user: User): Unit = println("UserRepositoryImpl.create")

    override def delete(user: User): Unit = println("UserRepositoryImpl.delete")
  }
}

trait UserServiceComponent {
  val userService: UserService

  trait UserService {

    def create(user: User): Unit
    def delete(user: User): Unit

  }
}

trait UserServiceComponentImpl extends UserServiceComponent {
  self: UserRepositoryComponent =>

  override val userService = new UserServiceImpl

  private class UserServiceImpl extends UserService {
    override def create(user: User): Unit = userRepository.create(user)

    override def delete(user: User): Unit = userRepository.delete(user)
  }

}

trait Components extends UserRepositoryComponentImpl with UserServiceComponentImpl



