package n;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e2 implements View.OnTouchListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ f2 f8377u;

    public e2(f2 f2Var) {
        this.f8377u = f2Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f2 f2Var = this.f8377u;
        c2 c2Var = f2Var.L;
        Handler handler = f2Var.P;
        a0 a0Var = f2Var.T;
        int action = motionEvent.getAction();
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (action == 0 && a0Var != null && a0Var.isShowing() && x10 >= 0 && x10 < a0Var.getWidth() && y10 >= 0 && y10 < a0Var.getHeight()) {
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
