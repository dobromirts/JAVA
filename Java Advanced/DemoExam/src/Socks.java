import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[]leftSocks= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[]rightSocks= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer>maxPair=new ArrayList<>();

        ArrayDeque<Integer>leftScks=new ArrayDeque<>();
        for (int i = 0; i <leftSocks.length ; i++) {
            leftScks.push(leftSocks[i]);
        }
        ArrayDeque<Integer>rigtScks=new ArrayDeque<>();
        for (int i = 0; i <rightSocks.length ; i++) {
            rigtScks.offer(rightSocks[i]);
        }

        while (leftScks.size()>1 || rigtScks.size()>1){
            int leftSock=leftScks.pop();
            int rightSock=rigtScks.poll();

            if (leftSock==rightSock){
                leftSock+=1;
                leftScks.push(leftSock);
            }else if (rightSock>leftSock){
                rigtScks.addFirst(rightSock);
            }else {
                int pair=rightSock+leftSock;
                maxPair.add(pair);
            }
            if (leftScks.isEmpty()){
                break;
            }
            if (rigtScks.isEmpty()){
                break;
            }
        }
        int maxNum=maxPair.stream().max(Integer::compareTo).get();
        System.out.println(maxNum);
        for (Integer integer : maxPair) {
            System.out.print(integer+" ");
        }

    }
}
