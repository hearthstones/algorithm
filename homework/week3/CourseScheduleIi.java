package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [210]课程表II
 * @author luchao
 */
public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：有向图无环
     * 主体：BFS + 拓扑排序
     * 细节：prerequisites[i] = [v, u] 表示 u -> v, 注意顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1.init
        // 出边链表
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 入度数组
        int[] inDegree = new int[numCourses];
        // bfs零入度队列
        Queue<Integer> queue = new LinkedList<>();

        // 2.建图
        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[0];
            int u = prerequisite[1];
            // 加边 u -> v
            edges.get(u).add(v);
            // v入度加1
            inDegree[v]++;
        }

        // 3.BFS + 拓扑排序
        // 零入度入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // bfs
        int count = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            // 出队，count++统计入队（出队）课程数，ans[count]记录课程顺序
            int head = queue.poll();
            ans[count++] = head;
            // bfs出边
            for (int edge : edges.get(head)) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        // bfs后所有课程都为零入度，则有向图无环
        return count == numCourses ? ans : new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}