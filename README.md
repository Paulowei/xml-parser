# XML-PARSER 
a compiler for xml (extensible mark-up language) . 
The XML files, or strings are converted to NaryTree<XMLElement> structures upon iteration . 
The NaryTreeNode structure is then converted to XMLCore Object .  

- Remember to install maven before trying to compile this project  ; 
-The project was built, and also compiled with Java SE 17 , so please try to install Java SE 17 ; 
- To compile this project .class files ; 
- Use the following command ; 
- mvn compile  
- Now to package the .class files  ;
- Use the following command ;
- mvn package ;

- In order to test/use the .jar package ;
- change directories to the package folder ;
- On windows cmd , use the following command ;
- cd target ;
- now there are four options for the parsing of the XML source  ;
- To read from a file and  write to a file , use the following command ;
- java -jar "xml-parser-2.4.jar" "FileStream_FileStream" "InFile.txt" "OutFile.txt" "<xml><element attribute=value></element></xml>"
- To read from a file and write to the terminal  , use the following command ; 
- java -jar "xml-parser-2.4.jar" "FileStream_Terminal" "InFile.txt" "<xml><element attribute=value></element></xml>"
- To read from the terminal and write to a file , use the following command ; 
- java -jar "xml-parser-2.4.jar" "Terminal_FileStream"  "OutFile.txt" "<xml><element attribute=value></element></xml>"
- To read from the terminal,and write to the terminal,use the following command ; 
- java -jar "xml-parser-2.4.jar" "Terminal_Terminal" "<xml><element attribute=value></element></xml>"

- The result is the string representation of the root node of the xml parse-tree , 
- Then the string representing a Map<String,List<XMLCore>> that connects each string tag with a list of XMLCore objects with that tag ; 
- and finally , a nested list (List<List<XMLCore>>) of the Level Order Traversal representation of the XML parse-tree ; 

- The result of any of the above commands at the respective destinations is ; 
-  xml::{}
{element=[element::{attribute=[value]}], xml=[xml::{}]}
[[xml::{}], [element::{attribute=[value]}]]
