package com.coding.epi;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class Tests {

    @Test
    public void dutchFlag() throws Exception {
        DutchFlag t = new DutchFlag();

        int[] data = new int[]{1, 3, 6, 7, 1, 2};
        int[] res = new int[]{1, 3, 2, 1, 6, 7};

        assertThat(t.solution(data, 2)).isEqualTo(res);

        int[] d1 = new int[]{-3, 0, -1, 1, 1, 5, 4, 2};
        int[] r1 = new int[]{-3, 0, -1, 1, 1, 2, 4, 5};
        assertThat(t.solution(d1, 5)).isEqualTo(r1);
    }

    @Test
    public void dutchFlagV1() throws Exception {
        DutchFlagVariant1 t = new DutchFlagVariant1();

        int[] d1 = new int[]{1, 2, 1, 3, 1, 2};
        int[] r1 = new int[]{1, 1, 1, 3, 2, 2};

        int[] d2 = new int[]{1, 2, 1, 3, 1, 3};
        int[] r2 = new int[]{1, 1, 1, 3, 3, 2};

        assertThat(t.solution(d2)).isEqualTo(r2);
    }

    @Test
    public void deleteDuplicateFromSortedArray() {
        DeleteDuplicateSortedArray t = new DeleteDuplicateSortedArray();

        int[] d1 = {2, 3, 5, 5, 5, 7, 7, 11, 11, 11, 13};
        int[] r1 = {2, 3, 5, 7, 11, 13, 0, 0, 0, 0,};

        assertThat(t.solution(d1)).isEqualTo(r1);

    }

    @Test
    public void deleteDuplicateFromSortedArrayV1() {
        DeleteDuplicateSortedArray t = new DeleteDuplicateSortedArray();

        int[] d1 = {2, 5, 2, 2, 3};
        int[] r1 = {2, 3, 5, 7, 11, 13, 0, 0, 0, 0,};

        assertThat(t.v1(d1, 2)).isEqualTo(r1);

    }

    @Test
    public void rotateMatrix() {
        RotateMatrix t = new RotateMatrix();

        List<List<Integer>> m = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(21, 22, 23, 24, 25)
        );

        List<List<Integer>> ans = Arrays.asList(
                Arrays.asList(21, 16, 11, 6, 1),
                Arrays.asList(22, 17, 12, 7, 2),
                Arrays.asList(23, 18, 13, 8, 3),
                Arrays.asList(24, 19, 14, 9, 4),
                Arrays.asList(25, 20, 15, 10, 5)
        );

        System.out.println("Input: " + m.toString());
        List<List<Integer>> s = t.rotate(m);
        System.out.println("Output: " + s.toString());

        assertThat(s).isEqualTo(ans);

        List<List<Integer>> m2 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );

        List<List<Integer>> ans2 = Arrays.asList(
                Arrays.asList(13, 9, 5, 1),
                Arrays.asList(14, 10, 6, 2),
                Arrays.asList(15, 11, 7, 3),
                Arrays.asList(16, 12, 8, 4)
        );
        List<List<Integer>> s2 = t.rotate(m2);
        assertThat(s2).isEqualTo(ans2);


    }

    @Test
    public void pascalTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> t = pascalTriangle.mkTriangle(6);

        System.out.println(t.toString());
    }

    @Test
    public void stringToInt() {
        StringToInt converter = new StringToInt();

        Integer v1 = converter.stringToInt("-123");
        assertThat(v1).isEqualTo(-123);

        Integer v2 = converter.stringToInt("9876");
        assertThat(v2).isEqualTo(9876);

        Integer v3 = converter.stringToInt("-0");
        assertThat(v3).isEqualTo(0);
    }

    @Test
    public void intToString() {
        StringToInt converter = new StringToInt();

        String v1 = converter.intToString(-123);
        assertThat(v1).isEqualTo("-123");

        String v2 = converter.intToString(9876);
        assertThat(v2).isEqualTo("9876");
    }

    @Test
    public void ssDecoder() {
        SpreadSheetDecoder decoder = new SpreadSheetDecoder();

        assertThat(decoder.ssDecodeColID("A")).isEqualTo(1);
        assertThat(decoder.ssDecodeColID("D")).isEqualTo(4);
        assertThat(decoder.ssDecodeColID("AA")).isEqualTo(27);
        assertThat(decoder.ssDecodeColID("ZZ")).isEqualTo(702);
    }

    @Test
    public void mergeSortedArray() {
        List<Integer> v1 = Arrays.asList(2, 4, 6, 8, 10, 12);
        List<Integer> v2 = Arrays.asList(1, 5, 9);

        List<Integer> r = new MergeSortedArrays().merge(v1, v2);
        assertThat(r).isEqualTo(Arrays.asList(1, 2, 4, 5, 6, 8, 9, 10, 12));
    }


    @Test
    public void mergeSortedInPlace() {
        int[] a = {2, 4, 6, 8, 10, 12, 100, 100, 100};
        int[] b = new int[]{1, 5, 9};

        int[] r = new MergeSortedInPlace().merge(a, b, 5);
        assertThat(r).isEqualTo(Arrays.asList(1, 2, 4, 5, 6, 8, 9, 10, 12).toArray(new Integer[0]));

    }

    @Test
    public void phoneMnemonic() {
        PhoneMnemonic phoneMnemonic = new PhoneMnemonic();

        List<String> mnemonics = phoneMnemonic.phoneMnemonic("23");
//        System.out.println(mnemonics.size());
        System.out.println(mnemonics.toString());
        assertThat(phoneMnemonic.phoneMnemonic("23")).containsSequence(
                Arrays.asList("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF")
        );
    }

    @Test
    public void validIpAddress() {
        ValidIpAddress validIpAddress = new ValidIpAddress();

        String ip1 = "19216811";
        List<String> ips = validIpAddress.getValidIpAddress(ip1);

        System.out.println(ips.toString());
        assertThat(ips.size()).isEqualTo(9);
    }

    @Test
    public void rleCodec() {
        RLECodec codec = new RLECodec();

        String r1 = codec.encode("aaabccccaa");
        assertThat(r1).isEqualTo("3a1b4c2a");

        String r2 = codec.encode("aaaaa");
        assertThat(r2).isEqualTo("5a");

        String r3 = codec.encode("b");
        assertThat(r3).isEqualTo("1b");
    }

    @Test
    public void treeTraverse() {
        int [] preOrder = {10,8,2,5,4,20};
        int [] inOrder = {8,5,2,4,10,20};
        ConstructTreeFromInOrderPreOrder ctfip = new ConstructTreeFromInOrderPreOrder();
        BinaryTreeNode tree = ctfip.createTree(inOrder, preOrder);

        TreeTraverse tt = new TreeTraverse();

        System.out.println(tt.preOrder(tree));
        System.out.println(tt.inOrder(tree));
        System.out.println(tt.postOrder(tree));
    }

    @Test
    public void binarySearch() {
        BinarySearch bSearch = new BinarySearch();

        final int[] arr1 = {1, 2, 4, 5, 7, 8};
        System.out.println(bSearch.search(arr1, -1));
        System.out.println(bSearch.search(arr1, 1));
        System.out.println(bSearch.search(arr1, 8));
        System.out.println(bSearch.search(arr1, 2));
        System.out.println(bSearch.search(arr1, 6));
    }

}
