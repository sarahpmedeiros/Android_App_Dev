package cs.hangman;

import android.util.Log;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.RelativeLayout;
import android.graphics.Point;
import android.view.Display;
/**
 * Created by Sarah on 2/26/17.
 */

public class Hangman extends View{
    private Rect rectangle;
    private Paint paint;
    private Paint bod;
    public Hangman(Context context){
        super(context);
//        int x = 50;
//        int y = 50;
        float lineWidth = 70;

        // create a rectangle that we'll draw later
//        base = new
//        rectangle = new Rect(x, y, sideLength, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(lineWidth);

        bod = new Paint();
        bod.setColor(Color.WHITE);
        bod.setStrokeWidth(30);
    }
    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.WHITE);
//        canvas.drawRect(rectangle, paint);

//
//        Point mdispSize = new Point();
//        mdisp.getSize(mdispSize);
//        int maxX = mdispSize.x;
//        int maxY = mdispSize.y;
//        RelativeLayout rel = (RelativeLayout)findViewById(R.id.relHangman);
//        Rect r = canvas.getClipBounds();
//        float startX = r.centerX();

        Rect myViewRect = new Rect();
//        myView.getGlobalVisibleRect(myViewRect);
        float x = myViewRect.right;
        float y = myViewRect.top;

        float startX = 0;
        float startY = getBottom();
        float stopX = getX();
        float stopY =0;
        float headX = 250;
        float headY = 110;

//        canvas.drawCircle(headX, headY, 70, paint);//head
        canvas.drawLine(startX,startY,stopX,stopY,paint);//vertical bar
        canvas.drawLine(getX(),0,(getBottom()-100),0,paint); //horizontal bar
//        canvas.drawLine(headX,headY,headX,getBottom()-130,bod);//line from head
//
//
////        canvas.drawLine(getBottom()-280,getBottom()-150,getBottom()-180,getBottom()-50,bod);//right leg
//        canvas.drawLine(240,getBottom()-150,getBottom()-110,getBottom()-60,bod);//right leg
//
//
//        canvas.drawLine(headX,getBottom()-200,getRight()-150,180,bod);//right arm
//
//
//        canvas.drawLine(120,180,headX,getBottom()-200,bod);//left arm
//
//        canvas.drawLine(120,getBottom()-60,260,getBottom()-150,bod);//left leg


//        Log.d("help",String.valueOf(this.getBottom()));
//        Log.d("help",String.valueOf(this.getTop()));
//        Log.d("help",String.valueOf(this.getWidth()));
//        Log.d("help",String.valueOf(this.getHeight()));
//        Log.d("help",String.valueOf(this.getRight()));
//        Log.d("help",String.valueOf(this.getLeft()));
//        Log.d("help",String.valueOf(this.getX()));
//        canvas.drawLine(startX,getTop(),500,getBottom()+400,bod);//right arm
    }
}
