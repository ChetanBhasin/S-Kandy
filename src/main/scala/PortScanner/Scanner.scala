package PortScanner

import ScanCore._

object Scanner {
  
  // Execute the callback for all IPs on local network with certain port
  def execForLocalIPRange(port: Int, callback: (String, Int) => String) = {
    scanForLocalIPs(port).map {
      IP => callback(IP, port)
    }
  }
  
  // Execute the callback for all the open ports on an IP
  def execForAllPorts(IP: String, callback: (String, Int) => String) = {
    scanForPorts(IP).map {
      port => callback(IP, port)
    }
  }

}