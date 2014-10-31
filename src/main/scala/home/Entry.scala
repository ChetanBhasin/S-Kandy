package home

import PortScanner.Scanner._

object Entry {

  val usage: String = """
    SKandy: Usage Guide
    
    <run SKandy> -scanLocalForPort <port>	:
		  Scans a local network for a particular port on all IPs
		  Prints all the found IPs
    
    <run SKandy> -scanIPForPorts <IP>		:
		  Scans a particular IP for all the open ports
		  Prints all the open ports
    """

  // Print all the IPs having a port open
  def printPorts(IP: String, port: Int) = {
    val result = "Port " + port + " open at: " + IP
    println(result)
    result
  }

  // Print all the ports open by an IP
  def printIPs(IP: String, port: Int) = {
    val result = "IP " + IP + " has open port: " + port
    println(result)
    result
  }

  // Parse arguments and provide callbacks accordingly
  def parseAndRun(args: Array[String]) = {
    if (args(0) == "-scanLocalForPort") {
      execForLocalIPRange(args(1).toInt, printPorts)
    } else if (args(0) == "-scanIPForPorts") {
      execForAllPorts(args(1), printIPs)
    } else {
      // Wrong or inappropriate arguments, terminate with status 1 after printing usage
      println("Wrong or inappropriate arguments")
      println(usage)
      System.exit(0)
    }
  }

  // Main function to enter into the application 
  def main(args: Array[String]) = {
    if (args.length == 0 || args.length == 1) {
      // Not enough arguments, print the usage guide and exit with status 1
      println("Not enough arguments.")
      println(usage)
      System.exit(0)
    } else {
      parseAndRun(args)
    }

    println("")
  }

}