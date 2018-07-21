public class Sort_3_Selection {
    /**
     * 选择排序
     * 简单选择排序：
     * （1）从待排序列中，找到关键字最小的元素，如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换。
     * （2）从余下的N-1个元素中，找出关键字最小的元素，重复（1）、（2）步，直到排序结束。
     */
    public static void sort(int intArrays[])
    {
        int length = intArrays.length;//数组长度
        //循环比较，假如数组长度为10，则循环9次。第一趟循环有10个数，找出这十个数的最小值放在一位。第二次循环找出另外9个
        //数的最小值，放在数字第二位。第三次找出另外8个数最小值，以此类推...
        for (int i = 0;i < length - 1;i++)
        {
            //用来保存每一趟最小值数组的下标，开始前假设第一个数字为这趟的最小值
            int minIndex = i;
            //找出每一趟的最小值，如果有最小值就将这趟的最小值放在这趟数组第一个位，如果没有最小值就继续执行下一趟
            for (int j = i + 1;j < length;j++)
            {
                if (intArrays[j] < intArrays[minIndex])
                {
                    //如果这一趟有最小值，则保存它的下标。如果这一趟没有最小值，则下标还是这趟的第一个数字
                    minIndex = j;
                }
            }
            //将这趟的第一个数字和这趟的最小值交换位置
            NumberUtils.exchange(intArrays,i,minIndex);
        }
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
        Sort_3_Selection.sort(intArrays);
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
