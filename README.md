# XML-PARSER 
a compiler for xml (extensible mark-up language) . 
The XML files, or strings are converted to NaryTree<XMLElement> structures upon iteration . 
The NaryTreeNode<XMLElement> structure is then converted to XMLCore Object .  

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

- To harness the functionality of this API , 
- Instantiate the XMLParser class ;
- XMLParser  compiler = new XMLParser()  ;
- Then  create  an XMLCore by calling the method  (public  XMLCore parse(String source) ) ;
 - String value  =  new String (" <xml><element attribute=value></element></xml> ") ;
- XMLCore central =  compiler.parse(value) ;  
-To append a child Node to the XMLCore structure that  is returned ;
  -call the  (public void appendNode(String tag,String content ) ) method ; 
- central.appendNode("tag","content")  ;
- Now rebuild the String by calling the rebuild method  ( public static String rebuild (XMLCore creator) ) ;
- String gains = XMLCore.rebuild(central ) ;
- System.out.println(gains)  ; 
- To add a Node at any position in the array of the XMLCore object ;
- call the (public void  setNodeAt(int position,String element,String internal) method ;
- central.setNodeAt(0,"alter","text") ;
- String  second = XMLCore.rebuild(central ) ;
- central.setNodeAt(1,"added","text") ;
- String  third = XMLCore.rebuild(central ) ;
- Now to remove a child node from an XMLCore object  at a position , use the  (public void detachNode(int position) ) method  ;
- central.detachNode(2) ;
- Now rebuild the String to check the changes that have been made ;
- String fourth = XMLCore.rebuild(central) ;
- System.out.println(fourth ) ; 
