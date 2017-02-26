package Utils;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by ASUS on 2017/2/26.
 */

public class AnimationUtils {
    public static int runningCount = 0;
    public static void rotaOutAnimation(RelativeLayout layout) {
        int child = layout.getChildCount();
        for(int i = 0;i<child;i++){
            layout.getChildAt(i).setEnabled(false);
        }
        RotateAnimation ra = new RotateAnimation(
                0f, -180f, // 开始, 结束的角度, 逆时针
                Animation.RELATIVE_TO_SELF, 0.5f,  // 相对的x坐标点(指定旋转中心x值)
                Animation.RELATIVE_TO_SELF, 1.0f); // 相对的y坐标点(指定旋转中心y值)
        ra.setDuration(300);
        ra.setFillAfter(true);
        layout.startAnimation(ra);
        ra.setAnimationListener(new MyAnimationListener());
    }
    static  class MyAnimationListener implements Animation.AnimationListener{



        public void onAnimationStart(Animation animation) {
            runningCount ++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            runningCount --;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
    public static void rotaIntAnimation(RelativeLayout layout) {
        int child = layout.getChildCount();
        for(int i = 0;i<child;i++){
            layout.getChildAt(i).setEnabled(true);}
        RotateAnimation ra = new RotateAnimation(
                -180, -0f, // 开始, 结束的角度, 逆时针
                Animation.RELATIVE_TO_SELF, 0.5f,  // 相对的x坐标点(指定旋转中心x值)
                Animation.RELATIVE_TO_SELF, 1.0f); // 相对的y坐标点(指定旋转中心y值)
        ra.setDuration(300);
        ra.setFillAfter(true);
        layout.startAnimation(ra);
    }
}
