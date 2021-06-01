package series.serie3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import series.serie3.TreeUtilsTest.emptyBST
import series.serie3.TreeUtilsTest.insert
import series.serie3.TreeUtilsTest.remove
import series.serie3.TreeUtilsTest.leftChildsBST
import series.serie3.TreeUtilsTest.populatedBST
import series.serie3.TreeUtilsTest.rightChildsBST
import series.serie3.TreeUtilsTest.singleNodeBST
import series.serie3.TreeUtilsTest.subPopulatedBST

class EqualTreesTest {
    @Test
    fun equalTrees_empty_trees() {
        val tree = emptyBST()
        assertTrue(equalTrees(tree, tree))
    }

    @Test
    fun equalTrees_singleNodeBST() {
        val tree = singleNodeBST()
        val treeEmpty = emptyBST()
        assertTrue(equalTrees(tree, tree))
        assertFalse(equalTrees(tree, treeEmpty))
        assertFalse(equalTrees(treeEmpty, tree))
        val tree2 = insert(treeEmpty, 2, CMP_NATURAL_ORDER)
        assertFalse(equalTrees(tree, tree2))
    }

    @Test
    fun equalTrees_leftRightChildsBST() {
        val treeL = leftChildsBST()
        val treeR = rightChildsBST()
        assertTrue(equalTrees(treeL, treeL))
        assertTrue(equalTrees(treeR, treeR))
        assertFalse(equalTrees(treeL, treeR))
    }

    @Test
    fun equalTrees_differentValuesBST() {
        var tree1 = emptyBST()
        tree1 = insert(tree1,2, CMP_NATURAL_ORDER)
        tree1 = insert(tree1,1, CMP_NATURAL_ORDER)
        tree1 = insert(tree1,3, CMP_NATURAL_ORDER)
        var tree2 = emptyBST()
        tree2 = insert(tree2,5, CMP_NATURAL_ORDER)
        tree2 = insert(tree2,4, CMP_NATURAL_ORDER)
        tree2 = insert(tree2,6, CMP_NATURAL_ORDER)
        assertFalse(equalTrees(tree1, tree2))
    }

    @Test
    fun equalTrees_populatedBST() {
        val tree = populatedBST()
        val treeSub = subPopulatedBST()
        assertTrue(equalTrees(tree, tree))
        assertTrue(equalTrees(treeSub, treeSub))
        assertFalse(equalTrees(tree, treeSub))
        var tree2 = populatedBST()
        tree2 = remove(tree2, 7, CMP_NATURAL_ORDER)
        assertFalse(equalTrees(tree, tree2))
    }

    companion object {
        val CMP_REVERSE_ORDER = Comparator { i1: Int?, i2: Int ->
            i2.compareTo(i1!!)
        }
        val CMP_NATURAL_ORDER = Comparator { i1: Int, i2: Int? ->
            i1.compareTo(i2!!)
        }
    }
}






