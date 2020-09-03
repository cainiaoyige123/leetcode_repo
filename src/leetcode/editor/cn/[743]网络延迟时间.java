//有 N 个网络节点，标记为 1 到 N。 
//
// 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从
//源节点传递到目标节点的时间。 
//
// 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。 
//
// 
//
// 示例： 
//
// 
//
// 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//输出：2
// 
//
// 
//
// 注意: 
//
// 
// N 的范围在 [1, 100] 之间。 
// K 的范围在 [1, N] 之间。 
// times 的长度在 [1, 6000] 之间。 
// 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。 
// 
// Related Topics 堆 深度优先搜索 广度优先搜索 图


package leetcode.editor.cn;

import java.util.*;

class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        int[][] arr = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int i = solution.networkDelayTime(arr, 4, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int networkDelayTime(int[][] times, int N, int K) {
            int[][] time = new int[N][N];
            for (int i = 0; i < time.length; i++) {
                for (int j = 0; j < time[0].length; j++) {
                    time[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < times.length; i++) {
                int x = times[i][0];
                int y = times[i][1];
                int delay = times[i][2];
                time[x - 1][y - 1] = delay;
            }
            boolean[] vis = new boolean[N];//判断是否将节点加入close的状态bool值数组
            long[] dis = new long[N];//K节点到其他节点的距离值
            Arrays.fill(dis, Integer.MAX_VALUE);
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (int) (dis[o1] - dis[o2]));
            dis[K - 1] = 0;
            queue.offer(K - 1);
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                if(vis[poll])
                    continue;
                vis[poll] = true;
                for (int i = 0; i < N; i++) {
                    int next = time[poll][i];
                    if (next != Integer.MAX_VALUE) {
                        dis[i] = Math.min(dis[poll] + next, dis[i]);
                        if (!vis[i]&&!queue.contains(i)) {
                            queue.offer(i);
                        }
                    }
                }
            }
            long ret = Arrays.stream(dis).max().getAsLong();
            return ret == Integer.MAX_VALUE ? -1 : (int) ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}