public class MainClass {
    public static void main(String[] args) {
        System.out.println(pow(2, -3));
        System.out.println(arrayMin(new Integer[]{0, -6, 1}, 0));
    }
    //алгоритм работает за O(log n) умножений при возведении в чётную степень и за O(log n + 1) при возведении в нечётную
    private static double pow(int base, int exponent) {
        if (exponent < 0) {
            return 1 / pow(base, -exponent);
        } else {
            if (exponent == 0) return 1;
            if (exponent % 2 == 0) {
                double result = pow(base, exponent / 2);
                return result * result;
            } else {
                return base * pow(base, exponent - 1);
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
}
