package com.example.password.PasswordStrength;

import android.util.Pair;

import com.example.password.R;

public class PasswordStrength {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;

    public PasswordStrength() {
    }

    public static Pair<Strength, StrengthModel> calculate(String password) {
        return calculatePasswordStrength(password);
    }

    private static Pair<Strength, StrengthModel> calculatePasswordStrength(String password) {
        StrengthModel strengthModel = new StrengthModel();

        int length = password.length();

        if (MIN_LENGTH <= length
                && length <= MAX_LENGTH) {
            for (char c : password.toCharArray()) {
                if (!strengthModel.isSpecialCharFound() && !Character.isLetterOrDigit(c)) {
                    strengthModel.setSpecialCharFound(true);

                } else {
                    if (!strengthModel.isDigitCharFound() && Character.isDigit(c)) {
                        strengthModel.setDigitCharFound(true);

                    } else {
                        if (!strengthModel.isUpperCaseCharFound() || !strengthModel.isLowerCaseCharFound()) {
                            if (Character.isUpperCase(c)) {
                                strengthModel.setUpperCaseCharFound(true);
                            } else {
                                strengthModel.setLowerCaseCharFound(true);
                            }
                        }
                    }
                }
            }
        }

        // return enum following the score
        switch (strengthModel.getScore()) {
            case 0:
            case 1:
                return new Pair<>(Strength.WEAK, strengthModel);
            case 2:
                return new Pair<>(Strength.MEDIUM, strengthModel);
            case 3:
                return new Pair<>(Strength.GOOD, strengthModel);
            case 4:
                return new Pair<>(Strength.STRONG, strengthModel);
            default:
                return new Pair<>(Strength.NA, strengthModel);
        }
    }

    public static class StrengthModel {
        private boolean upperCaseCharFound = false;
        private boolean lowerCaseCharFound = false;
        private boolean digitCharFound = false;
        private boolean specialCharFound = false;
        private boolean length = false;

        public int getScore() {
            int score = 0;

            if (length) {
                score++;
            }
            if (specialCharFound) {
                score++;
            }
            if (digitCharFound) {
                score++;
            }
            if (upperCaseCharFound && lowerCaseCharFound) {
                score++;
            }

            return score;
        }

        public boolean isUpperCaseCharFound() {
            return upperCaseCharFound;
        }

        public void setUpperCaseCharFound(boolean upperCaseCharFound) {
            this.upperCaseCharFound = upperCaseCharFound;
        }

        public boolean isLowerCaseCharFound() {
            return lowerCaseCharFound;
        }

        public void setLowerCaseCharFound(boolean lowerCaseCharFound) {
            this.lowerCaseCharFound = lowerCaseCharFound;
        }

        public boolean isDigitCharFound() {
            return digitCharFound;
        }

        public void setDigitCharFound(boolean digitCharFound) {
            this.digitCharFound = digitCharFound;
        }

        public boolean isSpecialCharFound() {
            return specialCharFound;
        }

        public void setSpecialCharFound(boolean specialCharFound) {
            this.specialCharFound = specialCharFound;
        }

        public boolean isLength() {
            return length;
        }

        public void setLength(boolean length) {
            this.length = length;
        }
    }

    public enum Strength {
        NA(R.string.lblNotAvailable, R.color.md_red_500),
        WEAK(R.string.lblWeak, R.color.md_red_500),
        MEDIUM(R.string.lblMedium, R.color.md_blue_500),
        GOOD(R.string.lblGood, R.color.md_teal_500),
        STRONG(R.string.lblStrong, R.color.md_green_500);

        public int msg;
        public int color;

        Strength(int msg, int color) {
            this.msg = msg;
            this.color = color;
        }
    }
}