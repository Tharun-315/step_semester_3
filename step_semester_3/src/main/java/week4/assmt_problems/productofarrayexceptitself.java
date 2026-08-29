class productofarrayexceptitself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    ans[i] *= nums[j];
            }
        }
        for (int x : ans)
            System.out.print(x + " ");
    }
}