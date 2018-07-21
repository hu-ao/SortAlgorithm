import java.util.Random;

public class NumberUtils {
    //获取随机int类型数组
    public static int[] getRandomArs(int length,int max)
    {
        int rs[] = new int[length];
        Random random = new Random();
        for (int i = 0;i < length;i++)
        {
            rs[i] = random.nextInt(max);
        }
        return rs;
    }
    //打印内容
    public static void display(int intArrays[],int type)
    {
        int count = 0;
        if (type == 2)
        {
            System.out.print("排序后：");
        }
        else if (type == 1)
        {
            System.out.println("排序前：");
        }
        if (intArrays.length < 40)
        {
            for (int i : intArrays)
            {
                System.out.print(i + " ");
            }
        }
        else
        {
            for (int i : intArrays)
            {
                count ++;
                if (count < 10)
                {
                    System.out.print(i + " ");
                }
                else if (count == 10)
                {
                    System.out.print("......");
                }
                else if (count > intArrays.length - 10)
                {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }
    //交换数组中两个数的位置
    public static void exchange(int[] a,int i,int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
