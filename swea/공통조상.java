package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공통조상 {
	
	static int v, e, node1, node2, ancester, child;
	static int[] parentNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			child = 0;
			List<Integer> parent1 = new ArrayList<>();
			List<Integer> parent2 = new ArrayList<>();
			parentNode = new int[v + 1];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parentNode[child] = parent;
			}
			// 부모 노드 구하기
			getParentNode(node1, parent1);
			getParentNode(node2, parent2);
			// 가장 가까운 공통 조상 구하기
			ancester = getCommonAncestor(parent1, parent2);
			getCountChild(ancester);
			System.out.printf("#%d %d %d\n", testCase, ancester, child + 1);
		}
	}

	private static void getCountChild(int ancester) {
		for (int j = 1; j < parentNode.length; j++) {
			if (parentNode[j] == ancester) {
				child++;
				getCountChild(j);
				
			}
		}
	}

	private static int getCommonAncestor(List<Integer> parent1, List<Integer> parent2) {
		for (int node1 : parent1) {
			for (int node2 : parent2) {
				if (node1 == node2) {
					return node1;
				}
			}	
		}
		return -1;
	}

	private static void getParentNode(int node, List<Integer> parent) {
		// 루트 노드 
		if (parentNode[node] == 0) {
			return;
		}
		parent.add(parentNode[node]);
		getParentNode(parentNode[node], parent);
	}
}
