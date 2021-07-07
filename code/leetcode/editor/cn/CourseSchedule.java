package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [207]课程表
 * @author luchao
 */
public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：有向图找环
     * 主体：BFS + 拓扑排序
     * 细节：prerequisites[i] = [ai, bi]，bi -> ai
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // 建图，prerequisite = [v, u]
        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[0];
            int u = prerequisite[1];
            // 加边 u -> v
            edges.get(u).add(v);
            // v入度加1
            inDegree[v]++;
        }

        // BFS + 拓扑排序
        // 零入度点入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // bfs
        int count = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            // 记录入队\出队的点个数
            count++;
            // head零入度，出队，bfs下层点
            for (int edge : edges.get(head)) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        // 只有零度点可以入队、出队，count == 课程数，则表示所有点都是零度点，有向图无环
        return numCourses == count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}