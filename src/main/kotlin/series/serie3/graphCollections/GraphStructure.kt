package series.serie3.graphCollections

import java.util.NoSuchElementException

class GraphStructure<I, D>: Graph<I, D> {

    // TO IMPLEMENT

    override val size: Int
        get() {
            TODO("Not yet implemented")
        }

    override fun addVertex(id: I, d: D): D? {
        TODO("Not yet implemented")
    }

    override fun addEdge(id: I, idAdj: I): I? {
        TODO("Not yet implemented")
    }

    override fun getVertex(id: I): Graph.Vertex<I, D>? {
        TODO("Not yet implemented")
    }

    override fun getEdge(id: I, idAdj: I): Graph.Edge<I>? {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Graph.Vertex<I, D>> {
        TODO("Not yet implemented")
    }
}