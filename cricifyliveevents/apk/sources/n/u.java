package n;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f8581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8584e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v f8586h;
    public s i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8587j;
    public int f = 8388611;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t f8588k = new t(0, this);

    public u(Context context, k kVar, View view, boolean z10, int i, int i10) {
        this.f8580a = context;
        this.f8581b = kVar;
        this.f8584e = view;
        this.f8582c = z10;
        this.f8583d = i;
    }

    public final s a() {
        s b0Var;
        if (this.i == null) {
            Context context = this.f8580a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(g.d.abc_cascading_menus_min_smallest_width)) {
                b0Var = new e(context, this.f8584e, this.f8583d, this.f8582c);
            } else {
                b0Var = new b0(this.f8580a, this.f8581b, this.f8584e, this.f8583d, this.f8582c);
            }
            b0Var.n(this.f8581b);
            b0Var.t(this.f8588k);
            b0Var.p(this.f8584e);
            b0Var.l(this.f8586h);
            b0Var.q(this.f8585g);
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
        PopupWindow.OnDismissListener onDismissListener = this.f8587j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i10, boolean z10, boolean z11) {
        s sVarA = a();
        sVarA.u(z11);
        if (z10) {
            if ((Gravity.getAbsoluteGravity(this.f, this.f8584e.getLayoutDirection()) & 7) == 5) {
                i -= this.f8584e.getWidth();
            }
            sVarA.s(i);
            sVarA.v(i10);
            int i11 = (int) ((this.f8580a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            sVarA.f8577v = new Rect(i - i11, i10 - i11, i + i11, i10 + i11);
        }
        sVarA.d();
    }
}
