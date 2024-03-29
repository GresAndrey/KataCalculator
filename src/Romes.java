import java.io.IOException;

class Romes extends Number {

    private String romes_value1;
    private String romes_value2;
    private int romes_value1_int;
    private int romes_value2_int;
    private int result_int;
    private String sign = "";
    private String result_string;
    private final String[] roman_letters_9 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Romes(String value1, String value2) throws IOException {
        this.romes_value1 = value1;
        this.romes_value2 = value2;
        this.romes_value1_int = convert_to_int(romes_value1);
        this.romes_value2_int = convert_to_int(romes_value2);
    }

    private int convert_to_int(String romes_value) throws IOException {
        char[] value_char = romes_value.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++) {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;

                default:
                    throw new IOException("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i + 1]) {
                result += values_int[i + 1];
            } else if (values_int[i] < values_int[i + 1]) {
                result = result + values_int[i + 1] - 2;
            }
        }
        return result;
    }

    @Override
    public void sum() throws IOException {
        result_int = romes_value1_int + romes_value2_int;
        result_string = convert_result_to_Romes(result_int, result_int);
    }

    @Override
    public void sub() throws IOException {
        result_int = romes_value1_int - romes_value2_int;
        if (result_int == 0) {
            result_string = null;
        } else {
            result_string = convert_result_to_Romes(result_int, result_int);
        }
    }

    @Override
    public void div() throws IOException {
        result_int = romes_value1_int / romes_value2_int;
        result_string = convert_result_to_Romes(result_int, result_int);
    }

    @Override
    public void mul() throws IOException {
        result_int = romes_value1_int * romes_value2_int;
        result_string = convert_result_to_Romes(result_int, result_int);
    }

    private String convert_result_to_Romes(int n, int ostatok) throws IOException {
        ostatok = n % 10;
        if (ostatok != 0) {
            try {
                return convert_result_to_Romes(n - ostatok, 0) + roman_letters_9[ostatok - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IOException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
        }

        if (n == 100) {
            return "C";
        } else if (n == 90) {
            return "XC";
        } else if (n >= 50 && n < 90) {
            n = n - 50;
            return "L" + convert_result_to_Romes(n, 0);
        } else if (n >= 40 && n < 50) {
            return "XL";
        } else if (n > 0) {
            n = n - 10;
            return convert_result_to_Romes(n, 0) + "X";
        }

        return sign;
    }

    @Override
    public int getResult() {
        return result_int;
    }

    public String getStringResult() {
        return result_string;
    }

    public String getRomes_value1() {
        return romes_value1;
    }

    public String getRomes_value2() {
        return romes_value2;
    }

    public void setRomes_value1(String romes_value1) {
        this.romes_value1 = romes_value1;
    }

    public void setRomes_value2(String romes_value2) {
        this.romes_value2 = romes_value2;
    }

    public int getRomes_value1_int() {
        return romes_value1_int;
    }

    public int getRomes_value2_int() {
        return romes_value2_int;
    }

    public void setRomes_value1_int(int romes_value1_int) {
        this.romes_value1_int = romes_value1_int;
    }

    public void setRomes_value2_int(int romes_value2_int) {
        this.romes_value2_int = romes_value2_int;
    }

}
