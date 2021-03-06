package com.company.thirdtask;

import org.apache.log4j.Logger;

/**
 * Реализовать метод, который на вход принимает три параметра:
 * money - количество денег, за них можно покупать конфеты,
 * price - цена 1 конфеты, k - коэффициент, показывающий сколько фантиков можно обменять на 1 бонусную конфету.
 * Метод должен возвращать максимальное количество съеденных конфет.
 * Пример: money = 10, price = 3, k = 3, метод вернет 4 (3 купили и обменяли фантики от них на 1 дополнительную конфету).
 * Определить алг. сложность предложенного алгоритма.
 */
public class ThirdTask {

    private static final Logger LOG = Logger.getLogger(ThirdTask.class);

    /**
     * Алгоритмическая сложность O(log (money/price) по основанию k)
     */
    public int buyCandies(int money, int price, int k) {
        int candies = money / price;
        int wrappers = candies;
        while (wrappers >= k) {
            int candiesFromWrappers = wrappers / k;
            candies += candiesFromWrappers;
            wrappers = (wrappers % k) + candiesFromWrappers;
        }
        LOG.info(String.format("For input %d %d %d - number of candies is %d", money, price, k, candies));
        return candies;
    }
}
