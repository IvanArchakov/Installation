import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        createDirectory("C://Java/Games/src");
        createDirectory("C://Java/Games/res");
        createDirectory("C://Java/Games/savegames");
        createDirectory("C://Java/Games/temp");
        createDirectory("C://Java/Games/src/main");
        createDirectory("C://Java/Games/src/test");
        createFile("C://Java/Games/src/main/Main.java");
        createFile("C://Java/Games/src/main/Utils.java");
        createDirectory("C://Java/Games/res/drawables");
        createDirectory("C://Java/Games/res/vectors");
        createDirectory("C://Java/Games/res/icons");
        createFile("C://Java/Games/temp/temp.txt");
        System.out.println(stringBuilder);

        try (FileWriter writer = new FileWriter("C://Java/Games/temp/temp.txt", false)) {
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDirectory(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            stringBuilder.append("Создан каталог " + path + "\n");
        } else {
            stringBuilder.append("Каталог " + path + " не создан\n");
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                stringBuilder.append("Файл " + file + " был создан\n");
            }
        } catch (IOException e) {
            stringBuilder.append("Файл " + file + " не был создан\n");
        }
    }

}
