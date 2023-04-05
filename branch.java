package circle.lin;

public class branch {
    public static void main(String[] args) {
        // 1. if的使用
        int heartBeat = 30;
        if(heartBeat<60||heartBeat>100){
            System.out.println("你的心跳数据是:" + heartBeat + ",你可能需要进一步检查！");
        }
        System.out.println("检查结束");


        //2.if - else的使用
        double money = 1;
        if(money >= 1314){
            System.out.println("发送红包成功");
        }
        else {
            System.out.println("穷逼，不要发钱了~");
        }

        //3. if - elseif - else的使用
        int score = 90;
        if(score >= 0 && score < 60){
            System.out.println("D");
        }
        else if(score >= 60 && score < 70){
            System.out.println("C");
        }
        else if(score >= 70 && score < 80){
            System.out.println("B");
        }
        else if(score >= 80 && score < 90){
            System.out.println("A");
        }
        else if(score >= 90 && score <= 100){
            System.out.println("A+");
        }
        else{
            System.out.println("你输入的分数有毛病！");
        }
    }
}
