package implementations;

import interfaces.Solvable;

import java.util.ArrayDeque;
import java.util.Map;

public class BalancedParentheses implements Solvable {
    private String parentheses;
    private Map<Integer, Integer> oposites =
            Map.of(Integer.valueOf(')'),Integer.valueOf('('),
                    Integer.valueOf(']'),Integer.valueOf('['),
                    Integer.valueOf('}'),Integer.valueOf('{'));

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        parentheses.chars()
                .forEach(chr -> {
                    if (chr == '(' || chr == '{' || chr == '[' ){
                        test.push(chr);
                    } else {
                        if(test.isEmpty()){
                            test.push(chr);
                            return;
                        }
                        if (test.peek() == this.oposites.get(chr)){
                            test.pop();
                        }
                    }
                });
        return test.isEmpty();
    }
}
