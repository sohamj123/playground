public class test {
    public static void main(String[] args) {
        System.out.println(readRomanNumeral("xliv"));

    }

    public static int getValOf(String str) {
        if (str.equalsIgnoreCase("I")) {
            return 1;
        }
        if (str.equalsIgnoreCase("v")) {
            return 5;
        }
        if (str.equalsIgnoreCase("x")) {
            return 10;
        }
        if (str.equalsIgnoreCase("L")) {
            return 50;
        }
        if (str.equalsIgnoreCase("C")) {
            return 100;
        }
        return 0;
    }

    public static int readRomanNumeral(String str) {
        int sum = 0;
        int i = 0;
        while (i < str.length()) {
            if (i < str.length() - 1) {
                if (getValOf(str.substring(i, i + 1)) < getValOf(str.substring(i + 1, i + 2))) {
                    if (str.substring(i, i + 1).equalsIgnoreCase("x")) {
                        if (str.substring(i + 1, i + 2).equalsIgnoreCase("L")) {
                            sum += 40;
                            i++;
                        } else {
                            sum += 90;
                            i++;
                        }
                    } else {
                        if (str.substring(i + 1, i + 2).equalsIgnoreCase("x")) {
                            sum += 9;
                            i++;
                        } else {
                            sum += 4;
                            i++;
                        }
                    }
                } else {
                    sum += getValOf(str.substring(i, i + 1));
                }
            } else {
                sum += getValOf(str.substring(i, i + 1));
            }
            i++;
        }
        return sum;
    }
}