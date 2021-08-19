package review.gk.design_model.publish;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        //构建内存缓存池
//        Vector sharedQueue = new Vector();
//        int size = 10;
//
//        //建立线程池
//        ExecutorService service = Executors.newCachedThreadPool();
//        Producer producer1 = new Producer(sharedQueue,size);
//        Producer producer2 = new Producer(sharedQueue,size);
//        Producer producer3 = new Producer(sharedQueue,size);
//        Consumer consumer1 = new Consumer(sharedQueue);
//        Consumer consumer2 = new Consumer(sharedQueue);
//        Consumer consumer3 = new Consumer(sharedQueue);
//        service.execute(producer1);
//        service.execute(producer2);
//        service.execute(producer3);
//        service.execute(consumer1);
//        service.execute(consumer2);
//        service.execute(consumer3);
//
//        // 3.睡一会儿然后尝试停止生产者(结束循环)
//        Thread.sleep(10 * 1000);
//        producer1.stop();
//        producer2.stop();
//        producer3.stop();
//
//        //休眠之后关闭线程池
//        Thread.sleep(10 * 1000);
//
//        service.shutdown();
        int[] height = new int[]{1,5,3,2,4};
        System.out.println(TeamNums(height));
    }


    public static int TeamNums (int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        return getOrder(height);
    }
    public static int getOrder(int[] height){
        int res = 0;
        for(int i = 0; i < height.length - 2;i++){
            LinkedList<Integer> stack = new LinkedList<>();
            stack.addLast(height[i]);
            for(int j = i + 1; j < height.length; j++){
                int top = stack.getLast();
                if(height[j] > top){
                    stack.addLast(height[j]);
                    if(stack.size() == 3){
                        res++;
                    }
                }
            }
            System.out.println(stack);

        }
        return res;
    }

    public static int getUnOrder(int[] height){
        int res = 0;
        for(int i = 0; i < height.length - 2;i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(height[i]);
            for(int j = i + 1;j < height.length; j++){
                int top = stack.peek();
                if(height[j] < top){
                    stack.push(height[j]);
                }
                if(stack.size() == 3){
                    res++;
                    System.out.println(stack.toString());
                }
            }
        }
        return res;
    }

//    import java.util.*;
//
//
//    public class Main{
//        public static void main(String[] args){
//            Scanner scan = new Scanner(System.in);
//            String str = scan.nextLine();
//            int size = scan.nextInt();
//            System.out.println(transfer(str,size));
//        }
//        public static String transfer(String str,int size){
//            StringBuilder res = new StringBuilder();
//            String[] arr = str.split(",");
//            int start = 0,end = 0,len = 0;
//            while(end < arr.length){
//                if((len + arr[end].length() + end - start) < size){
//                    end++;
//                }else{
//                    res.append(deal(arr,start,end));
//                    len = 0;
//                    start = end + 1;
//                }
//            }
//        }
//
//        public static String deal(String[] arr,int start,int end){
//
//        }
//    }
}
