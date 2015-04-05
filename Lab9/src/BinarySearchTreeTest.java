/*
 * Adam Morris
 * 010858274
 * Lab 9
 */

import java.util.*;

public class BinarySearchTreeTest {

   public static void main(String[] args) {
      BinarySearchTree tree = new BinarySearchTree();

      tree.add(8);
      tree.add(4);
      tree.add(12);
      tree.add(2);
      tree.add(6);
      tree.add(10);
      tree.add(14);
      tree.add(1);
      tree.add(3);
      tree.add(5);
      tree.add(7);
      tree.add(9);
      tree.add(11);
      tree.add(13);
      tree.add(15);

      System.out.println("Height is : " + tree.getHeight());
      System.out.println("Efficiency is : " + tree.getEfficiency());

      System.out.println("Printed in Order: ");
      tree.printInOrder();

      tree.clear();

      System.out.println("Tree cleared: ");
      tree.printInOrder();
      System.out.println("Degenerate Tree Adds:");
      //Now in a degenerate tree
      tree.add(15);
      tree.add(14);
      tree.add(13);
      tree.add(12);
      tree.add(11);
      tree.add(10);
      tree.add(9);
      tree.add(8);
      tree.add(7);
      tree.add(6);
      tree.add(5);
      tree.add(4);
      tree.add(3);
      tree.add(2);
      tree.add(1);

      tree.printInOrder();

      System.out.println("Height is : " + tree.getHeight());
      System.out.println("Efficiency is : " + tree.getEfficiency());

      System.out.println("Printed in Order after clear: ");
      tree.printInOrder();

      tree.clear();

      System.out.println("Tree cleared: ");
      tree.printInOrder();



      ArrayList array = new ArrayList();
      for (int i = 1; i <= 100; i++) {
         array.addLast(i);
      }
      Random gen = new Random();

      int count = 0;
      System.out.println("Array List Values:");

      while (array.getCount() != 0) {
         if (count % 10 == 0) {
            System.out.println("");
         }

         int generated = gen.nextInt(array.getCount());
         System.out.print(array.get(generated) + " ");
         tree.add((Comparable) array.get(generated));
         array.removeAt(generated);
         count++;
      }

      tree.printInOrder();
      System.out.println("Height is : " + tree.getHeight());
      System.out.println("Efficiency is : " + tree.getEfficiency());
   }
}
/* OUTPUT
run:
Height is : 3
Efficiency is : 1.0
Printed in Order:

Print in Order:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
Tree cleared:

Print in Order:

Degenerate Tree Adds:

Print in Order:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
Height is : 14
Efficiency is : 4.577776421399579E-4
Printed in Order after clear:

Print in Order:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
Tree cleared:

Print in Order:

Array List Values:

61 4 86 44 42 59 40 91 74 24
12 65 95 7 77 57 16 51 99 96
21 52 19 2 73 9 78 88 54 34
45 92 83 5 63 82 22 32 31 89
76 33 64 14 18 25 98 11 85 1
93 50 23 58 49 94 37 79 29 67
38 87 68 55 71 39 3 41 53 26
6 15 90 75 70 30 72 69 84 97
10 81 80 46 13 8 47 60 35 56
43 36 100 27 28 20 48 62 66 17
Print in Order:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
Height is : 13
Efficiency is : 0.0061038881767686015
BUILD SUCCESSFUL (total time: 0 seconds)
 */