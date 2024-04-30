public class Formatter {
    public String getPadej(double dividedSum) {
        int lastTwoDig = (int) dividedSum % 100;
        int lastDig = (int) dividedSum % 10;
        if (lastTwoDig >= 11 && lastTwoDig <= 13) {
            return "рублей";
        } else {
            switch (lastDig) {
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
        }
    }
}
