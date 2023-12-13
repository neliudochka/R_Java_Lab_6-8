package FlowerSet;

import flower.Flower;
import flower.FlowerTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//MethodName_StateUnderTest_ExpectedBehavior
class FlowerSetTest {
    //constructor
    @Test
    void constructor_NoArguments_CreatesFlowerSet() {
        FlowerSet flowerSet = new FlowerSet();
        assertEquals(0, flowerSet.size());
        assertTrue(flowerSet.isEmpty());
    }

    @Test
    void constructor_OneArgument_CreatesFlowerSetWithFlower() {
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);
        FlowerSet flowerSet = new FlowerSet(normal);
        assertTrue(flowerSet.contains(normal));
        assertEquals(1, flowerSet.size());
    }

    @Test
    void constructor_CollectionWithoutCopies_CreatesFlowerSetWithFlowers() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2,1,1);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3,1,1);

        List<Flower> flowers = new ArrayList<>();
        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);

        FlowerSet flowerSet = new FlowerSet(flowers);
        assertTrue(flowerSet.contains(f2));
        assertEquals(3, flowerSet.size());
    }

    @Test
    void constructor_CollectionWithCopies_AddEachFlowerToSetOnce() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2,1,1);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3,1,1);

        List<Flower> flowers = new ArrayList<>();
        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);
        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);

        FlowerSet flowerSet = new FlowerSet(flowers);
        assertTrue(flowerSet.contains(f3));
        assertEquals(3, flowerSet.size());
    }


    //size
    @Test
    void size_HasElements_ReturnsNumberOfElements() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub tricky = new FlowerTest.FlowerStub(1,1,1);


        flowerSet.add(normal);
        flowerSet.add(null);
        flowerSet.add(tricky);

        assertEquals(3, flowerSet.size());
    }

    @Test
    void size_NoElements_ReturnsZero() {
        FlowerSet flowerSet = new FlowerSet();
        assertEquals(0, flowerSet.size());
    }

    @Test
    void size_AddedElementThatIsAlreadyInSet_SizeDoNotChange() {
        FlowerTest.FlowerStub fl = new FlowerTest.FlowerStub(1,1,1);
        FlowerSet flowerSet = new FlowerSet(fl);
        flowerSet.add(fl);

        assertEquals(1, flowerSet.size());
    }

    //isEmpty
    @Test
    void isEmpty_EmptyFlowerSet_True() {
        assertTrue(new FlowerSet().isEmpty());
    }

    @Test
    void isEmpty_FullFlowerSet_False() {
        FlowerTest.FlowerStub fl = new FlowerTest.FlowerStub(1,1,1);
        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(fl);

        assertFalse(flowerSet.isEmpty());
    }


    //contains
    @Test
    void contains_AddedElement_True() {
        FlowerTest.FlowerStub fl = new FlowerTest.FlowerStub(1,1,1);
        FlowerSet flowerSet = new FlowerSet(fl);

        assertTrue(flowerSet.contains(fl));
    }

    @Test
    void contains_EmptySet_False() {
        FlowerTest.FlowerStub fl = new FlowerTest.FlowerStub(1,1,1);
        FlowerSet flowerSet = new FlowerSet();

        assertFalse(flowerSet.contains(fl));
    }

    @Test
    void contains_ElementIsNotAddedToSet_False() {
        FlowerTest.FlowerStub fl1 = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub fl2 = new FlowerTest.FlowerStub(2,1,1);
        FlowerTest.FlowerStub fl3 = new FlowerTest.FlowerStub(3,1,1);

        FlowerSet flowerSet = new FlowerSet(fl1);
        flowerSet.add(fl2);

        assertFalse(flowerSet.contains(fl3));
    }

    @Test
    void contains_NullElementInArray_ReturnsTrueForNull() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub fl2 = new FlowerTest.FlowerStub(2,1,1);
        FlowerTest.FlowerStub fl3 = new FlowerTest.FlowerStub(3,1,1);


        flowerSet.add(fl2);
        flowerSet.add(fl3);
        flowerSet.add(null);

        assertTrue(flowerSet.contains(null));
    }

    @Test
    void contains_NullNotAddedToSet_False() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub fl2 = new FlowerTest.FlowerStub(2,1,1);
        FlowerTest.FlowerStub fl3 = new FlowerTest.FlowerStub(3,1,1);

        flowerSet.add(fl2);
        flowerSet.add(fl3);

        assertFalse(flowerSet.contains(null));
    }

    //add
    @Test
    void add_NewElement_ElementAddedToSet() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);

        assertTrue(flowerSet.add(normal));
        assertTrue(flowerSet.contains(normal));
    }

    @Test
    void add_ElementSecondTime_DoNotAddElementToSet() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);

        assertTrue(flowerSet.add(normal));
        assertFalse(flowerSet.add(normal));

        assertTrue(flowerSet.contains(normal));
    }

    @Test
    void add_NullElementToTheEmpty_AddedToSet() {
        FlowerSet flowerSet = new FlowerSet();

        assertTrue(flowerSet.add(null));
        assertTrue(flowerSet.contains(null));
        assertEquals(1, flowerSet.size());
    }

    @Test
    void add_NullElementInTheMiddle_AddedToSet() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub tricky = new FlowerTest.FlowerStub(1,1,1);


        flowerSet.add(normal);
        assertTrue(flowerSet.add(null));
        flowerSet.add(tricky);

        assertTrue(flowerSet.contains(null));
        assertEquals(3, flowerSet.size());
    }

    @Test
    void add_NullElementAtTheEnd_AddedToSet() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub tricky = new FlowerTest.FlowerStub(1,1,1);


        flowerSet.add(normal);
        flowerSet.add(tricky);

        assertTrue(flowerSet.add(null));
        assertTrue(flowerSet.contains(null));
        assertEquals(3, flowerSet.size());
    }

    @Test
    void add_NullElementToSetWithNull_NotAddedToSetAgain() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub normal = new FlowerTest.FlowerStub(1,1,1);
        FlowerTest.FlowerStub tricky = new FlowerTest.FlowerStub(1,1,1);


        flowerSet.add(normal);
        flowerSet.add(tricky);
        assertTrue(flowerSet.add(null));
        assertFalse(flowerSet.add(null));

        assertTrue(flowerSet.contains(null));
        assertEquals(3, flowerSet.size());
    }

    @Test
    void add_Element_CapacityIncrease() {
        FlowerSet flowerSet = new FlowerSet();

        int n = flowerSet.INITIAL_NUMBER_OF_ELEMENTS;

        for (int i = 1; i <= n+1; i++) {
            //System.out.println(i);
            flowerSet.add(new FlowerTest.FlowerStub(i,i,i));
        }

        assertEquals(n+1, flowerSet.size());
    }

    //iterator
    @Test
    void iterator_EmptySet_NoElementsToIterate() {
        FlowerSet flowerSet = new FlowerSet();

        assertFalse(flowerSet.iterator().hasNext());
    }

    @Test
    void iterator_NonEmptySet_IterateOverAllElements() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = new FlowerTest.FlowerStub(2, 2, 2);
        Flower f3 = new FlowerTest.FlowerStub(3, 3, 3);
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        Iterator<Flower> iterator = flowerSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(f1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(f2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(f3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator_NextGoBeyondElements_ThrowsException() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        flowerSet.add(f1);

        Iterator<Flower> iterator = flowerSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(f1, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void iterator_NullElementInSet_IterateOverAllElements() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = null;
        Flower f3 = new FlowerTest.FlowerStub(3, 3, 3);

        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        Iterator<Flower> iterator = flowerSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(f1, iterator.next());
        assertTrue(iterator.hasNext());
        //повертає нуль
        assertNull(iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(f3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void remove_ExistingElement_RemovesElement() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(2, 2, 2);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        Iterator<Flower> iterator = flowerSet.iterator();
        while (iterator.hasNext()) {
            Flower flower = iterator.next();
            if (flower.equals(f1)) {
                iterator.remove();
            }
        }

        assertFalse(flowerSet.contains(f1));
        assertTrue(flowerSet.contains(f2));
        assertTrue(flowerSet.contains(f3));
    }

    @Test
    void remove_MultipleRemoveCalls_ThrowsException() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);

        Iterator<Flower> iterator = flowerSet.iterator();
        iterator.next();
        iterator.remove();

        assertThrows(IllegalStateException.class, iterator::remove);
    }

    //toArray
    @Test
    void toArray_FullFlowerSet_ReturnsArrayContainingAllElements() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = null;
        Flower f3 = new FlowerTest.FlowerStub(3, 3, 3);

        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        Object[] resultArray = flowerSet.toArray();

        assertEquals(3, resultArray.length);

        assertEquals(f1, resultArray[0]);
        assertNull(resultArray[1]);
        assertEquals(f3, resultArray[2]);
    }

    @Test
    void toArray_EmptySet_ReturnsEmptyArray() {
        FlowerSet flowerSet = new FlowerSet();

        assertEquals(0, flowerSet.toArray().length);
    }

    //toArray([])
    @Test
    void toArray_GivenLargerArray_ReturnsArrayWithElementsAndNullsAtTheEnd() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = new FlowerTest.FlowerStub(2, 2, 2);
        Flower f3 = new FlowerTest.FlowerStub(3, 3, 3);
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        Flower[] array = new Flower[5]; // Larger array than the number of elements
        Flower[] resultArray = flowerSet.toArray(array);

        assertArrayEquals(new Flower[]{f1, f2, f3, null, null}, resultArray);
    }

    @Test
    void toArray_GivenSmallerArray_ReturnsNewArrayWithElements() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = new FlowerTest.FlowerStub(2, 2, 2);
        flowerSet.add(f1);
        flowerSet.add(f2);

        Flower[] array = new Flower[1];
        Flower[] resultArray = flowerSet.toArray(array);

        assertArrayEquals(new Flower[]{f1, f2}, resultArray);
    }

    @Test
    void toArray_GivenArrayWithSameSize_ReturnsArrayWithElements() {
        FlowerSet flowerSet = new FlowerSet();
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = new FlowerTest.FlowerStub(2, 2, 2);
        flowerSet.add(f1);
        flowerSet.add(f2);

        Flower[] array = new Flower[2];
        Flower[] resultArray = flowerSet.toArray(array);

        assertArrayEquals(new Flower[]{f1, f2}, resultArray);
    }

    @Test
    void toArray_EmptySet2_ReturnsEmptyArray() {
        FlowerSet flowerSet = new FlowerSet();

        Flower[] array = new Flower[3];
        Flower[] resultArray = flowerSet.toArray(array);

        assertArrayEquals(new Flower[]{null, null, null}, resultArray);
    }

    //remove
    @Test
    void remove_ElementThatIsNotInTheSet_False() {
        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(new FlowerTest.FlowerStub(1, 1, 1));

        assertFalse(flowerSet.remove(new FlowerTest.FlowerStub(2, 2, 2)));
    }

    @Test
    void remove_NullThatIsNotInTheSet_True() {
        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(null);

        assertTrue(flowerSet.remove(null));
        assertFalse(flowerSet.contains(null));
    }

    @Test
    void remove_ElementFromEmptySet_False() {
        Flower fl = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerSet flowerSet = new FlowerSet();

        assertFalse(flowerSet.remove(fl));
    }

    @Test
    void remove_NullFromEmptySet_False() {
        FlowerSet flowerSet = new FlowerSet();

        assertFalse(flowerSet.remove(null));
    }

    @Test
    void remove_ElementThatIsInTheSet_True() {
        FlowerSet flowerSet = new FlowerSet();
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        flowerSet.add(f1);

        assertTrue(flowerSet.remove(f1));
        assertFalse(flowerSet.contains(f1));
    }

    //containsAll
    @Test
    void containsAll_EmptyCollection_True() {
        FlowerSet flowerSet = new FlowerSet();
        assertTrue(flowerSet.containsAll(Arrays.asList()));
    }

    @Test
    void containsAll_AllElementsAreInSet_True() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        assertTrue(flowerSet.containsAll(Arrays.asList(f1, f2, f3)));
    }

    @Test
    void containsAll_SomeElementsAreNotInTheSet_False() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);
        FlowerTest.FlowerStub f4 = new FlowerTest.FlowerStub(4, 4, 4);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        assertFalse(flowerSet.containsAll(Arrays.asList(f1, f2, f3, f4)));
    }

    @Test
    void containsAll_AllElementsAreNotInTheSet_False() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);
        FlowerTest.FlowerStub f4 = new FlowerTest.FlowerStub(4, 4, 4);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);

        assertFalse(flowerSet.containsAll(Arrays.asList(f3, f4)));
    }

    @Test
    void containsAll_EmptySetAndCollection_True() {
        FlowerSet flowerSet = new FlowerSet();
        assertTrue(flowerSet.containsAll(new ArrayList<>()));
    }

    //addAll
    @Test
    void addAll_EmptyCollection_False() {
        FlowerSet flowerSet = new FlowerSet();
        assertFalse(flowerSet.addAll(new ArrayList<>()));
    }

    @Test
    void addAll_AllElementsNew_True() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        List<FlowerTest.FlowerStub> flowersToAdd = Arrays.asList(f1, f2, f3);

        FlowerSet flowerSet = new FlowerSet();
        assertTrue(flowerSet.addAll(flowersToAdd));
        assertTrue(flowerSet.containsAll(flowersToAdd));
    }

    @Test
    void addAll_SomeElementsAreInTheSet_True() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        List<FlowerTest.FlowerStub> existingFlowers = Arrays.asList(f1, f2);
        List<FlowerTest.FlowerStub> flowersToAdd = Arrays.asList(f1, f2, f3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(existingFlowers);

        assertTrue(flowerSet.addAll(flowersToAdd));
        assertTrue(flowerSet.containsAll(flowersToAdd));
    }

    @Test
    void addAll_AllElementsInTeSet_False() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);


        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));
        assertFalse(flowerSet.addAll(Arrays.asList(f1, f2, f3)));
    }

    //retainAll
    @Test
    void retainAll_ElementsToRetainPresent_SetHasOnlySpecifiedElements() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));

        assertTrue(flowerSet.retainAll(Arrays.asList(f2, f3)));

        assertTrue(flowerSet.contains(f2));
        assertTrue(flowerSet.contains(f3));

        assertFalse(flowerSet.contains(f1));
    }

    @Test
    void retainAll_EmptyCollection_SetIsEmpty() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));

        assertTrue(flowerSet.retainAll(Arrays.asList()));

        assertFalse(flowerSet.contains(f1));
        assertFalse(flowerSet.contains(f2));
        assertFalse(flowerSet.contains(f3));
    }

    @Test
    void retainAll_AllElementsAreInTheSet_NoModification() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));

        assertFalse(flowerSet.retainAll(Arrays.asList(f1, f2, f3)));

        assertTrue(flowerSet.contains(f1));
        assertTrue(flowerSet.contains(f2));
        assertTrue(flowerSet.contains(f3));
    }

    //removeAll
    @Test
    void removeAll_SomeElementsAreInTheSet_RemovesThem() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));

        assertTrue(flowerSet.removeAll(Arrays.asList(f2, f3)));

        assertTrue(flowerSet.contains(f1));
        assertFalse(flowerSet.contains(f2));
        assertFalse(flowerSet.contains(f3));
    }

    @Test
    void removeAll_EmptyCollection_NoModification() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);
        FlowerTest.FlowerStub f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.addAll(Arrays.asList(f1, f2, f3));

        assertFalse(flowerSet.removeAll(Arrays.asList()));

        assertTrue(flowerSet.contains(f1));
        assertTrue(flowerSet.contains(f2));
        assertTrue(flowerSet.contains(f3));
    }

    @Test
    void removeAll_ElementsNotInSet_NoModification() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(1, 1, 1);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);

        assertFalse(flowerSet.removeAll(Arrays.asList(f2)));

        assertTrue(flowerSet.contains(f1));
        assertFalse(flowerSet.contains(f2));
    }

    //сlear нарешті!!!
    @Test
    void clear_FullSet_EmptiesSet() {
        FlowerTest.FlowerStub f1 = new FlowerTest.FlowerStub(1, 1, 1);
        FlowerTest.FlowerStub f2 = new FlowerTest.FlowerStub(2, 2, 2);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);

        flowerSet.clear();

        assertTrue(flowerSet.isEmpty());
        assertEquals(0, flowerSet.size());
    }

    @Test
    void clear_EmptySet_NoModification() {
        FlowerSet flowerSet = new FlowerSet();

        flowerSet.clear();

        assertTrue(flowerSet.isEmpty());
        assertEquals(0, flowerSet.size());
    }

    @Test
    void testToString() {
        Flower f1 = new FlowerTest.FlowerStub(1, 1, 1);
        Flower f2 = new FlowerTest.FlowerStub(2, 2, 2);
        Flower f3 = new FlowerTest.FlowerStub(3, 3, 3);

        FlowerSet flowerSet = new FlowerSet();
        flowerSet.add(f1);
        flowerSet.add(f2);
        flowerSet.add(f3);

        String expected = "FlowerSet { " + f1 + ", " + f2 + ", " + f3 + " }";
        assertEquals(expected, flowerSet.toString());
    }
}
