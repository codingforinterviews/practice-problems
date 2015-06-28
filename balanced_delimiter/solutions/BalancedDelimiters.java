import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedDelimiters {

    private Map<String, String> closeToOpen = new HashMap<>();

    public BalancedDelimiters() {
        closeToOpen.put(")", "(");
        closeToOpen.put("]", "[");
        closeToOpen.put("}", "{");

    }

    public boolean isBalanced(String value) {

        Stack<String> openValues = new Stack<>();

        for (char ch : value.toCharArray()) {

            if (isOpen(ch)) {
                openValues.push(String.valueOf(ch));
            } else if (isClose(ch)) {
                String expectedOpenValue = getOpenValue(ch);
                if (isNotMatched(openValues, expectedOpenValue)) return false;
            }
        }
        return openValues.isEmpty();


    }

    private boolean isNotMatched(Stack<String> openValues, String expectedOpenValue) {
        return !openValues.pop().equals(expectedOpenValue);
    }

    private String getOpenValue(char ch) {
        return closeToOpen.get(String.valueOf(ch));
    }

    private boolean isOpen(char ch) {
        return closeToOpen.containsValue(String.valueOf(ch));
    }

    private boolean isClose(char ch) {
        return closeToOpen.containsKey(String.valueOf(ch));
    }
}
