package n;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f8591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f8593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8594e;
    public boolean f;

    public y2(View view, Rect rect, Rect rect2) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f8594e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f8591b = rect3;
        Rect rect4 = new Rect();
        this.f8593d = rect4;
        Rect rect5 = new Rect();
        this.f8592c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i = -scaledTouchSlop;
        rect4.inset(i, i);
        rect5.set(rect2);
        this.f8590a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z10;
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z11 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z10 = this.f;
                if (z10 && !this.f8593d.contains(x10, y10)) {
                    z11 = z10;
                    z2 = false;
                }
            } else {
                if (action == 3) {
                    z10 = this.f;
                    this.f = false;
                }
                z2 = true;
                z11 = false;
            }
            z11 = z10;
            z2 = true;
        } else if (this.f8591b.contains(x10, y10)) {
            this.f = true;
            z2 = true;
        } else {
            z2 = true;
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        Rect rect = this.f8592c;
        View view = this.f8590a;
        if (!z2 || rect.contains(x10, y10)) {
            motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
