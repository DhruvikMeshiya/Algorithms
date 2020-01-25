class ChainMatrix
{
    public static void main(String[] args)
    {
        int M[][]=new int[5][5];
        int P[] = { 5, 4, 6, 2, 7 };
        int N[][] = new int[5][5];
        int s = M.length-1;
        for (int j = 0; j < s; j++)
        {
           for(int i=1;i<M.length-j;i++)
           {
                if(j==0)
                {
                    M[i][i+j] = 0;
                }
                else if(j==1)
                {
                    M[i][i+j]=P[i-1]*P[i]*P[i+1];
                }
                else
                {
                    M[i][i+j]=100000000;
                    for(int k=i;k<i+j;k++)
                    {
                        if(M[i][i+j]>M[i][k] + M[k+1][i+j] + P[i-1]*P[k]*P[i+j])
                        {
                            M[i][i+j] = M[i][k]+M[k+1][i+j]+P[i-1]*P[k]*P[i+j];
                            N[i][i+j] = k;
                        }
                    }
                }
            }
        }
        System.out.println("Matrix represents number of multiplications : ");
        for(int i=1;i<M.length;i++)
        {
            for(int j=1;j<M.length;j++)
            {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Matrix represents value of k : ");

        for(int i=1;i<M.length;i++)
        {
            for(int j=1;j<M.length;j++)
            {
                if(i==(j-1))
                    N[i][j] = i;
                System.out.print(N[i][j] + "\t");
            }
            System.out.println();
        }
    }
}