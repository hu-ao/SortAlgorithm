public class Sort_5_Bubble {
    /**
     * 交换排序
     * 冒泡排序：
     * 适合规模很小的时候，而且它的效率也比较低，但是作为入门的排序算法，还是值得学习的。
     * 什么是冒泡排序？
     * 顾名思义，像水里吐的泡泡一样，因为水越深压强越大，而泡泡的在水里的由深变浅。所以，同样的气体体积，第一个
     * 出来的泡泡比第二个出来的要大。
     */
    /**
     * 冒泡排序算法方法，intArrays为传入的数组
     */
    public static void sort(int[] intArrays)
    {
        int length = intArrays.length - 1;
        for (int i = 0;i < length;i++)
        {
            //每一次循环找出最大值
            for (int j = 0;j < length - i; j ++)
            {
                if (intArrays[j] > intArrays[j + 1])
                {
                    //如果前面的数比后面的数大就交换他们的位置
                    NumberUtils.exchange(intArrays,j,j+1);
                }
            }
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
        Sort_5_Bubble.sort(intArrays);
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
