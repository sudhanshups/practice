package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InterviewbitGreedy {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitGreedy ibit = new InterviewbitGreedy();

        //System.out.println(ibit.HighestProduct(new ArrayList<>(Arrays.asList(1, -2, -3, 2, 5, 2))));
        //System.out.println(ibit.Bulbs(new ArrayList<>(Arrays.asList(0,1,0,1))));
        //System.out.println(ibit.seats("....x..xx...x.."));

        //System.out.println(ibit.majority(new ArrayList<>(Arrays.asList(1, 1, 2))));
        //System.out.println(ibit.DistributeCandy(new ArrayList<>(Arrays.asList(7, 5, 2, 6))));
        //System.out.println(ibit.GasStation(new ArrayList<>(Arrays.asList(4, -4, 2)),new ArrayList<>(Arrays.asList(4, 0, 5))));

/*        System.out.println(ibit.GasStation(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))));
        System.out.println(ibit.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));*/

        //System.out.println(Arrays.toString(ibit.findSignatureCounts(new int[]{2, 1, 3})));
        //  System.out.println(Arrays.toString(ibit.countSubarrays(new int[]{3, 4, 1, 6, 2})));
//        System.out.println(Arrays.toString(ibit.findMinArray(new int[]{7, 6, 9, 2, 1}, 3)));

        System.out.println(ibit.minOverallAwkwardness(new int[]{5, 10, 6, 8}));
    }


    public int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        int diff1 = 0;
        for (int i = 0 + 2; i < arr.length; i += 2) {
            diff1 = Math.max(diff1, arr[i] - arr[i - 2]);
        }
        int diff2 = 0;
        for (int i = 1+2; i < arr.length; i += 2) {
            diff2 = Math.max(diff2, arr[i] - arr[i - 2]);
        }
        return Math.max(diff1, Math.max(diff2, arr[1] - arr[0]));
    }

    //https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/swap-it-2/description/
    public int[] findMinArray(int[] arr, int k) {
        for (int i = 0; i < arr.length && k > 0; i++) {

            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (j - i > k)
                    break;
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int tmp;
            for (int j = pos; j > i; j--) {
                tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
            k -= pos - i;
        }

        return arr;
    }

    //579606/count-contiguous-subarrays
    int[] countSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int n = arr.length;

        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] < arr[i]) {
                nextGreater[s.pop()] = i;
            }
            s.push(i);
        }
        while (!s.empty()) {
            int top = s.pop();
            nextGreater[top] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] < arr[i]) {
                prevGreater[s.pop()] = i;
            }
            s.push(i);
        }
        while (!s.empty()) {
            int top = s.pop();
            prevGreater[top] = -1;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nextGreater[i] == prevGreater[i] && nextGreater[i] == -1) {
                res[i] = n;
            } else if (nextGreater[i] == -1) {
                res[i] = n - prevGreater[i] - 1;
            } else if (prevGreater[i] == -1) {
                res[i] = nextGreater[i];
            } else {
                res[i] = nextGreater[i] - prevGreater[i] - 1;
            }
        }

        return res;
    }

    //Passing Yearbooks
    int[] findSignatureCounts(int[] arr) {
        int[] sign = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]--;
            sign[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            while (arr[i] != start) {
                sign[start]++;
                start = arr[start];
            }
        }
        return sign;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] grid = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = dungeon[i][j];
                } else if (i == 0) {
                    grid[i][j] += dungeon[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += dungeon[i - 1][j];
                } else {
                    grid[i][j] += Math.max(dungeon[i - 1][j], dungeon[i][j - 1]);
                }
            }
        }
        //get the path
        return 0;
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1002];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        for (int i = 1; i < 1002; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    int GasStation(ArrayList<Integer> gas, ArrayList<Integer> cost) {
        int fuelRemaining = 0;
        int totalFuel = 0;
        int start = 0;
        int n = gas.size();
        for (int i = 0; i < n; i++) {
            int extraFuel = gas.get(i) - cost.get(i);
            if (fuelRemaining >= 0) {
                fuelRemaining += extraFuel;
            } else {
                fuelRemaining = extraFuel;
                start = i;
            }
            totalFuel += extraFuel;
        }
        if (totalFuel >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    int AssignMicetoHoles(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        mice.sort((u, v) -> (u - v));
        holes.sort((u, v) -> (u - v));
        int max = 0;
        for (int i = 0; i < mice.size(); i++) {
            max = Math.max(max, Math.abs(mice.get(i) - holes.get(i)));
        }
        return max;
    }

    int DistributeCandy(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int[] arr = new int[A.size()];
        arr[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
            }
        }
        int ans = 0;
        int p = 1, c;
        ans = Math.max(arr[A.size() - 1], p);
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                c = p + 1;
            } else {
                c = 1;
            }
            ans += Math.max(arr[i], c);
            p = c;
        }
        return ans;
    }

    int majority(ArrayList<Integer> A) {
        int m = 0, majorityCount = 0;
        for (int a : A) {
            if (majorityCount == 0 || m == a) {
                m = a;
                majorityCount++;
            } else if (m != a) {
                majorityCount--;
            }
        }
        return m;
    }

    int seats(String A) {
        int n = A.length();
        int i;
        int mod = 10000003;
        List<Integer> arr = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                arr.add(i);
            }
        }
        int median = arr.size() / 2;
        int occupied = 1;
        int jumps = 0;
        for (i = 0; i < median; i++) {
            jumps += arr.get(median) - arr.get(i) - occupied;
            jumps %= mod;
            occupied++;
        }
        occupied = 1;
        for (i = median + 1; i < arr.size(); i++) {
            jumps += arr.get(i) - arr.get(median) - occupied;
            jumps %= mod;
            occupied++;
        }
        return jumps;

       /*
       public int seats(String a) {
	    int numLeft = 0;
	    int numRight = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (a.charAt(i) == OCCUPIED) {
	            ++numRight;
	        }
	    }

	    long moves = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (numRight == 0) {
	            break;
	        } else if (a.charAt(i) == OCCUPIED) {
                ++numLeft;
                --numRight;
	        } else {
	            moves += Math.min(numLeft, numRight);
	        }
	    }
	    return (int) (moves % MOD);
	}
        */

    }


    int Bulbs(ArrayList<Integer> bulbs) {
        int flips = 0;
        boolean firstOn = true;
        for (int i = 0; i < bulbs.size(); i++) {
            if (bulbs.get(i) == 0 && firstOn) {
                firstOn = false;
                flips++;
            } else if (!firstOn) {
                if (!bulbs.get(i).equals(bulbs.get(i - 1)))
                    flips++;
            }
        }
        return flips;
    }


    int HighestProduct(ArrayList<Integer> num) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        for (int a : num) {
            if (a > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a;
            } else if (a > max2) {
                max3 = max2;
                max2 = a;
            } else if (a > max3) {
                max3 = a;
            }

            if (a < min1) {
                min2 = min1;
                min1 = a;
            } else if (a < min2) {
                min2 = a;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
