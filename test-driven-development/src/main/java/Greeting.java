import java.util.ArrayList;

public class Greeting {
    public String greet(String name) {
        if (name == null) {
            name = "my friend";
        }

        if (isUppercase(name)) {
            return "HELLO " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    public String greet(String[] name) {
        ArrayList<String> lowercaseName = new ArrayList<>();
        ArrayList<String> uppercaseName = new ArrayList<>();

        for (String s : name) {
            if (s.contains("\"")) {
                s = s.replace("\"", "");
                if (isUppercase(s)) {
                    uppercaseName.add(s);
                } else {
                    lowercaseName.add(s);
                }
            } else if (s.contains(", ")) {
                String[] split = s.split(", ");
                for (String j : split) {
                    if (isUppercase(j)) {
                        uppercaseName.add(j);
                    } else {
                        lowercaseName.add(j);
                    }
                }
            } else {
                if (isUppercase(s)) {
                    uppercaseName.add(s);
                } else {
                    lowercaseName.add(s);
                }
            }
        }

        StringBuilder tmpLower = new StringBuilder();
        StringBuilder tmpUpper = new StringBuilder();

        for (int i = 0; i < lowercaseName.size(); i++) {
            if (lowercaseName.size() == 1) {
                tmpLower.append(", ").append(lowercaseName.get(i));
            } else {
                if (i == lowercaseName.size() - 1) {
                    if (lowercaseName.size() > 2) {
                        tmpLower.append(", and ").append(lowercaseName.get(i));
                    } else {
                        tmpLower.append(" and ").append(lowercaseName.get(i));
                    }
                } else {
                    tmpLower.append(", ").append(lowercaseName.get(i));
                }
            }
        }

        if (uppercaseName.size() > 0) {
            for (int i = 0; i < uppercaseName.size(); i++) {
                if (uppercaseName.size() == 1) {
                    tmpUpper.append(" ").append(uppercaseName.get(i));
                } else {
                    if (i == uppercaseName.size() - 1) {
                        if (uppercaseName.size() > 2) {
                            tmpUpper.append(", AND ").append(uppercaseName.get(i));
                        } else {
                            tmpUpper.append(" AND ").append(uppercaseName.get(i));
                        }
                    } else {
                        tmpUpper.append(" ").append(uppercaseName.get(i));
                    }
                }
            }

            return "Hello" + tmpLower + ". AND HELLO" + tmpUpper + "!";
        }
        return "Hello" + tmpLower + ".";
    }

    private boolean isUppercase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
