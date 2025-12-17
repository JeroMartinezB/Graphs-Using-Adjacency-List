# Graphs-Using-Adjacency-List
Graphs can be used to represent many real-world problems. This program builds a graph and allows a user to explore and search that graph

The program reads in a set of edges from the text files provided and constructs a graph, represented internally using the
adjacency list data structure. Once the graph is constructed, the user picks a starting vertex and it
displays the list of vertices they may travel to. The user then enters the number of the vertex, moves to that
vertex, and the process repeats. If they enter a vertex that isn’t adjacent to the current vertex, a message is displayed 
saying the move isn’t valid and keeps them at the current vertex.

In addition to this, the graph also has a display functionality that displays the entire graph. Nothing
fancy, just displays a list of vertices, a colon, and then all the vertices adjacent to that vertex.

Finally, it implements a search method. This will let the user enter a value, then a search algorithm will
search the graph for it, starting at the current vertex, and then report if the value was found or not
on the graph.  

**Dataset**
Three different graph datasets are provided. The first value in these text files will be the number of
vertices. This number is then used to dynamically declare the size of the adjacency list.
After that, each line contains an edge, which is really just two vertices separated by a space.
