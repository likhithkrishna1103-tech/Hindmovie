package tc;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.playz.tv.services.FloatingPlayer;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnTouchListener {
    public final /* synthetic */ View A;
    public final /* synthetic */ b2.g B;
    public final /* synthetic */ FloatingPlayer C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a1 f12450u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12451v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12452w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f12453x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f12454y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f12455z;

    public b(FloatingPlayer floatingPlayer, WindowManager.LayoutParams layoutParams, RelativeLayout relativeLayout, b2.g gVar) {
        this.C = floatingPlayer;
        this.f12455z = layoutParams;
        this.A = relativeLayout;
        this.B = gVar;
        this.f12450u = new a1(floatingPlayer.getApplicationContext(), new c(this));
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        return ((GestureDetector) this.f12450u.f8343u).onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FloatingPlayer floatingPlayer = this.C;
        if (floatingPlayer.f3689y.f3678v == null) {
            int action = motionEvent.getAction();
            WindowManager.LayoutParams layoutParams = this.f12455z;
            if (action == 0) {
                this.f12451v = layoutParams.x;
                this.f12452w = layoutParams.y;
                this.f12453x = motionEvent.getRawX();
                this.f12454y = motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) (motionEvent.getRawX() - this.f12453x);
                int rawY = (int) (motionEvent.getRawY() - this.f12454y);
                layoutParams.x = this.f12451v + rawX;
                layoutParams.y = this.f12452w + rawY;
                floatingPlayer.f3685u.updateViewLayout(this.A, layoutParams);
            }
        }
        return a(view, motionEvent);
    }
}
