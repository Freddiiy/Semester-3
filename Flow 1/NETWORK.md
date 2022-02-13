Fundamental Network Topics

Understanding Basic Network Terms like IP, TCP/IP, DNS, DHCP and more.
These exercises are meant to be answered with text, based on internet searches so write down your reply so you will remember for later.

- What is your public IP address right now, and how did you find it?

GOOGLE "What is my ip address"

- What is your private IP address right now (do this both at home and in school), and who/what gave you that address?
 in terminal:
  WIN: "ipconfig" and look at ipv4. Mine is 192.168.0.113. The last part is my identifier.
  
  MAC: "ipconfig getifaddr en0" en0 is wireless, en1 is wired. Maybe opposite.

- What’s special about these address ranges?
  - 10.0.0.0 – 10.255.255.255
   Class A Range reserved for huge networks like ISP and datacenters. Can hold 16 mio hosts.
   
  - 172.16.0.0 – 172.31.255.255 
    Class B range Reserved for medium to large interprises and organisations.
    
  - 192.168.0.0 – 192.168.255.255
    For private networks and the last part is for identifying devices on the network.
 
- What’s special about this ip-address: 127.0.0.1?
  its localhost

- What kind of service would you expect to find on a server using these ports: 22, 23, 25, 53, 80, 443?
  22 = SSH
  23 = TCP/UDP
  25 = SMTP/email relay
  53 = DNS Query
  80 = http
  443 = https/ssl

- What is the IP address of studypoints.info and how did you find it?
  domain doesnt have an ip.
  You can find it by googling a DNS lookup or by pinging it from terminal

- If you write https://studypoints.info in your browser, how did “it” figure out that it should go to the IP address you discovered above?
  It sends it to a DNS and then that has the address mapped to the IP and routes my request to that.

- Explain shortly the purpose of an ip-address and a port-number and why we need both
  ip is like an address. The IP is my address and the port is my floor and side.
  The ip is the general address and the port is there so we can assign more connections on the same address.

- What is your (nearest) DNS server?
 

- What is (conceptually) the DNS system and the purpose with a DNS Server?
  To translate Facebook.com into an IPAddress so we dont have to remember all ipaddresses.

- What is your current Gateway, and how did you find it
  WIN: ipconfig.
  MAC: netstat -nr | grep default

- What is the address of your current DHCP-Server, and how did you find it?
  my local network 192.168.0.1
  WIN: ipconfig /all
  MAC: ipconfig getpacket en0

- Explain (conceptually) about the TCP/IP-protocol stack
  end to end connection between to devices. Tells them how to talk to each other.

- Explain about the HTTP Protocol (the following exercises will go much deeper into this protocol)
  For fetching resources as HTTP file.

- Explain (conceptually) how HTTP and TCP/IP are connected (what can HTTP do, and where does it fit into TCP/IP
  TCP is the handshake and tells the connection to use HTTP.
