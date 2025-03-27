package graph.medium.quiz133

import graph.Node

/**
 * [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
 */
fun main() {
    val solution = KtSolutionV1()

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)

    node1.neighbors = arrayListOf(node2, node4)
    node2.neighbors = arrayListOf(node1, node3)
    node3.neighbors = arrayListOf(node2, node4)
    node4.neighbors = arrayListOf(node1, node3)

    solution.cloneGraph(node1)
}

class KtSolutionV1 {

    //Map을 메모이제이션으로 사용
    private val visited: MutableMap<Node, Node> = mutableMapOf()

    fun cloneGraph(node: Node?): Node? {

        if (node == null) return null

        if (visited.containsKey(node)) {
            return visited[node]
        }

        val deepCopy = Node(node.`val`)
        visited[node] = deepCopy

        for (neighbor in node.neighbors) {
            deepCopy.neighbors.add(cloneGraph(neighbor))
        }

        return deepCopy
    }
}
