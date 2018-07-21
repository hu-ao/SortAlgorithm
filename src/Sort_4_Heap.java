public class Sort_4_Heap {
    /**
     * 堆排序：
     * 什么是堆？
     * 堆是一颗顺序存储的完全二叉树。
     * 小根堆：每个节点的关键字都不大于其孩子节点的关键字。
     * 大根堆：每个节点的关键字都不小于其孩子节点的关键字。
     * 对于n个元素的序列{R0，R1，...，Rn}当且仅当满足下列关系之一时，称之为堆：
     * （1）Ri <= R2i+1且Ri <= R2i+2（小根堆）
     * （2）Ri >= R2i+1且Ri >= R2i+2（大根堆）
     * 利用大顶堆（小顶堆）堆顶记录的是最大关键字（最小关键字）这一特性，使得每次从无序中选择最大
     * 记录（最小记录）变得简单。
     * 其基本思想为（大顶堆）：
     * 1）将初始待排序关键字序列（R1，R2...Rn）构建成大顶堆，此堆为初始的无序区；
     * 2）将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区（R1，R2...Rn-1）和新的有序区（Rn），且满足R[1,2...n-1]<=R[n];
     * 3）由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区（R1，R2...Rn-1）调整为新堆，然后再次将R[1]与无序区最后一个
     * 元素交换，得到新的无序区（R1，R2...Rn-2）和新的有序区（Rn-1,Rn）。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */
    /**
     * 交换第一个和最后一个元素，输出最后一个元素（最大值），然后把剩下元素重新调整为大根堆
     */
    public static void sort(int[] array,int parent,int length)
    {
        int temp = array[parent];//temp保存当前父节点
        int child = 2 * parent + 1;//先获得左孩子
        while(child < length)
        {
            //如果有右孩子节点，并且右孩子节点的值大于左孩子节点，则选取右孩子节点
            if (child + 1 < length && array[child] < array[child + 1])
            {
                child ++;
            }
            //如果父节点的值已经大于孩子节点的值，则直接结束
            if (temp >= array[child])
            {
                break;
            }
            //把孩子节点的值赋给父节点
            array[parent] = array[child];
            //选取孩子节点的左孩子节点，继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }
    /**
     * 堆排序开始入口
     */
    public static  void sort(int[] list)
    {
        //循环建立初始堆
        for (int i = list.length / 2;i >= 0;i --)
        {
            sort(list,i,list.length);
        }
        //进行n-1次循环，完成排序
        for (int i = list.length - 1;i > 0;i --)
        {
            //最后一个元素和第一个元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            //筛选R[0]节点，得到i-1个节点的堆
            sort(list,0,i);
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
        Sort_4_Heap.sort(intArrays);
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
