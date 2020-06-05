package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class InterviewbitTwoPointer {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitTwoPointer ibit = new InterviewbitTwoPointer();
        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));*/
        //ibit.merge(A, B);
        //System.out.println(ibit.intersect(A, B));
        //System.out.println(ibit.findMaxMinDiffInArrays(A, B,C));

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));
        System.out.println(ibit.threeSumClosest(A, -1));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
        System.out.println(ibit.threeSumZero(A));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1,1));
        System.out.println(ibit.nTriangle(A));*/

       /* ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5));
        System.out.println(ibit.diffPossible(A, 3));*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 2));
        System.out.println(ibit.removeDuplicates(A));
        System.out.println(A);*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 2));
        System.out.println(ibit.removeDuplicatesKeep2(A));
        System.out.println(A);*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3,
                2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3,
                0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0,
                1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1,
                0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0,
                2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0,
                0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1,3, 1, 2));
        System.out.println(ibit.removeElement(A, 2));
        System.out.println(A);*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 0, 2, 1, 0));
        ibit.sortColors(A);
        System.out.println(A);*/

       /* ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        System.out.println(ibit.maxone(A, 2));*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 15, 20));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(10, 12));
        System.out.println(ibit.minimize(A, B, C));

        System.out.println(ibit.countInversions(new ArrayList<>(Arrays.asList(2, 1, 1))));*/

       /* int arr[] = new int[]{1, 3, 2};
        ibit.nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);*/

//        System.out.println(ibit.multiply("210", "0"));

//        System.out.println(ibit.addBinaryNumber("1111","1111"));

        /*int[] arr = new int[1];
        int[] arr2 = new int[]{1};
        ibit.merge(arr, 0, arr2, 1);
        Arrays.stream(arr).forEach(System.out::println);

        arr = new int[]{1};
        ibit.merge(arr, 1, new int[0], 0);
        Arrays.stream(arr).forEach(System.out::println);
        */

