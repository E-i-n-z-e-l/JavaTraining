package Task004;

/**
 * Вам дан массив цен prices, где prices[i] — это цена данной акции в i-й день. <p>
 *  * Вы хотите максимизировать свою прибыль, выбрав один день для покупки одной акции
 *  * и выбрав другой день в будущем для продажи этой акции.<p>
 *  * Верните максимальную прибыль, которую вы можете получить от этой сделки.  <p>
 *  * Если вы не можете получить никакую прибыль, верните 0. <p>
 */
public class Solution004 {
    public static void main(String[] args) {
        int[] pricesOne = {7,1,5,3,6,4};
        int[] pricesTwo = {7,6,4,3,1};
        int[] pricesThree = {1, 2};


        System.out.println(bestStock(pricesOne));
        System.out.println(bestStock(pricesTwo));
        System.out.println(bestStock(pricesThree));

        System.out.println(bestStockGPT(pricesOne));
        System.out.println(bestStockGPT(pricesTwo));
        System.out.println(bestStockGPT(pricesThree));

    }

    /**
     * Мое решение. Не эффективно. Слишком высокая сложность из-за вложенного цикла. Огромные затраты времени
     * при использовании больших массивов.
     * @param prices массив цен акций.
     * @return лучший доход с продажи акции.
     */
    public static int bestStock(int[] prices) {
        int best = 0;
        for (int i = 0; i < prices.length - 1; i++) { // Проходимся по массиву;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    best = Math.max(best, prices[j] - prices[i]); // С помощью функции Math.max() сравниваем best
                                                                  // с разницей первого и последующего числа в массиве;
                }
            }
        }
        return best;
    }

    /**
     * Оптимизированное решение. Гораздо быстрее первого. Используем только один цикл for-each.
     * @param prices массив цен акций.
     * @return лучший доход с продажи акции.
     */
    public static int bestStockGPT(int[] prices) {
        int best = 0; // Максимальная прибыль;
        // Используем Integer.MAX_VALUE для того, чтобы гарантировать, что любое значение цен в массиве будет
        // меньше этого значения. Это позволяет корректно обновлять minPrice на первой итерации, когда мы столкнемся
        // с первой ценой, вводимой в массиве.
        int minPrice = Integer.MAX_VALUE; // Минимальная цена на данный момент;

        for (int price : prices) {
            // Обновляем минимальную цену, если текущая цена меньше
            if (price < minPrice) {
                minPrice = price;
            }
            // Вычисляем прибыль, если продать по текущей цене
            int profit = price - minPrice;
            // Обновляем максимальную прибыль, если полученная прибыль больше
            best = Math.max(best, profit);
        }
        return best;
    }
}
