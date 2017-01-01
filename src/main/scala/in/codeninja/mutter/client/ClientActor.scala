package in.codeninja.mutter.client

import akka.actor.{Actor, ActorLogging, ActorSelection}
import in.codeninja.mutter.model.Messages.{ClientBoot, Message}

/**
  * Created by naveen on 31/12/16.
  */
class ClientActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case ClientBoot(serverRef: ActorSelection) => {
      log.info("Client booted")
      log.info(s"Connecting to ${serverRef.anchorPath}")
    }

    case Message(msg: String) => log.info(msg)
    case _ => log.info("Unknown message from server")
  }
}
