public class Sort_7_Merge {
    /**
     * 归并排序：
     * 归（递归）并（合并）排序采用了分治策略（divide-and-conquer），就是讲原问题分解为一些规模较小
     * 的相似子问题，然后递归解决这些子问题，最后合并其结果作为原问题的解。
     * 归并排序将待排序数组A[1..n]分成两个各含n/2各元素的子序列，然后对这两个子序列进行递归排序，最后
     * 将这两个已排序的子序列进行合并，即得到最终排好序的序列。
     */
    private static int[] tmpArray;
    /**
     * 排序--分解为一些规模较小
     */
    private static void sort(int[] a,int left,int mid,int right)
    {
        int i = left;//左数组下一个要进行比较的元素的索引
        int j = mid + 1;//右数组下一个要进行比较的元素的索引
        int N = right + 1;//本次归并的元素数目
        for (int k = left; k <= right;k++)
        {
            if (i > mid)
            {
                //左数组元素已全比较完
                tmpArray[k] = a[j++];
            }
            else if (j > right)
            {
                //右数组元素已全比较完
                tmpArray[k] = a[i++];
            }
            else if (a[j] < a[i])
            {
                //右数组元素小于左数组
                tmpArray[k] = a[j++];
            }
            else
            {
                //右数组元素大于等于左数组
                tmpArray[k] = a[i++];
            }
        }
        //归并完成后，再复制回原数组
        for (int k = left;k < N;k ++)
        {
            a[k] = tmpArray[k];
        }
    }

    /**
     *归并排序开始入口
     */
    public static void sort(int[] a)
    {
        int N = a.length;
        tmpArray = new int[N + 1];//用于暂时存放比较后的元素
        merge(a,0,N-1);
    }

    /**
     * 递归方法
     */
    public static void merge(int[] a,int left,int right)
    {
        //左索引大于等于右索引直接返回
        if (left >= right)
        {
            return;
        }
        //一分为二
        int mid = (left + right) / 2;
        //递归一分为二左边的队列
        merge(a,left,mid);
        //递归一分为二右边的队列
        merge(a,mid + 1,right);
        //排序
        sort(a,left,mid,right);
    }
    public static void main(String[] args) {
        int length = 100;
        int max = 100;
        int intArrays[] = NumberUtils.getRandomArs(length,max);
        System.out.println("排序前：");
        for (int i = 0;i < intArrays.length;i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        long startTime = System.currentTimeMillis();
        Sort_7_Merge.sort(intArrays);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：");
        for (int i = 0;i < intArrays.length;i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        System.out.println("快速排序时间："+(endTime-startTime)+"毫秒");
    }
}
