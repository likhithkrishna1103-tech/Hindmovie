package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w f1138u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public w f1139v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1140w = false;

    public u(w wVar) {
        this.f1138u = wVar;
        this.f1139v = (w) wVar.d(4);
    }

    public static void d(w wVar, w wVar2) {
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        y0Var.a(wVar.getClass()).h(wVar, wVar2);
    }

    public final w a() {
        w wVarB = b();
        if (wVarB.g()) {
            return wVarB;
        }
        throw new a2.y0();
    }

    public final w b() {
        if (this.f1140w) {
            return this.f1139v;
        }
        w wVar = this.f1139v;
        wVar.getClass();
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        y0Var.a(wVar.getClass()).c(wVar);
        this.f1140w = true;
        return this.f1139v;
    }

    public final void c() {
        if (this.f1140w) {
            w wVar = (w) this.f1139v.d(4);
            d(wVar, this.f1139v);
            this.f1139v = wVar;
            this.f1140w = false;
        }
    }

    public final Object clone() {
        u uVar = (u) this.f1138u.d(5);
        w wVarB = b();
        uVar.c();
        d(uVar.f1139v, wVarB);
        return uVar;
    }
}
