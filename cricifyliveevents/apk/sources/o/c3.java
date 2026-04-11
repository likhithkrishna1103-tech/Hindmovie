package o;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c3 extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f9187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f9188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f9189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f9190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9191e;
    public boolean f;

    public c3(View view, Rect rect, Rect rect2) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f9191e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f9188b = rect3;
        Rect rect4 = new Rect();
        this.f9190d = rect4;
        Rect rect5 = new Rect();
        this.f9189c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i = -scaledTouchSlop;
        rect4.inset(i, i);
        rect5.set(rect2);
        this.f9187a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z12 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z11 = this.f;
                if (z11 && !this.f9190d.contains(x10, y10)) {
                    z12 = z11;
                    z10 = false;
                }
            } else {
                if (action == 3) {
                    z11 = this.f;
                    this.f = false;
                }
                z10 = true;
                z12 = false;
            }
            z12 = z11;
            z10 = true;
        } else if (this.f9188b.contains(x10, y10)) {
            this.f = true;
            z10 = true;
        } else {
            z10 = true;
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        Rect rect = this.f9189c;
        View view = this.f9187a;
        if (!z10 || rect.contains(x10, y10)) {
            motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
