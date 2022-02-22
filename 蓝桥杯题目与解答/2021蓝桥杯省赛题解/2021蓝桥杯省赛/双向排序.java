import java.io.*;

public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int in() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = in();
        int m = in();
        int[] stack = new int[m];
        int cnt = 0;
        //ά��ջ
        while (m-- > 0) {
            int opt = in();
            int mid = in();
            if (opt == 0) {
                //�����ǰ������֮ǰ�����һ�β�����ͬ��ȡmid�������
                if (cnt % 2 != opt) {
                    if (cnt - 1 >= 0 && stack[cnt - 1] < mid) {
                        cnt--;
                    } else {
                        continue;
                    }
                }else{
                    if(cnt - 1 >= 0 && mid <= stack[cnt - 1]){
                        continue;
                    }
                }
                //�����ǰ��������ǰ��2����������ô�Ϳ��Ժϲ���1��
                while (cnt - 2 >= 0 && stack[cnt - 2] <= mid) {
                    cnt -= 2;
                }
            } else {
                //�����ǰ������֮ǰ�����һ�β�����ͬ��ȡmidС������
                if (cnt % 2 != opt) {
                    if (cnt - 1 >= 0 && stack[cnt - 1] > mid) {
                        cnt--;
                    } else {
                        continue;
                    }
                }else{
                    if(cnt - 1 >= 0 && mid >= stack[cnt - 1]){
                        continue;
                    }
                }
                //�����ǰ����С��ǰ��2����������ô�Ϳ��Ժϲ���1��
                while (cnt - 2 >= 0 && stack[cnt - 2] >= mid) {
                    cnt -= 2;
                }
            }
            stack[cnt++] = mid;
        }

        int l = 1;
        int r = n;
        int[] ans = new int[n + 1];
        //x�Ӵ�С�����⵽��������
        int x = n;
        for (int i = 0; i < cnt; i++) {
            int mid = stack[i];
            if(i % 2 == 0){
                while(r > mid && r >= l){
                    ans[r--] = x--;
                }
            }else{
                while(l < mid && r >= l){
                    ans[l++] = x--;
                }
            }
            if(l > r){
                break;
            }
        }
        if(l <= r){
            if(cnt % 2 == 1){
                while(l <= r){
                    ans[l++] = x--;
                }
            }else{
                while(l <= r){
                    ans[r--] = x--;
                }
            }
        }
        out.print(ans[1]);
        for (int i = 2; i < ans.length; i++) {
            out.print(" " + ans[i]);
        }
        out.flush();
    }
}