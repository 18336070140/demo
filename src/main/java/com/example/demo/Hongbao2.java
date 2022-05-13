package com.example.demo;

public class Hongbao2 {

    //最少分得红包数
    private static final double min = 1;
    //最多分得红包数占比
    private static final double percentMax = 0.3;

    /**
     *
     * 红包算法，给定一个红包总金额和分红包的人数，输出每个人随机抢到的红包数量。
     * 要求：
     * 1. 每个人都要抢到红包，并且金额随机
     * 2. 每个人抢到的金额数不小于1
     * 3. 每个人抢到的金额数不超过总金额的30%
     * 例如总金额100元，人数10，输出【19 20 15 1 25 14 2 2 1 1】
     * @param money 总金额
     * @param peopleNum 总人数
     * @return
     */
    public static java.util.List<Integer> allocateMoney(double money, int peopleNum) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        double minMoney = min;
        double maxMoney = percentMax * money;
        int shareMoney = 0;
        double sum = 0;
        for (int i = 0; i < peopleNum; i++) {
            double max =  money - maxMoney * (peopleNum - i - 1);
            double min =  money - minMoney * (peopleNum - i - 1);
            minMoney = minMoney >max? minMoney :max;
            maxMoney = maxMoney < min ? maxMoney : min;
            shareMoney = (int) Math.floor((maxMoney - minMoney) * Math.random() + minMoney);
            money = money - shareMoney;
            sum += shareMoney;
            list.add(shareMoney);
        }
        System.out.println("要分配的红包总额为:" + sum + "元");
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        Hongbao2.allocateMoney(100,4);

    }
}
