# Server-Music-Information-System-2.0
All configurations have been shifted to annotations

The StreamServer is responsible for streaming the mp3.The mp3 is streamed using expressMp3Server built using node's express module and using a single get method to stream the mp3 through the requested URL. The get method applies the proper header to the response and reads the mp3 file into a read stream and pipes it to the request.

# Getting Started

Change the UPLOAD_PATH in track controller to absolute path to songs in StreamServer folder.

Add the database MusicInformationServer.sql to xampp.

Run the two servers like in the demo video.
