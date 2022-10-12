package com.company;

import java.io.UnsupportedEncodingException;

public class Maximum_Product_Subarray {
    public static int maxProduct(int[] nums) {
        if (nums.length==1) return nums[0];
        int local = 1;
        int global = nums[0];
        int min = 1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                global = Math.max(global,local*nums[i]);
                local = local*nums[i];
                min = min * nums[i];
            }else if(nums[i]<0){
                global = Math.max(global,min*nums[i]);
                int tmp = local;
                local = Math.max(min*nums[i],1);
                min = tmp*nums[i];
            }else {
                global = Math.max(global,0);
                local = 1;
                min = 1;
            }
            System.out.println("nums[i]="+nums[i]+" loacl="+local+" global="+global+" min"+min);

        }
        return global;
    }

    public static String changeEncoding(String inputHtml)
            throws UnsupportedEncodingException {

        String jpString = new String(inputHtml.getBytes("Shift_JIS"), "GBK");//8859_1   Shift_JIS
        return jpString;

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //int[] a = {-2,3,-4};
        //System.out.println(maxProduct(a));
        String jp ="リル変身  リル光   発動   光る  洪水 集束  結界  泡湊月  水   水ダイジェスト  渦  消滅  儀式  転落";
        System.out.println(changeEncoding(jp));
    }
}
