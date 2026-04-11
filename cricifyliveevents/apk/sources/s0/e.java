package s0;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f11146x;

    public e(int i) {
        super(i);
        this.f11146x = new Object();
    }

    @Override // s0.d, s0.c
    public final boolean b(Object obj) {
        boolean zB;
        i.e(obj, "instance");
        synchronized (this.f11146x) {
            zB = super.b(obj);
        }
        return zB;
    }

    @Override // s0.d, s0.c
    public final Object i() {
        Object objI;
        synchronized (this.f11146x) {
            objI = super.i();
        }
        return objI;
    }
}
