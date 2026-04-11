package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f881a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f885e;
    public int f;

    public u(z zVar) {
        this.f882b = zVar;
        this.f883c = zVar;
    }

    public final void a() {
        this.f881a = 1;
        this.f883c = this.f882b;
        this.f = 0;
    }

    public final boolean b() {
        l1.a aVarB = this.f883c.f902b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.f7627y).get(iA + aVarB.f7624v) == 0) || this.f885e == 65039;
    }
}
