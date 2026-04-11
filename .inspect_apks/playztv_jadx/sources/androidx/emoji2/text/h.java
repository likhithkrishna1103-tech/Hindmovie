package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import q4.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1176c;

    public h(int i, String str, String str2) {
        this.f1174a = i;
        this.f1175b = str;
        this.f1176c = str2;
    }

    public static h b(h0 h0Var, int i) {
        if (i == 0) {
            return new q4.u(h0Var, 0);
        }
        if (i == 1) {
            return new q4.u(h0Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract void a(y4.a aVar);

    public abstract void c(y4.a aVar);

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

    public abstract void r(y4.a aVar);

    public abstract void s(y4.a aVar);

    public abstract void t(y4.a aVar);

    public abstract void u(y4.a aVar);

    public abstract n7.a v(y4.a aVar);

    public h(h0 h0Var) {
        this.f1174a = Integer.MIN_VALUE;
        this.f1176c = new Rect();
        this.f1175b = h0Var;
    }

    public h(l lVar) {
        this.f1174a = 0;
        this.f1176c = new e();
        this.f1175b = lVar;
    }
}
