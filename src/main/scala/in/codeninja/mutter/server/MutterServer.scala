package in.codeninja.mutter.server

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import in.codeninja.mutter.model.Messages.ServerBoot

/**
  * Created by naveen on 31/12/16.
  */
object MutterServer extends App {
  val system = ActorSystem("mutter", ConfigFactory.load("server.conf"))
  val serverActor = system.actorOf(Props[ServerActor], name = "server")

  serverActor ! ServerBoot
}
