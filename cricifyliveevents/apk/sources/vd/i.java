package vd;

import fe.p;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f13722v = new i();

    @Override // vd.h
    public final f C(g gVar) {
        ge.i.e(gVar, "key");
        return null;
    }

    @Override // vd.h
    public final h O(g gVar) {
        ge.i.e(gVar, "key");
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // vd.h
    public final h q(h hVar) {
        ge.i.e(hVar, "context");
        return hVar;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // vd.h
    public final Object J(Object obj, p pVar) {
        return obj;
    }
}
