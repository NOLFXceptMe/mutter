package in.codeninja.mutter.client

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import in.codeninja.mutter.model.Messages.{ClientBoot, ClientConnect}

import scala.util.Random

/**
  * Created by naveen on 31/12/16.
  */
object MutterClient extends App {
  val system = ActorSystem("mutter", ConfigFactory.load("client.conf"))

  val clientConf = ConfigFactory.load("client.conf").getConfig("mutter")
  val serverAddr = clientConf.getString("server.address")
  val serverPort = clientConf.getString("server.port")

  val server = system.actorSelection(s"akka.tcp://mutter@$serverAddr:$serverPort/user/server")

  val clientId = s"client-${Random.alphanumeric.take(4).mkString}"
  val clientActor = system.actorOf(Props[ClientActor], name = clientId)
  clientActor ! ClientBoot(server)

  server.tell(ClientConnect(clientId), clientActor)
}