//        System.out.println(ibit.lengthOfLongestSubstringKDistinct("s", 0));

        System.out.println(ibit.subarraySum(new int[]{1,1,1,1}, 2));

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int len = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
            len++;

            while (map.size() > k) {
                char sChar = s.charAt(start);
                map.put(sChar, map.get(sChar) - 1);
                if (map.get(sChar) == 0) {
                    map.remove(sChar);
                }
                len--;
                start++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    private String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private String twoLessThan20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    private String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int tenner = num / 10;
            int rest = num - tenner * 10;
            if (rest != 0)
                return ten(tenner) + " " + one(rest);
            else
                return ten(tenner);
        }
    }

    private String three(int num) {
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String res = "";
        if (hundred * rest != 0)
            res = one(hundred) + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one(hundred) + " Hundred";
        return res;
    }

    //Input: 1234567
    //Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    public String numberToWords(int num) { //important
        if (num == 0)
            return "Zero";

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = three(billion) + " Billion";
        if (million != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }

    /**
     * input  1 2 3
     * output 6 3 2
     */
    public void productArray(int arr[], int n) {
        if (n == 1) {
            System.out.print("0");
            return;
        }

        int i, temp = 1;
        int prod[] = new int[n];
        for (int j = 0; j < n; j++)
            prod[j] = 1;

        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        temp = 1;
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }

        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");

    }

    public boolean isOneEditDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        if (Math.abs(m - n) > 1)
            return false;

        int count = 0; // Count of edits

        int i = 0, j = 0;
        while (i < m && j < n) {
            // If current characters don't match
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1)
                    return false;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (m > n)
                    i++;
                else if (m < n)
                    j++;
                else // Iflengths of both strings is same
                {
                    i++;
                    j++;
                }

                // Increment count of edits
                count++;
            } else // If current characters match
            {
                i++;
                j++;
            }
        }

        // If last character is extra in any string
        if (i < m || j < n)
            count++;
        return count == 1;
    }

    //https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m - 1, l = m + n - 1; i >= 0; i--, l--) {
            nums1[l] = nums1[i];
        }

        int i = 0, j = n, k = 0;
        for (; j < m + n && k < n; i++) {
            if (nums1[j] < nums2[k]) {
                nums1[i] = nums1[j];
                j++;
            } else {
                nums1[i] = nums2[k];
                k++;
            }
        }
        while (j < m + n) {
            nums1[i++] = nums1[j++];
        }
        while (k < n) {
            nums1[i++] = nums2[k++];
        }
    }

    static int searchinPivotedArray(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return searchinPivotedArray(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return searchinPivotedArray(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return searchinPivotedArray(arr, mid + 1, h, key);

        return searchinPivotedArray(arr, l, mid - 1, key);
    }

    static int findPivot(int arr[], int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    //trap water
    int trap(int height[]) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }


    public int countInversions(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;
        int inversion = mergeSort(A, low, high);
        return inversion;
    }

    private int mergeSort(final ArrayList<Integer> A, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int inversion = mergeSort(A, low, mid);
        inversion += mergeSort(A, mid + 1, high);
        inversion += merge(A, low, mid, high);
        return inversion;
    }

    private int merge(final ArrayList<Integer> A, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (i = 0; i < n1; i++) {
            L[i] = A.get(i + low);
        }
        for (i = 0; i < n2; i++) {
            R[i] = A.get(i + mid + 1);
        }
        i = j = 0;
        k = low;
        int inversion = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A.set(k++, L[i++]);
            } else {
                inversion += n1 - i;
                A.set(k++, R[j++]);
            }
        }
        while (i < n1) {
            A.set(k++, L[i++]);
        }
        while (j < n2) {
            A.set(k++, R[j++]);
        }

        return inversion;
    }

    class Element {
        int index;
        List<Integer> arr;

        Element(int x, List<Integer> a) {
            index = x;
            arr = a;
        }
    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        Queue<Element> queue = new PriorityQueue<>((u, v) -> (u.arr.get(u.index) - v.arr.get(v.index)));
        queue.add(new Element(0, A));
        queue.add(new Element(0, B));
        queue.add(new Element(0, C));

        int min = Integer.MAX_VALUE;
        while (queue.size() > 2) {
            Element a = queue.poll();
            Element b = queue.poll();
            Element c = queue.poll();

            int aE = a.arr.get(a.index);
            int bE = b.arr.get(b.index);
            int cE = c.arr.get(c.index);

            min = Math.min(min,
                    Math.max(Math.abs(aE - bE),
                            Math.max(Math.abs(bE - cE),
                                    Math.abs(cE - aE))));


            if (a.index + 1 < a.arr.size()) {
                queue.add(new Element(a.index + 1, a.arr));
            }
            queue.add(b);
            queue.add(c);
        }
        return min;
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int maxL = 0;
        int zerosIncluded = 0;
        int start = 0;
        while (i < A.size()) {
            queue.add(i);
            if (A.get(i) == 0) {
                zerosIncluded++;
            }
            while (zerosIncluded > B) {
                int pop = queue.poll();
                if (A.get(pop) == 0)
                    zerosIncluded--;
            }
            if (maxL < queue.size()) {
                maxL = queue.size();
                start = queue.peek();
            }
            i++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (i = start; i < start + maxL; i++) {
            res.add(i);
        }
        return res;
    }

    public void sortColors(ArrayList<Integer> a) {
        int l = 0;
        int h = a.size() - 1;
        int t;
        for (int i = 0; i <= h && l < h; ) {
            if (a.get(i) == 0) {
                t = a.get(l);
                a.set(l, a.get(i));
                a.set(i, t);
                l++;
                i++;
            } else if (a.get(i) == 2) {
                t = a.get(h);
                a.set(h, a.get(i));
                a.set(i, t);
                h--;
            } else if (a.get(i) == 1) {
                i++;
            }
        }
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int l = 0;
        for (int i = 0; i < a.size(); i++) {
            while (i < a.size() && a.get(i) == b) {
                i++;
            }
            if (i >= a.size()) {
                break;
            }
            a.set(l, a.get(i));
            l++;

        }
        return l;
    }

    public int removeDuplicatesKeep2(ArrayList<Integer> a) {
      /*  int i = 0;
        boolean changed = true;
        for (int j = 1; j < a.size(); j++) {
            if (a.get(i).equals(a.get(j)) && changed) {
                i++;
                a.set(i, a.get(j));
                changed = false;
            } else if (!a.get(i).equals(a.get(j))) {
                i++;
                a.set(i, a.get(j));
                changed = true;
            }
        }
        return i + 1;
        */
        if (a.size() < 3) {
            return a.size();
        }
        int l = 2;
        for (int i = 2; i < a.size(); i++) {
            a.set(l, a.get(i));
            if (!a.get(l).equals(a.get(l - 2))) {
                l++;
            }
        }
        return l;
    }

    public void nextPermutation(int[] nums) {
        boolean found = false;
        int sortIndex = 0;
        int pivot = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                found = true;
                sortIndex = i;
                pivot = i - 1;
                break;
            }
        }
        if (!found) {
            Arrays.sort(nums);
        } else {
            int maxIndex = sortIndex;
            for (int i = sortIndex; i < nums.length; i++) {
                if (nums[pivot] < nums[i] && nums[i] < nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            int tmp = nums[maxIndex];
            nums[maxIndex] = nums[pivot];
            nums[pivot] = tmp;
            Arrays.sort(nums, sortIndex, nums.length);
        }
    }

    interface TriFuction<U, V, W, X> {
        X apply(U u, V v, W w);
    }

    //https://leetcode.com/problems/add-binary/
    public String addBinaryNumber(String a, String b) {
        Function<Integer, String> fn = (u) -> {
            switch (u) {
                case 0:
                    return "00";
                case 1:
                    return "01";
                case 2:
                    return "10";
                case 3:
                    return "11";
            }
            return "00";
        };
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder s = new StringBuilder();
        char carry = '0';
        int i = 0;
        for (; i < Math.min(a.length(), b.length()); i++) {
            int result = a.charAt(i) + b.charAt(i) + carry - 3 * '0';
            s.append(fn.apply(result).charAt(1));
            carry = fn.apply(result).charAt(0);
        }
        while (i < a.length()) {
            int result = a.charAt(i) + carry - 2 * '0';
            s.append(fn.apply(result).charAt(1));
            carry = fn.apply(result).charAt(0);
            i++;
        }
        while (i < b.length()) {
            int result = b.charAt(i) + carry - 2 * '0';
            s.append(fn.apply(result).charAt(1));
            carry = fn.apply(result).charAt(0);
            i++;
        }
        if (carry == '1') {
            s.append(carry);
        }

        return s.reverse().toString();

    }

    private void sumArray(char[] result, char[] tempResult, int zeros) {
        int i = 0;
        int c = 0;
        for (; i < tempResult.length; i++) {
            c = (result[i + zeros] - '0') + (tempResult[i] - '0') + c;
            result[i + zeros] = (char) (c % 10 + '0');
            c = c / 10;
        }
        while (c != 0) {
            c = (result[i + zeros] - '0') + c;
            result[i + zeros] = (char) (c % 10 + '0');
            c = c / 10;
            i++;
        }
    }

    public String multiply(String num1, String num2) {
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, '0');
        //num2 * num1
        int zeros = 0;
        for (int c1 = num1.length() - 1; c1 >= 0; c1--) {
            char[] num2Arr = num2.toCharArray();
            char[] tempResult = new char[num2.length() + 1];
            Arrays.fill(tempResult, '0');

            int carry = 0;
            int mul = num1.charAt(c1) - '0';
            int j = 0;
            for (int i = num2Arr.length - 1; i >= 0; i--) {
                carry = (num2Arr[i] - '0') * mul + carry;
                tempResult[j] = (char) (carry % 10 + '0');
                carry = carry / 10;
                j++;
            }
            tempResult[j] = (char) (carry + '0');
            sumArray(result, tempResult, zeros);
            zeros++;
        }

        int i = result.length - 1;
        for (; i > 0; i--) {
            if (result[i] != '0') {
                break;
            }
        }
        StringBuilder s = new StringBuilder(new String(result, 0, i + 1));
        return s.reverse().toString();
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int unique = 0;
        for (int i = 1; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(unique))) {
                unique++;
                a.set(unique, a.get(i));
            }
        }
        return unique + 1;
    }

    public int diffPossible(ArrayList<Integer> array, int lf) {
        if (array.size() <= 1)
            return 0;

        lf = Math.abs(lf);
        int l = 0;
        int h = 1;
        while (h < array.size() && l < h) {
            int a = array.get(l);
            int b = array.get(h);
            if (lf == (a - b) || lf == (b - a)) {
                return 1;
            }
            if (lf > (b - a)) {
                h++;
            } else {
                l++;
            }
            if (l == h)
                h++;
        }
        return 0;
    }

    public int nTriangle(ArrayList<Integer> A) {
        A.sort((u, v) -> (u - v));
        long res = 0;
        int k = 0;
        for (int i = 0; i < A.size() - 2; i++) {
            k = i + 2;
            for (int j = i + 1; j < A.size(); j++) {
                while (k < A.size() && (long) (A.get(i) + A.get(j)) > (long) A.get(k)) {
                    k++;
                }

                if (k > j) {
                    res += k - j - 1;
                }
                res = res % (1000000007l);
            }
        }
        return (int) res;
    }

    public ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> A) {
        A.sort((u, v) -> u - v);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size() - 2; ) {
            int r = A.size() - 1;
            int l = i + 1;
            int a = A.get(i);
            while (l < r) {
                int b = A.get(l);
                int c = A.get(r);
                int sum = a + b + c;
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(a, b, c)));
                    while (l < A.size() && A.get(l) == b) {
                        l++;
                    }
                    while (r >= 0 && A.get(r) == c) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            while (i < A.size() && A.get(i) == a) {
                i++;
            }
        }
        return result;
    }


    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;
        A.sort((u, v) -> (u - v));
        for (int j = 1; j < A.size() - 1; j++) {
            int i = 0;
            int k = A.size() - 1;
            while (i < j && j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                if (Math.abs(B - sum) < closest) {
                    closest = Math.abs(B - sum);
                    closestSum = sum;
                }
                if (sum == B) {
                    return sum;
                } else if (sum < B) {
                    i++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }


    public int findMaxMinDiffInArrays(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0;
        if (A.size() == 0 || B.size() == 0 || C.size() == 0) {
            return 0;
        }
        int a, b, c;
        int diff = Integer.MAX_VALUE;
        while (i < A.size() && j < B.size() && k < C.size()) {
            a = A.get(i);
            b = B.get(j);
            c = C.get(k);
            diff = Math.min(diff, Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c))));
            if (Math.min(a, Math.min(b, c)) == a) {
                i++;
            } else if (Math.min(a, Math.min(b, c)) == b) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }


    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i = 0, j = 0;
        ArrayList<Integer> C = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                C.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return C;

    }

    public void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> c = new ArrayList<>(A.size() + B.size());
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                c.add(A.get(i++));
            } else {
                c.add(B.get(j++));
            }
        }
        while (i < A.size()) {
            c.add(A.get(i++));
        }
        while (j < B.size()) {
            c.add(B.get(j++));
        }
        for (i = 0; i < A.size(); i++) {
            A.set(i, c.get(i));
        }
        for (; i < c.size(); i++) {
            A.add(c.get(i));
        }
    }
}
