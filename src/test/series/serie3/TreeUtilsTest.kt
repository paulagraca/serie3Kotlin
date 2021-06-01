package series.serie3

import java.util.*

object TreeUtilsTest {

    fun <E> sizeTree(root: Node<E>?): Int {
        return if (root == null) 0 else 1 + sizeTree(root.left) + sizeTree(root.right)
    }

    fun <E> minimum(root: Node<E>): Node<E> {
        if (root.left == null) return root
        else return minimum(root.left!!)
    }

    fun <E> maximum(root: Node<E>): Node<E> {
        if (root.right == null) return root
        else return minimum(root.right!!)
    }

    fun <E> search(root: Node<E>?, key: E, cmp: Comparator<E>): Node<E>? {
        if (root == null || cmp.compare(key, root.value) == 0) return root
        else if (cmp.compare(key, root.value) < 0) return search<E>(root.left, key, cmp)
        else return search<E>(root.right, key, cmp)
    }

    fun <E> insert(root: Node<E>?, e: E, cmp: Comparator<E>): Node<E>? {
        var root = root
        if (root == null) root = Node(e)
        else if (cmp.compare(e, root.value) < 0) root.left = insert<E>(root.left, e, cmp)
        else root.right = insert<E>(root.right, e, cmp)
        return root
    }

    fun <E> remove(root: Node<E>?, e: E?, cmp: Comparator<E>): Node<E>? {
        var root = root
        if (root == null) return root
        else {
            if (cmp.compare(e, root.value) < 0) root.left = remove<E>(root.left, e, cmp)
            else if (cmp.compare(e, root.value) > 0) root.right = remove<E>(root.right, e, cmp)
            else { // found, delete it
                if (root.left == null) root = root.right
                else if (root.right == null) root = root.left
                else {
                    val y: Node<E> = minimum(root.right!!)
                    root.value = y.value
                    root.right = remove(root.right, y.value, cmp)
                }
            }
            return root
        }
    }

    fun <E> preorder(root: Node<E>?) {
        if (root != null) {
            print(root.value.toString() + " ")
            preorder(root.left)
            preorder(root.right)
        }
    }

    fun <E> inorder(root: Node<E>?) {
        if (root != null) {
            inorder(root.left)
            print(root.value.toString() + " ")
            inorder(root.right)
        }
    }

    fun <E> postorder(root: Node<E>?) {
        if (root != null) {
            postorder(root.left)
            postorder(root.right)
            print(root.value.toString() + " ")
        }
    }

    /*
    Create BSTs using Ints
     */

    private class NodeComparator : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            return if (o1 != null && o2 != null) o1 - o2 else 0
        }
    }

    fun emptyBST(): Node<Int>? {
        return null
    }

    fun singleNodeBST(): Node<Int>? {
        val nodes = intArrayOf(1)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }

    fun leftChildsBST(): Node<Int>? {
        val nodes = intArrayOf(5, 4, 3, 2, 1)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }

    fun rightChildsBST(): Node<Int>? {
        val nodes = intArrayOf(1, 2, 3, 4, 5)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }

    fun populatedBST(): Node<Int>? {
        val nodes = intArrayOf(10, 4, 1, 8, 5, 6, 7, 0, 2, 3, 9, 12, 11)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }

    fun subPopulatedBST(): Node<Int>? {
        val nodes = intArrayOf(10, 4, 1, 8, 12, 11)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }

    fun completeBST(): Node<Int>? {
        val nodes = intArrayOf(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15)
        var tree: Node<Int>? = null
        for (i in nodes.indices) tree = insert(tree, nodes[i], NodeComparator())
        return tree
    }
}




















