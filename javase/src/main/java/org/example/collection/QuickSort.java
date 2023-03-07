package org.example.collection;

/** 快速排序（以下实现方式在数据量较大时有堆栈溢出问题） */
public class QuickSort {
  private static int count = 0;

  public static void main(String[] args) {
    int[] ints = new int[8000000];
    for (int i = 0; i < ints.length; i++) {
      int i1 = (int) (Math.random() * 8000000);
      ints[i] = i1;
    }
    long l = System.currentTimeMillis();
    quickSort(ints, 0, ints.length - 1);
    //        quickSort1(ints,0,ints.length - 1);
    System.out.println("快速排序" + (System.currentTimeMillis() - l));
  }

  /**
   * 快速排序 指定一个基准值，分别将小于 等于 大于 基准值的数据放到指定区域，递归在小于 大于的区域内继续以上操作
   *
   * @param ints
   */
  public static void quickSort(int[] ints, int l, int r) {
    if (l < r) {
      // l - r 随机选取一个值，交换到r位置
      //            swap(ints, l + (int) (Math.random() * (r - l + 1)), r);
      // p为划分值等于区间的左边界和右边界
      int[] p = partition(ints, l, r);
      // < 区
      quickSort(ints, l, p[0] - 1);
      //             > 区
      quickSort(ints, p[1] + 1, r);
    }
  }

  /**
   * 默认以ints[r] 做划分，ints[r] -> p
   *
   * <p ==p >p
   *
   * @param ints
   * @param l
   * @param r
   * @return
   */
  private static int[] partition(int[] ints, int l, int r) {
    // 左边界
    int less = l - 1;
    // 右边界
    int more = r;
    while (l < more) {
      if (ints[l] < ints[r]) {
        // 如果小于基准数，则跟左边界的值进行交换，左边界右移,指针右移
        swap(ints, ++less, l++);
      } else if (ints[l] > ints[r]) {
        // 如果大于基准数，则跟右边界的值进行交换，右边界左移，指针不动
        swap(ints, --more, l);
      } else {
        // 如果等于，则不进行交换，指针右移
        l++;
      }
      // 交换完成，将基准值换到右边界的左边，即等于区间
      swap(ints, more, r);
    }
    return new int[] {less + 1, more};
  }

  /**
   * 交换两个数的位置，注意两个数在内存中的位置不能相同，否则会被置为0
   *
   * @param ints
   * @param i
   * @param j
   */
  public static void swap(int[] ints, int i, int j) {
    int item = ints[i];
    ints[i] = ints[j];
    ints[j] = item;
    //        ints[i] = ints[i] ^ ints[j];
    //        ints[j] = ints[i] ^ ints[j];
    //        ints[i] = ints[i] ^ ints[j];
  }

  private static int[] quickSort1(int[] arr, int left, int right) {
    // 左下标
    int l = left;
    // 右下标
    int r = right;
    // pivot 中轴值
    int pivot = arr[(left + right) / 2];
    // 比pivot小的放左边，大的放右边
    while (l < r) {
      // 在pivot左边一直找，找到大于等于pivot值，才退出
      while (arr[l] < pivot) {
        l++;
      }

      // 在pivot右边一直找，找到小于等于pivot值，才退出
      while (arr[r] > pivot) {
        r--;
      }

      // 如果l >= r 表示 pivot 左边全是小于它的值，右边全是大于它的值
      if (l >= r) {
        break;
      }
      // 如果不满足以上条件，则进行交换
      swap(arr, l, r);
      // 如果交换完以后发现arr[l] == pivot
      if (arr[l] == pivot) {
        r--;
      }
      if (arr[r] == pivot) {
        l++;
      }

      if (l == r) {
        l++;
        r--;
      }

      // 向左递归
      if (left < r) {
        quickSort1(arr, left, r);
      }
      // 向右递归
      if (right > l) {
        quickSort1(arr, l, right);
      }
    }
    return arr;
  }

  private static int partition1(int[] arr, int left, int right) {
    // 设定基准值（pivot）
    int pivot = left;
    int index = pivot + 1;
    for (int i = index; i <= right; i++) {
      if (arr[i] < arr[pivot]) {
        swap(arr, i, index);
        index++;
      }
    }
    swap(arr, pivot, index - 1);
    return index - 1;
  }
}
