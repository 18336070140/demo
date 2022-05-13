package com.example.demo;

import java.math.BigDecimal;
import java.util.Objects;

public class RedEnvelop {
    // 最佳手气金额不能超过最大金额的30%
    public static final BigDecimal BEST_LUCK_PERCENT = new BigDecimal("0.3");
    // 单人每次最小抢到的金额，默认为1分钱
    public static final BigDecimal ONE_PERSON_MIN_DRAW_AMOUNT = new BigDecimal(1);

    public void redEnvelopLuckyDraw(BigDecimal totalAmount, Integer personQuantity) {

        if (Objects.isNull(totalAmount) || totalAmount.compareTo(BigDecimal.ZERO) <= 0
                || Objects.isNull(personQuantity) || personQuantity < 1) {
            System.out.println("输入参数非法，请检查");
            return;
        }
        if(personQuantity<4){
            System.out.println("不满足单人不能多于30%的校验");
            return;
        }
        BigDecimal personNum = new BigDecimal(personQuantity);
        // 红包总金额 >= 分配人数 * 每人最小中奖金额
        if (totalAmount.compareTo(ONE_PERSON_MIN_DRAW_AMOUNT.multiply(personNum)) < 0) {
            System.out.println("红包总金额不能小于（中奖人数*单人单次中奖金额），请核对红包金额和发放人数");
            return;
        }

        BigDecimal minDrawAmount = ONE_PERSON_MIN_DRAW_AMOUNT;

        BigDecimal drawLuckAmount;

        for (Integer i = 0; i < personQuantity; i++) {

            Integer remainPersonQuantity = personQuantity - i - 1;

            if (remainPersonQuantity == 0) {
                // 最后一个人，直接把剩余金额返回
                drawLuckAmount = totalAmount;
                totalAmount = totalAmount.subtract(drawLuckAmount);
                System.out.println("第" + (i + 1) + "个人抢到:" + drawLuckAmount + "元");
                break;
            }

            BigDecimal remainPersonNum = new BigDecimal(remainPersonQuantity);

            // 最大不超过剩余金额的30%
            BigDecimal maxDrawAmount = totalAmount.multiply(BEST_LUCK_PERCENT).setScale(2, BigDecimal.ROUND_UP);

            // 二倍均值法，使每个人的中奖金额都按均值概率分布
            BigDecimal doubleAverageAmount = totalAmount.divide(remainPersonNum, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(2)).setScale(2, BigDecimal.ROUND_UP);
            maxDrawAmount = doubleAverageAmount.compareTo(maxDrawAmount) < 0 ? doubleAverageAmount : maxDrawAmount;

            BigDecimal othersAllDrawMaxAmountBalance = totalAmount.subtract(maxDrawAmount.multiply(remainPersonNum));
            minDrawAmount = othersAllDrawMaxAmountBalance.compareTo(minDrawAmount) < 0 ? minDrawAmount : othersAllDrawMaxAmountBalance;

            drawLuckAmount = (maxDrawAmount.subtract(minDrawAmount)).multiply(new BigDecimal(Math.random())).setScale(2, BigDecimal.ROUND_UP);

            drawLuckAmount = drawLuckAmount.compareTo(minDrawAmount) < 0 ? minDrawAmount : drawLuckAmount;

            // 每个人抢到红包后，红包内的剩余金额
            totalAmount = totalAmount.subtract(drawLuckAmount);

            System.out.println("第" + (i + 1) + "个人抢到:" + drawLuckAmount + "元");
        }
    }

    public static void main(String[] args) {

        RedEnvelop redEnvelopMain = new RedEnvelop();

        redEnvelopMain.redEnvelopLuckyDraw(new BigDecimal(100), 4);
    }
}
