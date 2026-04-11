package rd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements c, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public fe.a f10999v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Object f11000w = k.f11002a;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f11001x = this;

    public j(fe.a aVar) {
        this.f10999v = aVar;
    }

    public final boolean a() {
        return this.f11000w != k.f11002a;
    }

    @Override // rd.c
    public final Object getValue() {
        Object objB;
        Object obj = this.f11000w;
        k kVar = k.f11002a;
        if (obj != kVar) {
            return obj;
        }
        synchronized (this.f11001x) {
            objB = this.f11000w;
            if (objB == kVar) {
                fe.a aVar = this.f10999v;
                ge.i.b(aVar);
                objB = aVar.b();
                this.f11000w = objB;
                this.f10999v = null;
            }
        }
        return objB;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
