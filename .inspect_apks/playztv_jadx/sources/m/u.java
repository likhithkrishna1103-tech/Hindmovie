package m;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f8267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8270e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v f8272h;
    public s i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8273j;
    public int f = 8388611;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t f8274k = new t(0, this);

    public u(Context context, k kVar, View view, boolean z2, int i, int i10) {
        this.f8266a = context;
        this.f8267b = kVar;
        this.f8270e = view;
        this.f8268c = z2;
        this.f8269d = i;
    }

    public final s a() {
        s b0Var;
        if (this.i == null) {
            Context context = this.f8266a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(g.d.abc_cascading_menus_min_smallest_width)) {
                b0Var = new e(context, this.f8270e, this.f8269d, this.f8268c);
            } else {
                b0Var = new b0(this.f8266a, this.f8267b, this.f8270e, this.f8269d, this.f8268c);
            }
            b0Var.n(this.f8267b);
            b0Var.t(this.f8274k);
            b0Var.p(this.f8270e);
            b0Var.l(this.f8272h);
            b0Var.q(this.f8271g);
            b0Var.r(this.f);
            this.i = b0Var;
        }
        return this.i;
    }

    public final boolean b() {
        s sVar = this.i;
        return sVar != null && sVar.a();
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f8273j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i10, boolean z2, boolean z10) {
        s sVarA = a();
        sVarA.u(z10);
        if (z2) {
            if ((Gravity.getAbsoluteGravity(this.f, this.f8270e.getLayoutDirection()) & 7) == 5) {
                i -= this.f8270e.getWidth();
            }
            sVarA.s(i);
            sVarA.v(i10);
            int i11 = (int) ((this.f8266a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            sVarA.f8263u = new Rect(i - i11, i10 - i11, i + i11, i10 + i11);
        }
        sVarA.d();
    }
}
