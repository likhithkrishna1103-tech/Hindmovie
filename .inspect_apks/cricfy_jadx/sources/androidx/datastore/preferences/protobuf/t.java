package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Cloneable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f794v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v f795w;

    public t(v vVar) {
        this.f794v = vVar;
        if (vVar.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f795w = vVar.i();
    }

    public final v a() {
        v vVarB = b();
        vVarB.getClass();
        if (v.f(vVarB, true)) {
            return vVarB;
        }
        throw new a1();
    }

    public final v b() {
        if (!this.f795w.g()) {
            return this.f795w;
        }
        v vVar = this.f795w;
        vVar.getClass();
        r0 r0Var = r0.f786c;
        r0Var.getClass();
        r0Var.a(vVar.getClass()).d(vVar);
        vVar.h();
        return this.f795w;
    }

    public final void c() {
        if (this.f795w.g()) {
            return;
        }
        v vVarI = this.f794v.i();
        v vVar = this.f795w;
        r0 r0Var = r0.f786c;
        r0Var.getClass();
        r0Var.a(vVarI.getClass()).a(vVarI, vVar);
        this.f795w = vVarI;
    }

    public final Object clone() {
        t tVar = (t) this.f794v.c(5);
        tVar.f795w = b();
        return tVar;
    }
}
