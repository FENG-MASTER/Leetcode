package Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */
public class CmaxPoints {
    public static int maxPoints(Point[] points) {
        if (points==null||points.length==0){
            return 0;
        }
        if (points.length==1){
            return 1;
        }

        int maxLen=Integer.MIN_VALUE;

        for (int i =0;i<points.length;i++){


            int thisLen=0;
            Map<Double,Integer> map=new HashMap<>();
            for (int j=0;j<points.length;j++){
                    double gra=getGradient(points[i],points[j]);
                    if (map.containsKey(gra)){
                        int n=map.get(gra);
                        map.put(gra,n+1);
                    }else {
                        map.put(gra,1);
                    }

            }



            for (Map.Entry<Double, Integer> e : map.entrySet()) {
                if (!e.getKey().isNaN()){
                    if (e.getValue()>thisLen){
                        thisLen=e.getValue();
                    }
                }
            }

            if (map.containsKey(Double.NaN)){
                //如果有相同的点,加进去
                thisLen+=map.get(Double.NaN);
            }

            if(thisLen>maxLen){
                maxLen=thisLen;
            }



        }

        return maxLen;

    }

    public static double getGradient(Point p1,Point p2){
        if (p1==null||p2==null){
            return 0;
        }

        return (p2.x-p1.x)/((double)(p2.y-p1.y));
    }


    public static void main(String args[]){
        Point p=new Point();
        p.y=0;
        p.x=0;
        Point p2=new Point();
        p2.x=8;
        p2.y=0;

        Point p3=new Point();
        p3.x=1;
        p3.y=1;

        Point ps[]=new Point[3];
        ps[0]=p;
        ps[1]=p2;
        ps[2]=p3;

        System.out.println(maxPoints(ps));



    }



}
