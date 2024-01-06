public class Main {
    public static void main(String[] args) {
        // Создаем объекты
        Keyboard keyboard = new Keyboard("Mechanical Keyboard", "Logitech", 99.99, "QWERTY");
        Headphones headphones = new Headphones("Over-Ear Headphones", "Sony", 149.99, true);
        GraphicsTablet graphicsTablet = new GraphicsTablet("Digital Drawing Tablet", "Wacom", 249.99, "A4");
        GraphicsTablet graphicsTablet2 = new GraphicsTablet("Digital Drawing Tablet", "Wacom", 309.99, "A4");
        GraphicsDrawingTablet raphicsDrawingTablet = new GraphicsDrawingTablet("Digital Drawing Tablet", 
                                                                               "Wacom", 309.99, "A4", 8194);

        Keyboard keyboard2 = new Keyboard();


        // Используем геттеры и сеттеры
        keyboard.setPrice(79.99);
        System.out.println("New price of the keyboard: $" + keyboard.getPrice());

        // Выводим информацию о созданных объектах
        System.out.println(keyboard.getDescription());
        System.out.println(keyboard2.getDescription());

        graphicsTablet2.forRedefinition();
        raphicsDrawingTablet.forRedefinition();

        System.out.println(headphones.getDescription());
        System.out.println(graphicsTablet.getDescription());

        // Подсчитываем количество созданных графических планшетов
        System.out.println("Total graphics tablets created: " + GraphicsTablet.getNumCreated());
    }
}