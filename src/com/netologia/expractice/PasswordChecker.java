package com.netologia.expractice;

public class PasswordChecker {
    private int minlength;
    private int maxrepeats;

    public void setMinlength(int minlength) {
        this.minlength = minlength;
        if (minlength <= 0) {
            throw new IllegalArgumentException("Длина пароля не может быть отрицательной!");
        }
    }

    public void setMaxrepeats(int maxrepeats) {
        this.maxrepeats = maxrepeats;
        if (minlength <= 0) {
            throw new IllegalArgumentException("Количество повторений символа равно нулю или меньше!");
        }
    }


    boolean verify(String password) {
        int count = 1;
        for (int p = 0; p < password.length() - 1; p++) {
            if (password.charAt(p) == password.charAt(p + 1)) {
                count++;
            } else if (count <= maxrepeats) {
                count = 1;
            }
        }
        return count <= maxrepeats;
    }
}

