# Server-Music-Information-System-2.0
The server works similar to Server-Music-Information-System. But all configurations have been shifted to annotations

The StreamServer is responsible for streaming the mp3.The mp3 is streamed using expressMp3Server built using node's express module and using a single get method to stream the mp3 through the requested URL. The get method applies the proper header to the response and creates a read stream of mp3 file and pipes it to the response.

# Getting Started

Change the UPLOAD_PATH in track controller to absolute path to songs in StreamServer folder.

Add the database MusicInformationServer.sql to xampp.

Run the two servers like in the demo video.
