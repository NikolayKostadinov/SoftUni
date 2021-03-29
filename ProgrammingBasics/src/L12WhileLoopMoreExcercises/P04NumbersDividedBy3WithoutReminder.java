package L12WhileLoopMoreExcercises;

public class P04NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {
        int ix=1;
        while (ix<100){
            if (ix % 3 == 0){
                System.out.println(ix);
            }
            ix++;
        }
    }
}
