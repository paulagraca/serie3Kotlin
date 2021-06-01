package series.serie3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import series.serie3.TreeUtilsTest.completeBST
import series.serie3.TreeUtilsTest.emptyBST
import series.serie3.TreeUtilsTest.insert
import series.serie3.TreeUtilsTest.remove
import series.serie3.TreeUtilsTest.populatedBST
import series.serie3.TreeUtilsTest.singleNodeBST
import series.serie3.TreeUtilsTest.sizeTree

class IsBalancedTest {
    @Test
    fun isBalanced_empty_trees() {
        val tree = emptyBST()
        assertTrue(isBalanced(tree))
    }

    @Test
    fun isBalanced_singleNodeBST() {
        var tree = singleNodeBST()
        assertTrue(isBalanced(tree))
        tree = insert(tree, 0, CMP_NATURAL_ORDER)
        assertEquals(2, sizeTree(tree))
        assertTrue(isBalanced(tree))
        tree = insert(tree, 2, CMP_NATURAL_ORDER)
        assertEquals(3, sizeTree(tree))
        assertTrue(isBalanced(tree))
    }

    @Test
    fun isBalanced_populatedBST() {
        var tree = populatedBST()
        assertFalse(isBalanced(tree))
        tree = remove(tree, 3, CMP_NATURAL_ORDER)
        tree = remove(tree, 6, CMP_NATURAL_ORDER)
        tree = remove(tree, 7, CMP_NATURAL_ORDER)
        assertEquals(10, sizeTree(tree))
        assertTrue(isBalanced(tree))
    }

    @Test
    fun isBalanced_completeBST() {
        var tree = completeBST()
        assertTrue(isBalanced(tree))
        tree = remove(tree, 1, CMP_NATURAL_ORDER)
        tree = remove(tree, 5, CMP_NATURAL_ORDER)
        tree = remove(tree, 9, CMP_NATURAL_ORDER)
        tree = remove(tree, 13, CMP_NATURAL_ORDER)
        assertEquals(11, sizeTree(tree))
        assertTrue(isBalanced(tree))
        tree = remove(tree, 3, CMP_NATURAL_ORDER)
        tree = remove(tree, 7, CMP_NATURAL_ORDER)
        assertEquals(9, sizeTree(tree))
        assertTrue(isBalanced(tree))
        tree = remove(tree, 6, CMP_NATURAL_ORDER)
        tree = remove(tree, 2, CMP_NATURAL_ORDER)
        assertEquals(7, sizeTree(tree))
        assertFalse(isBalanced(tree))
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






