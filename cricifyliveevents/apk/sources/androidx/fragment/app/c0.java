package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.google.android.gms.internal.measurement.z3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends z3 implements androidx.lifecycle.u0, androidx.lifecycle.s, b5.f, v0 {
    public final /* synthetic */ h.j A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h.j f951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h.j f952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final r0 f954z;

    public c0(h.j jVar) {
        this.A = jVar;
        Handler handler = new Handler();
        this.f954z = new r0();
        this.f951w = jVar;
        this.f952x = jVar;
        this.f953y = handler;
    }

    @Override // b5.f
    public final b5.e a() {
        return (b5.e) this.A.f1977y.f2291x;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        return this.A.e();
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.A.R;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final View p(int i) {
        return this.A.findViewById(i);
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final boolean q() {
        Window window = this.A.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.fragment.app.v0
    public final void b(y yVar) {
    }
}
