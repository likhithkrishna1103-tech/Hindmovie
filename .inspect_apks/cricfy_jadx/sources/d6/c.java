package d6;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import app.cricfy.tv.services.FloatingPlayer;
import nc.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ WindowManager.LayoutParams A;
    public final /* synthetic */ View B;
    public final /* synthetic */ p C;
    public final /* synthetic */ FloatingPlayer D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l4.a f3403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3407z;

    public c(FloatingPlayer floatingPlayer, WindowManager.LayoutParams layoutParams, RelativeLayout relativeLayout, p pVar) {
        this.D = floatingPlayer;
        this.A = layoutParams;
        this.B = relativeLayout;
        this.C = pVar;
        this.f3403v = new l4.a(floatingPlayer.getApplicationContext(), new d(this));
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        return ((GestureDetector) this.f3403v.f7697v).onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FloatingPlayer floatingPlayer = this.D;
        if (floatingPlayer.f1579z.f1569w == null) {
            int action = motionEvent.getAction();
            WindowManager.LayoutParams layoutParams = this.A;
            if (action == 0) {
                this.f3404w = layoutParams.x;
                this.f3405x = layoutParams.y;
                this.f3406y = motionEvent.getRawX();
                this.f3407z = motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) (motionEvent.getRawX() - this.f3406y);
                int rawY = (int) (motionEvent.getRawY() - this.f3407z);
                layoutParams.x = this.f3404w + rawX;
                layoutParams.y = this.f3405x + rawY;
                floatingPlayer.f1575v.updateViewLayout(this.B, layoutParams);
            }
        }
        return a(view, motionEvent);
    }
}
