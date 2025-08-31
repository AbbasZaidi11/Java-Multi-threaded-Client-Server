# Java Multi-threaded Client-Server

This is a simple **client-server application in Java** built for learning purposes.  
It demonstrates how to use `Socket` and `ServerSocket` with multiple threads.

---

## How It Works
- **Server**: Listens on port `8010`, accepts connections, and sends back a greeting.
- **Client**: Spawns 100 threads, each connects to the server, sends a message, and prints the response.

---

## Run Instructions
```bash
javac Server.java Client.java
java Server      # start the server
java Client      # run in another terminal
