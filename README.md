Marvellous File Packer & Unpacker
================================

Project Description:
--------------------
This project is a Java-based File Packer and Unpacker utility.
It packs multiple files from a directory into a single file and
later unpacks them back to their original form.

The project is implemented using Core Java concepts such as
File Handling, Byte Streams, and Object-Oriented Programming.

Files Included:
---------------
1) MarvellousPacker.java
   - Used to pack multiple files into a single packed file.
   - Reads files from a directory.
   - Stores file name, file size, and file data sequentially.

2) MarvellousUnpacker.java
   - Used to unpack the packed file.
   - Extracts original files using stored metadata.

How Packing Works:
------------------
- Reads all files from the given directory
- Writes file name, file size, and file data into one file

How Unpacking Works:
--------------------
- Reads packed file sequentially
- Extracts file name and file size
- Recreates original files with exact content

How to Compile:
---------------
javac MarvellousPacker.java
javac MarvellousUnpacker.java

How to Run:
-----------
Packing:
java MarvellousPacker <DirectoryName> <PackedFileName>

Example:
java MarvellousPacker Demo packed.txt

Unpacking:
java MarvellousUnpacker <PackedFileName>

Example:
java MarvellousUnpacker packed.txt

Technologies Used:
------------------
- Java (Core Java)
- File Handling
- Byte Stream I/O
- OOP Concepts

Purpose:
--------
- Educational project
- Understanding file system internals
- Interview and academic demonstration

Author:
-------
Ujjwal Patil
Computer Engineering Student
