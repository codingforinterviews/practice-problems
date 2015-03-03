class Solution {
  public static int findUncoupled(int[] integers) {
    int allXored = 0;
    for (int i : integers) {
      allXored ^= i;
    }
    return allXored;
  }

  public static int findUncoupledSet(int[] integers) {
    Set<Integer> seen = new HashSet<Integer>();

    for (int i : integers) {
      if (seen.contains(i)) {
        seen.remove(i);
      } else {
        seen.add(i);
      }
    }

    for (int uncoupled : seen) {
      // Will be only one
      return uncoupled;
    }

    throw new IllegalArgumentException("Does not contain uncoupled integer.");
  }

  public static void main(String[] args) {
    int[] ints = new int[] { 1, 1, 2, 2, 8 };
    System.out.println(findUncoupled(ints));
    System.out.println(findUncoupledSet(ints));
  }
}
