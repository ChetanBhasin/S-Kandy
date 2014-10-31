package PortScanner

import scala.concurrent.{ Future, Await }
import scala.concurrent.duration._
import scala.util.Try
import scala.concurrent._
import java.util.concurrent.Executors

object ScanCore {

  // Function to scan over a range of ports on an IP
  private[PortScanner] def scanForPorts(IP: String) = {

    // Defining the personal concurrent execution context thread pool
    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(200))

    // Main result value to store the data into
    val result = Future.traverse(1 to 6335) {
      port =>
        Future {
          Try {
            val socket = new java.net.Socket
            socket.connect(new java.net.InetSocketAddress(IP, port), 200)
            socket.close
            port
          }.toOption
        }
    }

    // Returns a vector of all available ports asynchronously
    Try {
      Await.result(result, 30 seconds)
    }.toOption.getOrElse(Nil).flatten
  }

  // Function to scan over a range of IP Address
  private[PortScanner] def scanForLocalIPs(port: Int) = {

    // Define the personal concurrent execution context thread pool
    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(230))

    // Main result value to store the data into
    val result = Future.traverse(1 to 227) {
      ipEnd =>
        Future {
          Try {
            val socket = new java.net.Socket()
            val currentIP = "192.168.1." + ipEnd
            socket.connect(new java.net.InetSocketAddress(currentIP, port), 200)
            socket.close()
            currentIP
          }.toOption
        }
    }

    // Returns a vector of all available IPs asynchronously
    Try {
      Await.result(result, 10 seconds)
    }.toOption.getOrElse(Nil).flatten
  }

}