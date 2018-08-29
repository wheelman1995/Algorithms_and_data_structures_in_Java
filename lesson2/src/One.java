
public class One {

    private static int power(int base, int sign) {
        int result = 1;
        for (int i = 0; i < sign; i++)
            result *= base;

        return result;
    }

    private static int pr(int base, int sign) {
        if (sign == 0) return 1;
        return pr(base, --sign) * base;
    }

    private static int pre(int base, int sign) {
        if (sign == 0)
            return 1;
        else if (sign % 2 == 0) {
            return pre(base * base, sign / 2);
        } else {
            return base * pre(base, --sign);
        }
    }

    private static int pie(int base, int sign) {
        int result = 1;
        while (sign > 0) {
            if (sign % 2 == 0) {
                base *= base;
                sign /= 2;
            } else  {
                result *= base;
                sign--;
            }
        }
        return result;
    }

    private static int arrMin(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < result)
                result = arr[i];

        return result;
    }

    private static float arrMean(int[] arr) {
        float result = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++)
            result += arr[i];

        return result / size;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 9));
        System.out.println(pr(2, 10));
        System.out.println(pre(2, 11));
        System.out.println(pie(2, 31));

        int[] array = {5, 1, 4, 2, 0, 3};
        System.out.println(arrMin(array));
        System.out.println(arrMean(array));
    }
}
