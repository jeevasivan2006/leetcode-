class Solution {
    int i = 0;
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        List<String> temp =  helper (expression, map);
        return compress(temp);
    }

    List<String> helper (String exp, Map<String, Integer> map) {
        Stack<List<String>> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        List<String> tempExpression = new ArrayList<>();
        Integer number = null; // for corner case a number is 0 
        char sign = '+';
        while (i < exp.length()) {
            char c = exp.charAt(i++);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) { 
                number = number == null ? 0 : number;
                number = number * 10 + (c - '0');
            }
            if (Character.isLetter(c)) {
                sb.append(c);
            }
            if (c == '(') {
                tempExpression = helper (exp, map);
            } 
            if (i == exp.length() || c == ')' || c == '+' || c == '-' || c == '*') {
                // + - * 
               
                String s = null;
                Integer n = null;
                if (sb.length() > 0) {
                    String temp = sb.toString();
                    if (map.containsKey(temp)) {
                        n = map.get(temp);
                    } else {
                        s = temp;
                    }
                    sb = new StringBuilder();
                }
                if (number != null) {
                    n = number;
                    number = null;
                }
                if (sign == '+') {
                    if (tempExpression.size() > 0) {
                        stack.push(tempExpression);
                        tempExpression = new ArrayList<>();
                    }
                    if (s != null) {
                        stack.push(List.of(s));
                    }
                    if (n != null) {
                        stack.push(List.of(Integer.toString(n)));
                    }
                } else if (sign == '-') {
                    if (tempExpression.size() > 0) {
                        stack.push(minus(tempExpression));
                        tempExpression = new ArrayList<>();
                    }
                    if (s != null) {
                        stack.push(List.of("-1*" + s));
                    }
                    if (n != null) {
                        stack.push(List.of("-1*" + Integer.toString(n)));
                    }
                } else if (sign == '*') {
                    List<String> prev = stack.pop();
                    if (tempExpression.size() > 0) {
                        stack.push(calc(prev, tempExpression));
                        tempExpression = new ArrayList<>();
                    }
                    if (s != null) {
                        stack.push(calc(prev, List.of(s)));
                    }
                    if (n != null) {
                        stack.push(calc(List.of(Integer.toString(n)), prev));
                    }
                } 
                if (i == exp.length() || c == ')')   {
                    return stack.stream().flatMap(List::stream).collect(Collectors.toList());
                }
                sign = c;
            }
        }
        return new ArrayList<>();
    }

    List<String> compress(List<String> temp) {
        long number = 0l;
        TreeMap<String, Long> map = new TreeMap<>((a, b) -> {
            int degreeA = a.split("\\*").length;
            int degreeB = b.split("\\*").length;
            if (degreeA != degreeB) {
                return degreeB - degreeA;
            }
            return a.compareTo(b);
        });
        for (String t : temp) {
            List<String> base = new ArrayList<>();
            long n = 1l;
            if (t.contains("*")) {
                String[] x = t.split("\\*");
                for (String c : x) {
                    if (Character.isDigit(c.charAt(c.length() - 1))) {
                        n *= Long.parseLong(c);
                    } else {
                        base.add(c);
                    }
                }
            } else {
                if (Character.isDigit(t.charAt(t.length() - 1))) {
                    n = Long.parseLong(t);
                } else {
                    base.add(t);
                }
            }

            if (base.isEmpty()) {
                number += n;
            } else {
                Collections.sort(base);
                String key = String.join("*", base);
                map.put(key, map.getOrDefault(key, 0l) + n);

            }
        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) != 0l){
               res.add(map.get(key) + "*" + key);
            }
        }
        if (number != 0l) {
            res.add(Long.toString(number));
        }
        return res;
    }

    List<String> minus (List<String> temp) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            res.add("-1*" + temp.get(i));
        }
        return res;
    }

    List<String> calc (List<String> a, List<String> b) {
        List<String> res = new ArrayList<>();
        for (String aa : a) {
            for (String bb : b) {
                res.add(aa + "*" + bb);
            }
        }
        return res;
    }
}