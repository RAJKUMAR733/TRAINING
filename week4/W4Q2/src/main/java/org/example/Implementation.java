package org.example;

import java.util.concurrent.RecursiveTask;

public class Implementation extends RecursiveTask<Integer> {
    private int target;

    private int start;
    private int end;
    private int limit = 100;

    public Implementation(int target, int start, int end, int limit) {
        this.target = target;
        this.start = start;
        this.end = end;
        this.limit=limit;
    }

    @Override
    protected Integer compute() {
        if(end-start+1 == limit){
            return countInstance();
        }
        for (int i=start; i <= end; i=i+limit){
            Implementation implementation = new Implementation(target,start,end-limit,limit);
            implementation.fork();
            return implementation.join() + countInstance();
        }
        return 0;

        }
    public int countInstance()
    {
        int count=0;
        for(int i=start;i<=end;i++)
        {
            int n=i;
            while(n>0)
            {
                int rem=n%10;
                if(rem==9)
                    count++;
                n=n/10;
            }
        }
        return count;

    }

    }




