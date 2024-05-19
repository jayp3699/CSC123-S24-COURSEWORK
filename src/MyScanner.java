import java.io.*;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class MyScanner {
    private BufferedReader reader;
    private String delimiter = "\\s+";
    private String buffer = "";
    private boolean closed = false;

    public MyScanner(InputStream source) {
        reader = new BufferedReader(new InputStreamReader(source));
    }

    public MyScanner(File source) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(source));
    }

    public MyScanner(String source) {
        reader = new BufferedReader(new StringReader(source));
    }

    private void ensureOpen() {
        if (closed) throw new IllegalStateException("Scanner is closed");
    }

    private void readInput() throws IOException {
        if (buffer.isEmpty()) {
            buffer = reader.readLine();
            if (buffer == null) throw new NoSuchElementException("No more tokens available");
        }
    }

    public String next() {
        ensureOpen();
        try {
            readInput();
            String[] tokens = buffer.split(delimiter, 2);
            buffer = tokens.length > 1 ? tokens[1] : "";
            return tokens[0];
        } catch (IOException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public short nextShort() {
        return Short.parseShort(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }

    public String nextLine() {
        ensureOpen();
        try {
            readInput();
            String result = buffer;
            buffer = "";
            return result;
        } catch (IOException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public boolean nextBoolean() {
        return Boolean.parseBoolean(next());
    }

    public MyScanner useDelimiter(String pattern) {
        ensureOpen();
        delimiter = pattern;
        return this;
    }

    public boolean hasNext() {
        ensureOpen();
        try {
            readInput();
            return !buffer.isEmpty();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean hasNextInt() {
        ensureOpen();
        try {
            readInput();
            return buffer.matches("-?\\d+");
        } catch (IOException e) {
            return false;
        }
    }

    public boolean hasNextDouble() {
        ensureOpen();
        try {
            readInput();
            return buffer.matches("-?\\d+(\\.\\d+)?");
        } catch (IOException e) {
            return false;
        }
    }

    public boolean hasNextLong() {
        return hasNextInt();
    }

    public boolean hasNextFloat() {
        return hasNextDouble();
    }

    public boolean hasNextShort() {
        return hasNextInt();
    }

    public boolean hasNextByte() {
        return hasNextInt();
    }

    public void close() {
        closed = true;
        try {
            reader.close();
        } catch (IOException e) {
            // ignore
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        try {
            // Test input from a string
            MyScanner scanner = new MyScanner("42 3.14 true Hello");
            System.out.println(scanner.nextInt()); // 42
            System.out.println(scanner.nextDouble()); // 3.14
            System.out.println(scanner.nextBoolean()); // true
            System.out.println(scanner.next()); // Hello
            scanner.close();

            // Test input from a file
            File file = new File("test.txt");
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("123 4.56 false World");
            }
            scanner = new MyScanner(file);
            System.out.println(scanner.nextInt()); // 123
            System.out.println(scanner.nextDouble()); // 4.56
            System.out.println(scanner.nextBoolean()); // false
            System.out.println(scanner.next()); // World
            scanner.close();
            file.delete();

            // Test input from System.in (user input)
            System.out.println("Enter some input: ");
            scanner = new MyScanner(System.in);
            while (scanner.hasNext()) {
                System.out.println("You entered: " + scanner.next());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
