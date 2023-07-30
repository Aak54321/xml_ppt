#XML TO PPT using Java
This project uses APACHE POI for converting xml to ppt        

For this you need Apache poi's binary artifacts, get it from here👉 [Apache POI](https://archive.apache.org/dist/poi/release/bin/)

* Download the any 5.x.x version (mine using 5.2.2)
* Clone or download this repo and create a folder in it
* Extract the contents of zip from apache poi
* Copy .jar files from root directory,lib,ooxml-lib to the created new folder
* Adding these archives to the build path and executing the code

  ~~~
  javac -cp "your_folder_name/*" XMLToPPTXConverter.java
  ~~~
  
For Windows:
  ~~~
  java -cp "your_folder_name/*;." XMLToPPTXConverter
  ~~~
For Bash:
  ~~~
  java -cp "your_folder_name/*:." XMLToPPTXConverter
  ~~~
