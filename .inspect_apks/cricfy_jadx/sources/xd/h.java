package xd;

import ge.i;
import ge.q;
import ge.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends c implements ge.g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f14488y;

    public h(int i, vd.c cVar) {
        super(cVar);
        this.f14488y = i;
    }

    @Override // ge.g
    public final int e() {
        return this.f14488y;
    }

    @Override // xd.a
    public final String toString() {
        if (this.f14482v != null) {
            return super.toString();
        }
        q.f5255a.getClass();
        String strA = r.a(this);
        i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
