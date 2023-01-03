package com.company;

public class Cesar {
    protected static final int nEng = 26;  //Ìîùíîñòü àëôàâèòà
    protected static final int nRus = 33;

    protected static char[] engslish = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z' };

    protected static char[] russian = { 'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', '¨', 'Æ',
            'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó',
            'Ô', 'Õ', 'Ö', '×', 'Ø', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'Þ', 'ß' };

    public static int findInEnglish(char c) {
        int rez = -1;

        for (int i = 0; i < engslish.length; ++i) {
            if (Character.toUpperCase(c) == engslish[i])
                rez = i;
        }
        return rez;
    }

    public static int findInRussian(char c) {
        int rez = -1;

        for (int i = 0; i < russian.length; ++i) {
            if (Character.toUpperCase(c) == russian[i])
                rez = i;
        }
        return rez;
    }

    public static boolean isRussian(char c){
        int i = (int) c;

        //1105 è 1025 - êîäû áóêâû ¸ è ¨
        return (i>=1040 && i<=1103 || i == 1105 || i == 1025) ? true : false;
    }

    public static boolean isEnglish(char c){
        int i = (int) c;

        return (i>=65 && i<=122) ? true : false;
    }
}
