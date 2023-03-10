package lesson6;

public class Program {
    public static void main(String[] args) {
       TreeNode nums = new TreeNode(1);
       nums.left = null;
       nums.right = new TreeNode(2, new TreeNode(3), null);

 
       var result = nums.preorderTraversal(nums);
       System.out.println(result);
    }
}

