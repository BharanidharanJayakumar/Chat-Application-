
**Chat Application using Java Swing, AWT, and Socket Programming**


**Overview:**

This project is a simple yet functional chat application developed using Java's Swing and AWT libraries for the graphical user interface, combined with socket programming for real-time communication between clients. It demonstrates the principles of network programming and GUI development in Java.

**Features:**


**User Interface:** The application features a user-friendly interface created using Java Swing and AWT. Users can easily connect, send messages, and receive messages in real-time.

**Real-Time Communication:** The core of the application relies on socket programming, allowing multiple clients to connect to a server and exchange messages simultaneously.

**How It Works:**

**Server:** The server listens on a specific port for incoming client connections. Upon connection, it assigns a separate thread to handle communication with each client.
**Client:** Clients connect to the server by specifying the server's IP address and port number. Once connected, they can send and receive messages in real-time.
**Message Exchange:** Messages sent by a client are broadcasted to all other connected clients, simulating a group chat environment.


**Technologies Used:**


**Java Swing & AWT:** For creating the graphical user interface.
**Java Sockets:** For establishing network connections and enabling real-time communication.

**Installation and Usage:**

Clone the repository.
Compile and run the server program.
Compile and run the client program on multiple instances to simulate multiple users.
Enter the server's IP address and port in the client interface to connect and start chatting
