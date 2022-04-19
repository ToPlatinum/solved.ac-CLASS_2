package Study;

import java.util.*;

class Get {
	int x,y,count;
	boolean Gram; // 그람의 획득 여부를 체크하는 변수
	
	public Get(int x, int y, int count, boolean gram) {
		this.x=x;
		this.y=y;
		this.count=count;
		this.Gram= gram;
	}
}
public class BJ_17836_다연님구하기 {
	
	static int N,M,T;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		T=sc.nextInt(); //제한시간
		
		map=new int[N][M]; //성
		visited=new boolean[N][M][2]; // 그람이 있을때와 없을 때
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				map[i][j]=sc.nextInt();
		
		int result=bfs(0,0);
		if(result==-1)
			System.out.println("Fail");
		else 
			System.out.println(result);
	}
	
	static int bfs(int x, int y) {
		Queue<Get> Q=new LinkedList<>();
		Q.offer(new Get(x,y,0,false)); // (0,0)에서 그람 없이 시작
		visited[x][y][0]=true;
		
		while(!Q.isEmpty()) {
			Get g = Q.poll();
			
			if(g.count>T) // 공주를 구할수 없는 경우 : t시간이 지남 
				break;
			
			if(g.x==N-1&&g .y==M-1) // 공주구하면
				return g .count;
			
			for(int i=0;i<4;i++) {
				int nx=g.x+dx[i];
				int ny=g.y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(!g .Gram) { // 그람이 없을 때
						if(!visited[nx][ny][0]&&map[nx][ny]==0) {
							visited[nx][ny][0]=true;
							Q.offer(new Get(nx,ny,g .count+1,false));
						}
						// 상,하,좌,우를 탐색하다 그람을 획득한 경우
						else if(!visited[nx][ny][0]&&map[nx][ny]==2) {
							visited[nx][ny][0]=true;
							Q.offer(new Get(nx,ny,g .count+1,true)); // get을 true로 그람획득
						}
						
					}
					else { // 그람을 가지고 있을 때 - 벽 제한 없음
						if(!visited[nx][ny][1]) {
							visited[nx][ny][1]=true;
							Q.offer(new Get(nx,ny,g .count+1,true));
						}
					}
				}
			}
		}
		return -1;
	}
}
