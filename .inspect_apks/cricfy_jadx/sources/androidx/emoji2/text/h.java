package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import v4.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f858c;

    public h(int i, String str, String str2) {
        this.f856a = i;
        this.f857b = str;
        this.f858c = str2;
    }

    public static h b(h0 h0Var, int i) {
        if (i == 0) {
            return new v4.t(h0Var, 0);
        }
        if (i == 1) {
            return new v4.t(h0Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract void a(c5.a aVar);

    public abstract void c(c5.a aVar);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o(View view);

    public abstract int p(View view);

    public abstract void q(int i);

    public abstract void r(c5.a aVar);

    public abstract void s(c5.a aVar);

    public abstract void t(c5.a aVar);

    public abstract void u(c5.a aVar);

    public abstract i8.a v(c5.a aVar);

    public h(h0 h0Var) {
        this.f856a = Integer.MIN_VALUE;
        this.f858c = new Rect();
        this.f857b = h0Var;
    }

    public h(l lVar) {
        this.f856a = 0;
        this.f858c = new e();
        this.f857b = lVar;
    }
}
