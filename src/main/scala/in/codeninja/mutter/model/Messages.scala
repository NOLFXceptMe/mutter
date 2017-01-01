package in.codeninja.mutter.model

import akka.actor.ActorSelection

/**
  * Created by naveen on 31/12/16.
  */
object Messages {
  case object ServerBoot
  case class ClientBoot(serverRef: ActorSelection)

  case class ClientConnect(name: String)
  case class ClientDisconnect(name: String)

  case class Message(msg: String)
}
