package o;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements View.OnTouchListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g2 f9218v;

    public f2(g2 g2Var) {
        this.f9218v = g2Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        g2 g2Var = this.f9218v;
        c2 c2Var = g2Var.M;
        Handler handler = g2Var.Q;
        y yVar = g2Var.U;
        int action = motionEvent.getAction();
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (action == 0 && yVar != null && yVar.isShowing() && x10 >= 0 && x10 < yVar.getWidth() && y10 >= 0 && y10 < yVar.getHeight()) {
            handler.postDelayed(c2Var, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        handler.removeCallbacks(c2Var);
        return false;
    }
}
