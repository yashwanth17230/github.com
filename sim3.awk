BEGIN{
    c1=0
    c2=0
    p1=0
    p2=0
    t1=0
    t2=0
    }
    {
    if($1=="r" && $3=="_3_"&& $4=="RTR"){
    c1++
    p1=p1+$8
    t1=$2
    }
    if($1=="r" && $3=="_5_"&& $4=="RTR"){
    c2++
    p2=p2+$8
    t2=$2
    }
    }
    END{
    printf("the throughput from n0 to n3:%fMbps\n", ((c1*p1*8)/(t1*1000000)));
    printf("the throughput from n0 to n3:%fMbps\n",((c2*p2*8)/(t2*1000000)));
    }
    

    
