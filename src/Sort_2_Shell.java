public class Sort_2_Shell {
    /**
     * 希尔排序：
     * 算法思想：
     *希尔排序也称为“缩小增量排序”，其基本原理是，现将待排序的数组元素分成多个子序列，使得每个子序列
     * 的元素个数相对较少，然后对各个子序列分别进行直接插入排序，待整个待排序列“基本有序”后，最后在对所有元素进行一次
     * 直接插入排序。因此，我们要采用跳跃分割的策略：将相距某个“增量”的记录组成一个子序列，这样才能保证在子序列内分别
     * 进行直接插入排序后得到的结果是基本有序而不是局部有序。希尔排序是对直接插入排序算法的优化和升级。
     * 所谓的基本有序，就是小的关键字基本在前面，大的基本在后面，不大不小的基本在中间，例如{2,1,3,6,4,7,5,8,9}就可以称为
     * 基本有序了。但像{1,5,9,3,7,8,2,4,6}这样，9在第三位，2在倒数第三位就谈不上基本有序。
     */
    public static void shellSortSmallToBig(int[] intArrays)
    {
        int length = intArrays.length;
        int h = 1;
        int block = 3;//分块大小（大于1的值）
        //h为分区后每块有多少个元素
        while(h < length / block)
        {
            h = block * h + 1;//通过循环算出h的取值，当分区大小为3时，h序列为1,4,13,40，...
        }
        while (h >= 1)
        {
            int n,i,j,k;
            //分割后，产生n个子序列
            for (n = 0;n < h;n ++)
            {
                //分别对每个子序列进行直接插入排序
                for (i = n + h;i < length; i += h)
                {
                    for (j = i - h;j >= 0 && intArrays[i] < intArrays[j]; j -= h)
                    {

                    }
                    int tmp = intArrays[i];
                    for (k = i;k > j + h;k -= h)
                    {
                        intArrays[k] = intArrays[k-h];
                    }
                    intArrays[j+h] = tmp;
                }
            }
            //直接插入排序完后，减少每块区里的元素。也就是说增大块区的数量，知道最后h=1（每块区里只有一个元素时，排序完成）
            h = h / block;
        }
    }


    public static void main(String[] args) {
        int length = 10;
        int max = 100;
        int[] intArrays = NumberUtils.getRandomArs(length,max);
        System.out.println("排序前：");
        for (int i = 0;i < intArrays.length;i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        long startTime = System.currentTimeMillis();
        Sort_2_Shell.shellSortSmallToBig(intArrays);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：");
        for (int i = 0;i < intArrays.length;i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        System.out.println("希尔排序时间："+(endTime-startTime)+"毫秒");
    }
}
