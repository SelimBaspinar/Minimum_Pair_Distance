import java.io.*;
import java.util.*;
public class Main {
    String[] strarr;

    String s;
    int count;
    double entropy;

    public Main(String fileName, int topN) throws IOException {
        ReadFile(fileName);


        computeEntropy();
        computeAvgLengthByFirstChar();
        Set pairs = calculateMinPairDist();
    }

    private void ReadFile(String fileName) throws IOException {

        try {
            File file = new File("C:\\" + fileName + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            String cont = "";
            while ((st = br.readLine()) != null) {
                cont += st;
            }
            s = cont;
            String split = cont.replaceAll("\\pP", "");
            String split1 = split.toLowerCase();
            String split3 = split1.replaceAll("\n","");
            String[] st1 = split3.split("\\s+");
            strarr = st1;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void printCount(String[] names, int a) {

        Map<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < names.length; i++) {
            String bl = (String) hm.get(names[i]);
            if (bl == null) {
                hm.put(names[i], String.valueOf(1));
            } else {
                String k = hm.get(names[i]);
                int j = Integer.valueOf(k);
                hm.put(names[i], String.valueOf(j + 1));
            }

        }

        count = Integer.parseInt(hm.get(strarr[a]));


    }

    static double log2(double d, int n) {
        return Math.log(d) / Math.log(n);
    }

    private void computeEntropy() {
       for (int i = 0;i<strarr.length;i++){
            printCount(strarr,i);
                entropy -= ((double) count/(strarr.length))*log2( ( (double)count/(strarr.length)),2);
       }

        System.out.println("Entropy: "+entropy);
    }

    private void computeAvgLengthByFirstChar() {
        //Fill this function

char[] chars ={'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g' ,'ğ' ,'h' ,'ı', 'i' ,'j' ,'k' ,'l', 'm', 'n', 'o' ,'ö', 'p', 'r', 's' ,'ş', 't', 'u', 'ü', 'v','w','x','y', 'z',
        '0','1','2','3','4','5','6','7','8','9'};
for (int i = 0;i<chars.length;i++){
    int wordcount=0;
    int wordlength = 0;
    for (String a: strarr){
        if (a.charAt(0)==chars[i]){
            wordcount++;
            wordlength +=a.length();
        }
    }
    if (wordcount>0){
        double avgLength = (double)wordlength/wordcount;
        System.out.println(chars[i]+"..."+avgLength);
    }
}
    }


        static int minimumDistance(String[] array,String x,String y){
        int prev,i=0;
        prev = 0;
        int dist = Integer.MAX_VALUE;
        for(i=0; i<array.length; i++){
            if(array[i].equals(x) || array[i].equals(y)){
                prev  = i;
                break;
            }
        }
        for(i=prev+1; i<array.length; i++){
            if(array[i].equals(x) || array[i].equals(y)){
                if(!array[i].equals(array[prev]) && (i-prev) < dist)
                {
                    dist = i-prev;
                    prev = i;
                }
                else{
                    prev = i;
                }
            }
        }
        return dist;
    }
    public  void counter(String[] names, String a){

        Map<String, String> hm = new HashMap<String, String>();
        for(int i=0;i<names.length;i++)
        {
            String bl=(String)hm.get(names[i]);
            if(bl==null)
            {
                hm.put(names[i],String.valueOf(1));
            }else
            {
                String k=hm.get(names[i]);
                int j=Integer.valueOf(k);
                hm.put(names[i],String.valueOf(j+1));
            }

        }

        count = Integer.parseInt(hm.get(a));


    }

    private Set calculateMinPairDist() throws IOException {
        //Fill this function


       int counta,countb,counte,countf,counth,countj,countl,countn,countp,countr,counts;
String a,b,e,f,h,j,l,n,p,r,s;
a="yerleşkesindeki";b="ve";e="sayılı";f="tarih";h="donanımlı";
j="öğrencileri";l="söyleşilere";n="yaratıcı";p="eden";r="30425";
s="kültürel";
            counter(strarr,a);
            counta=count;
        counter(strarr,b);
            countb=count;
        counter(strarr,e);
        counte=count;
        counter(strarr,f);
        countf=count;
        counter(strarr,h);
        counth=count;
        counter(strarr,j);
        countj=count;
        counter(strarr,l);
        countl=count;
        counter(strarr,n);
        countn=count;
        counter(strarr,p);
        countp=count;
        counter(strarr,r);
        countr=count;
        counter(strarr,s);
        counts=count;
        for(int i=0; i<strarr.length; i++){

        }


        double total1= ((double)(counta*countb)/(1+Math.log(minimumDistance(strarr,a,b))));
        double total2 = ((double)(countb*counte)/(1+Math.log(minimumDistance(strarr,b,e))));
        double total3 = ((double)(countf*countb)/(1+Math.log(minimumDistance(strarr,f,b))));
        double total4= ((double)(counth*countb)/(1+Math.log(minimumDistance(strarr,h,b))));
        double total5 = ((double)(countj*countb)/(1+Math.log(minimumDistance(strarr,j,b))));
        double total6 = ((double)(countl*countb)/(1+Math.log(minimumDistance(strarr,l,b))));
        double total7 = ((double)(countn*countb)/(1+Math.log(minimumDistance(strarr,n,b))));
        double total8 = ((double)(countp*countb)/(1+Math.log(minimumDistance(strarr,p,b))));
        double total9 = ((double)(countb*countr)/(1+Math.log(minimumDistance(strarr,b,r))));
        double total10 = ((double)(counts*countb)/(1+Math.log(minimumDistance(strarr,s,b))));

            System.out.println("Pair{"+"t1='"+a+"'"+"t2='"+b+"' "+"Score="+total1);
        System.out.println("Pair{"+"t1='"+b+"'"+"t2='"+e+"' "+"Score="+total2);
        System.out.println("Pair{"+"t1='"+f+"'"+"t2='"+b+"' "+"Score="+total3);
        System.out.println("Pair{"+"t1='"+h+"'"+"t2='"+b+"' "+"Score="+total4);
        System.out.println("Pair{"+"t1='"+j+"'"+"t2='"+b+"' "+"Score="+total5);
        System.out.println("Pair{"+"t1='"+l+"'"+"t2='"+b+"' "+"Score="+total6);
        System.out.println("Pair{"+"t1='"+n+"'"+"t2='"+b+"' "+"Score="+total7);
        System.out.println("Pair{"+"t1='"+p+"'"+"t2='"+b+"' "+"Score="+total8);
        System.out.println("Pair{"+"t1='"+b+"'"+"t2='"+r+"' "+"Score="+total9);
        System.out.println("Pair{"+"t1='"+s+"'"+"t2='"+b+"' "+"Score="+total10);



        return null;
    }



    public static void main(String[] args) throws IOException {
        new Main("sampleText",3);
    }
}