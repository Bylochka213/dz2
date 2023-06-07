public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // добавил элементы
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // получение элемента(индекс)
        int element = list.get(2);
        System.out.println("Элемент по индексу 2: " + element);

        // Индекс элемента
        int index = list.indexOf(30);
        System.out.println("Индекс элемента 30: " + index);

        // Удаление элемента(значение)
        Integer removed = list.remove(20);
        System.out.println("Удаление элемента 20: " + removed);

        // Удаление элемента(индекс)
        int removedElement = list.remove(2);
        System.out.println("Удаленный элемент по индексу 2: " + removedElement);
    }
}