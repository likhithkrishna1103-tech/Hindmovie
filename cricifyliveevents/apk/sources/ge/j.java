package ge;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements g, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f5250v;

    public j(int i) {
        this.f5250v = i;
    }

    @Override // ge.g
    public final int e() {
        return this.f5250v;
    }

    public final String toString() {
        q.f5255a.getClass();
        String strA = r.a(this);
        i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
