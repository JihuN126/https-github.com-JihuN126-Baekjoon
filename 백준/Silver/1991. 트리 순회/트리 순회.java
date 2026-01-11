import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static TreeNode Head = new TreeNode('A',null,null);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char Root = st.nextToken().charAt(0);
            char Left = st.nextToken().charAt(0);
            char Right = st.nextToken().charAt(0);
            TreeNode.Insert(Head,Root,Left,Right);
        }
        TreeNode.PreOrder(Head);
        System.out.println();
        TreeNode.InOrder(Head);
        System.out.println();
        TreeNode.PostOrder(Head);
    }
}
class TreeNode{
    char Mid;
    TreeNode Left, Right;
    public TreeNode(char mid, TreeNode left, TreeNode right) {
        Mid = mid;
        Left = left;
        Right = right;
    }
    public static void Insert(TreeNode node, char root, char left, char right){
        if(node.Mid==root){
            node.Left = (left == '.' ? null : new TreeNode(left,null,null));
            node.Right = (right == '.' ? null : new TreeNode(right,null,null));
        }
        else{
            if(node.Left!=null) Insert(node.Left,root,left,right);
            if(node.Right!=null) Insert(node.Right,root,left,right);
        }
    }
    public static void PreOrder(TreeNode node){
        if(node==null) return;
        System.out.print(node.Mid);
        PreOrder(node.Left);
        PreOrder(node.Right);
    }
    public static void InOrder(TreeNode node){
        if(node==null) return;
        InOrder(node.Left);
        System.out.print(node.Mid);
        InOrder(node.Right);
    }
    public static void PostOrder(TreeNode node){
        if(node==null) return;
        PostOrder(node.Left);
        PostOrder(node.Right);
        System.out.print(node.Mid);
    }
}