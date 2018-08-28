public class MainClass {
    public static void main(String[] args) {
        System.out.println(pow(1.1, -3));
        System.out.println(arrayMin(new Integer[]{0, -6, 1}, 0));
        System.out.println(findMean(new Float[]{1.1f, 2.2f, 3.3f}));
    }
    //алгоритм работает за O(log n) умножений при возведении в чётную степень и за O(log n + 1) при возведении в нечётную
    //если показатель степени чётный - то приводим x^n к виду x^(n/2) * x^(n/2), чтобы уменьшить кол-во умножений
    //и передаём x^(n/2) в следующую итерацию метода, после получения результата перемножаем результаты - (x^(n/2) * x^(n/2))
    //если показатель степени нечётный - то приводим x^n к виду x * x^(n-1), таким образом,
    //делая показатель степени чётным и передаём возведение в чётную степень (x^(n-1)) в следующую итерацию метода
    //после получения результата умножаем его на основание x - (x * x^(n-1))
    //когда показатель степени доходит до 0, возвращаем 1 и идём вверх по итерациям к окончательному результату.
    private static <T extends Number> double pow(T base, int exponent) {
        if (exponent < 0) {
            return 1 / pow(base, -exponent);
        } else {
            if (exponent == 0) return 1;
            if (exponent % 2 == 0) {
                double result = pow(base, exponent / 2);
                return result * result;
            } else {
                return base.doubleValue() * pow(base, exponent - 1);
            }
        }
    }
    //алгоритм работает за O(n - 1) сравниваний
    //начинаем с нулевого индекса запоминать каждый следующий элемент в переменную next, когда доходим до последнего элемента массива - возвращаем его в предыдущую итерацию метода
    //в переменную next, сравниваем элемент массива под индексом, равным значению переменной index в текущей итерации метода с переменной next, и т. д. продолжаем идти в обратную
    //сторону до первого элемента массива под индексом 0.
    private static <T extends Number> double arrayMin(T[] t, int index) {
            if (t.length - 1 > index) {
                double next = arrayMin(t, index + 1);
                return (t[index].doubleValue() < next) ? t[index].doubleValue() : next;
            } else {
                return t[t.length - 1].doubleValue();
            }
    }
    
    private static float findMean(Number[] number) {
        float sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i].doubleValue();
        }
        return sum / number.length;
    }
}
