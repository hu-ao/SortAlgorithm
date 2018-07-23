public class Sort_6_Quick {
    /**
     * 快速排序
     * 设要排序的数组是A[0].....A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，然后将所有比它小的数
     * 都放到它前面，所有比它大的数都放到它后面，这个过程称为一趟快速排序。值得注意的是，快速排序不是一种稳定的排序算法，
     * 也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
     */
    public static void sort(int[] intArrays,int left,int right)
    {
        //如果左索引大于右索引，直接返回
        if(left > right){
            return;
        }
        int i = left ;
        int j = right;
        int temp = intArrays[left];//设置基准值，将最左端元素作为基准值
        while(i != j){
            //往左移位，直到小于temp
            while(i<j && intArrays[j]>=temp){
                j--;
            }
            //往右移位，直到大于temp
            while(i<j && intArrays[i]<=temp){
                i++;
            }
            if(i < j){
                //如果i<j,也就是说i和j还没相遇时，交换彼此的数据
                NumberUtils.exchange(intArrays,i,j);
            }
        }
        //当哨兵i与哨兵j相遇时退出循环，将哨兵i与基位交换位置
        NumberUtils.exchange(intArrays,left,i);
        //下一次迭代
        sort(intArrays,left,i-1);//左半边
        sort(intArrays,j+1,right);//右半边
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
        Sort_6_Quick.sort(intArrays,0,intArrays.length-1);
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
