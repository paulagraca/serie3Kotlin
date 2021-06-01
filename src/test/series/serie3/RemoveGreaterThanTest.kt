package series.serie3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import series.serie3.TreeUtilsTest.emptyBST
import series.serie3.TreeUtilsTest.leftChildsBST
import series.serie3.TreeUtilsTest.populatedBST
import series.serie3.TreeUtilsTest.rightChildsBST
import series.serie3.TreeUtilsTest.search
import series.serie3.TreeUtilsTest.singleNodeBST
import series.serie3.TreeUtilsTest.sizeTree
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RemoveGreaterThanTest {
    @Test
    fun removeGreaterThan_emptyBST() {
        val tree = emptyBST()
        assertNull(removeGreaterThan(tree, 1, CMP_NATURAL_ORDER))
    }

    @Test
    fun removeGreaterThan_singleNodeBST() {
        var tree = singleNodeBST()
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER))
        tree = removeGreaterThan(tree, 1, CMP_NATURAL_ORDER)
        assertTrue(search(tree, 1, CMP_NATURAL_ORDER) != null)
    }

    @Test
    fun removeGreaterThan_leftChildsBST() {
        var tree = leftChildsBST()
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER)
        assertEquals(5, sizeTree(tree))
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER))
    }

    @Test
    fun removeGreaterThan_rightChildsBST() {
        var tree = rightChildsBST()
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER)
        assertEquals(5, sizeTree(tree))
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER))
    }

    @Test
    fun removeGreaterThan_populatedBST() {
        var tree = populatedBST()
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER)
        assertEquals(6, sizeTree(tree))
        for (i in 0..5)
            assertTrue(search(tree, i, CMP_NATURAL_ORDER) != null)
        tree = removeGreaterThan(tree, 0, CMP_NATURAL_ORDER)
        assertEquals(1, sizeTree(tree))
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






