public class DiamondGenerator {
    private static void upperPart(StringBuffer buffer, int size, char texture, char shade) {
        for (int i = 0; i < size - 1; i++) {

            // Generate the left side shade part and left edge
            for (int j = size - 1 - i; j > 0; j--) {
                buffer.append(shade);
            }
            buffer.append(texture);

            // The total inside part and the left edge
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < i - 1; k++) {
                    buffer.append(shade);
                }
                if (i != 0) {
                    buffer.append(texture);
                }
            }

            // End of every line
            buffer.append('\n');
        }
    }

    private static void midPart(StringBuffer buffer, int size, char texture) {
        for (int i = 0; i < 2 * size - 1; i++) {
            buffer.append(texture);
        }
        buffer.append('\n');
    }

    private static void lowerPart(StringBuffer buffer, int size, char texture, char shade) {
        for (int i = 0; i < size - 1; i++) {

            // Generate the left side shade part and right edge
            for (int j = 0; j <= i; j++) {
                buffer.append(shade);
            }
            buffer.append(texture);

            // The left inside part
            for (int j = 0; j < size - i - 3; j++) {
                buffer.append(texture);
            }

            // The mid vertical line and total right side
            for (int j = 0; j < size - i - 2; j++) {
                if (j == 0) {
                    buffer.append(shade);
                }
                buffer.append(texture);
            }

            buffer.append('\n');
        }
    }

    public static String diamond(int size, char... color) {
        // Default parameters manage
        char texture = '*';
        char shade = ' ';
        switch (color.length) {
            case 1:
                texture = color[0];
                break;
            case 2:
                texture = color[0];
                shade = color[1];
        }

        StringBuffer buffer = new StringBuffer();
        upperPart(buffer, size, texture, shade);
        midPart(buffer, size, texture);
        lowerPart(buffer, size, texture, shade);
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.print(diamond(5));
        System.out.print(diamond(7, '$'));
        System.out.print(diamond(6, '@', '.'));
    }
}