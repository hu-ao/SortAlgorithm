public class Sort_8_Radix {
    /**
     * 基数排序：
     * 基数排序（radix sort）又称桶排序（bucket sort），相对于常见的比较排序，基数排序是一种分配式排序，
     * 即通过将所有数字分配到应在的位置最后再覆盖到原数组完成排序的过程。它是一种稳定的排序算法，但有一定
     * 的局限性：
     * 1.关键字可分解；
     * 2.记录的关键字位数较少，如果密集更好；
     * 3.如果是数字时，最后时无符号的，否则将增加相应的映射复杂度，可先将其正负分开排序。
     * 初始化：构造一个10*n的二维数组，一个长度为n的数组用于存储每次位排序时每个桶子里有多少个元素。
     * 循环操作：从低位开始（我们采用LSD的方式），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
     * 然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一桶子里的元素，先放进去的先取出，后放进去的后取出（保证排序稳定性）。
     * 这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
     */
    public static void sort(int[] intArrays,int max)
    {
        int n = 1;//代表位数对应的数：个位、十位、百位、千位..直到小于max的最大位数
        int k = 0;//保存每一位排序后的结果用于下一位的排序输入
        int length = intArrays.length;
        int[][] bucket = new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一桶里
        int[] order = new int[length];//用于保存每个桶里有多少个数字
        while(n < max)
        {
            for (int num:intArrays)//将数组array里的每个数字放在相应的桶里
            {
                int digit = (num/n)%10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0;i < length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if (order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for (int j = 0;j < order[i];j++)
                    {
                        intArrays[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶里计数器置0，用于下一次位排序
            }
            n *= 10;//扩大位数，如从个位扩大到十位
            k = 0;//将k置0，用于下一轮保存位排序结果
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
        Sort_8_Radix.sort(intArrays,max);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后：");
        for (int i = 0;i < intArrays.length;i++)
        {
            System.out.print(intArrays[i]+" ");
        }
        System.out.println();
        System.out.println("基数排序时间："+(endTime-startTime)+"毫秒");
    }
}
