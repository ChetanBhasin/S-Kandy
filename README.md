SKandy
======

SKandy is a network-port scanner for scanning local and wide area networks for a particular port or a port range.

Following is the command line argument syntax for running SKandy where `<run SKandy>` is the command for running the application.
Say for example it can be `sbt run "<command line arguments>"` to run SKandy with SBT.

   
    <run SKandy> -scanLocalForPort <port>	:
    Scans a local network for a particular port on all IPs
    Prints all the found IPs
    
    <run SKandy> -scanIPForPorts <IP>		:
    Scans a particular IP for all the open ports
    Prints all the open ports
