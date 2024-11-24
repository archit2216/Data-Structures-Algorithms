class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] arr=new char[m][n];
        for(int i=0;i<guards.length;i++){
            int x=guards[i][0];
            int y=guards[i][1];
            arr[x][y]='G';
        }
        for(int i=0;i<walls.length;i++){
            int x=walls[i][0];
            int y=walls[i][1];
            arr[x][y]='W';
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='G'){
                    int x=i-1;
                    int y=j;
                    while(x>=0 && arr[x][y]!='W' && arr[x][y]!='G'){
                        arr[x][y]='Y';
                        x--;
                    }
                    x=i;
                    y=j-1;
                    while(y>=0 && arr[x][y]!='W' && arr[x][y]!='G'){
                        arr[x][y]='Y';
                        y--;
                    }
                    x=i+1;
                    y=j;
                    while(x<arr.length && arr[x][y]!='W' && arr[x][y]!='G'){
                        arr[x][y]='Y';
                        x++;
                    }
                    x=i;
                    y=j+1;
                    while(y<arr[0].length && arr[x][y]!='W' && arr[x][y]!='G'){
                        arr[x][y]='Y';
                        y++;
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='\u0000'){
                    count++;
                }
            }
        }
        return count;
    }
}