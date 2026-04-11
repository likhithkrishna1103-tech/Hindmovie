package androidx.lifecycle;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements s {
    public static final c0 D = new c0();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1147v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1148w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Handler f1151z;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1149x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1150y = true;
    public final u A = new u(this);
    public final androidx.emoji2.text.w B = new androidx.emoji2.text.w(2, this);
    public final p6.c C = new p6.c(4, this);

    public final void b() {
        int i = this.f1148w + 1;
        this.f1148w = i;
        if (i == 1) {
            if (this.f1149x) {
                this.A.d(m.ON_RESUME);
                this.f1149x = false;
            } else {
                Handler handler = this.f1151z;
                ge.i.b(handler);
                handler.removeCallbacks(this.B);
            }
        }
    }

    @Override // androidx.lifecycle.s
    public final u f() {
        return this.A;
    }
}
