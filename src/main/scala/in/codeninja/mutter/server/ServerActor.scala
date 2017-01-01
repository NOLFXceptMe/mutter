package in.codeninja.mutter.server

import akka.actor.{Actor, ActorLogging}

import in.codeninja.mutter.model.Messages._

/**
  * Created by naveen on 31/12/16.
  */
class ServerActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case ServerBoot => log.info("Server boot!")

    case ClientConnect(name) => {
      log.info(s"Client $name has registered")
      sender ! Message(s"Hi $name. Welcome to the chat room")
    }

    case ClientDisconnect(name) => log.info(s"Client $name has disconnected")
    case _ => log.info("Unknown message is received")
  }
}
