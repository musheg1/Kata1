 class Converter {
     static final String[] romanNumbers = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
     static final int[] arabicNumbers = {1, 4, 5, 9, 10, 40, 50, 90, 100};

     static String arabicToRoman(int number) {
         StringBuilder result = new StringBuilder();
         int i = arabicNumbers.length - 1;
         while (number > 0) {
             if (arabicNumbers[i] <= number) {
                 result.append(romanNumbers[i]);
                 number -= arabicNumbers[i];
             } else {
                 i--;
             }
         }
         return result.toString();
     }
     static int romanToArabic(String roman) {
         int result = 0;
         int i = 0;
         for (int j = romanNumbers.length - 1; j >= 0; j--) {
             while (roman.startsWith(romanNumbers[j], i)) {
                 result += arabicNumbers[j];
                 i += romanNumbers[j].length();
             }
         }
         return result;
     }
}
