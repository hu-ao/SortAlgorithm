public class Sort_1_Insertion {
    /**
     * 直接插入排序：
     * 算法思想：
     * 直接插入排序是一种简单插入排序，基本思想：把n个待排序的元素看成为一个有序表和一个无序表。
     * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
     * 将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
     */
    public static void sort(int intArrays[])
    {
        int length = intArrays.length;
        int i;
        for (i = 1;i < length; i ++)
        {
            int tempdata = intArrays[i];
            int j;
            for (j = i - 1;j >= 0;j --)
            {
                if (intArrays[j] > tempdata)
                {
                    intArrays[j + 1] = intArrays[j];
                }
                else
                {
                    break;
                }
            }
            intArrays[j + 1] = tempdata;
        }
    }

    public static void main(String[] args) {
        //数组长度
        int length = 1000;
        //最大值
        int max = 100;
        //随机获取的排序数组
        int intArrays[] = NumberUtils.getRandomArs(length,max);
        //排序前
        System.out.println("排序前：");
        for (int i = 0;i < intArrays.length;i ++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        long startTime = System.currentTimeMillis();
        Sort_1_Insertion.sort(intArrays);
        long endTime = System.currentTimeMillis();
        //排序后
        System.out.println("排序后：");
        for (int i = 0;i < intArrays.length; i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        System.out.println("插入排序用时："+(endTime-startTime)+"毫秒");
    }
}
