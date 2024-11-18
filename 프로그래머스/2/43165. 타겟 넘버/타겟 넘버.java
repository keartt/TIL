class Solution {
    private int length;
    private int target;
    private int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.length = numbers.length;
        this.target = target;
        this.numbers = numbers;

        return dfs(0, 0);
    }

    int dfs(int index, int sum) {
        if (index == length){
            return sum == target ? 1 : 0;
        }
        int add = dfs(index + 1, sum + numbers[index]);
        int sub = dfs(index + 1, sum - numbers[index]);

        return add + sub;
    }
}