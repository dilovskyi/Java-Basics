package aufgaben;

public class Rhombus {
    int width;
    int height;
    String symbol;

    public Rhombus(int width, int height, String symbol) {
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    public void printInfo() {
        String str = String.format("Your rhombus with \nheight:%d \nwidth:%d", this.height, this.width);
        System.out.println(str);
    }

    public void buildRhombus(String symbol) {

        StringBuilder s;
        int heightMid = this.height / 2;
        int symbolPos = this.width / 2;
        //TODO

        if (this.width % 2 == 0) {
            s = new StringBuilder(symbol + symbol);
        } else {
            s = new StringBuilder(symbol);
        }

        for (int h = 0; h <= this.height; h++) {

            for (int w = 0; w <= this.width; w++) {
                System.out.print(" ");


                if (symbolPos == w && h > heightMid) {
                    System.out.print(s + "\n");
                    if (s.length() > 1) {
                        s = new StringBuilder(s.substring(2));
                    }
                    symbolPos++;
                    break;
                } else if (symbolPos == w && h < heightMid) {
                    System.out.print(s + "\n");
                    if (symbolPos > 0) {
                        s.append("**");
                        symbolPos--;
                        break;
                    }
                } else if (symbolPos == w) {
                    System.out.print(s + "\n");
                    break;
                }
            }
        }
    }
}
