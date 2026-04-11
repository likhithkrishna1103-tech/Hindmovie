package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends d1 implements l {
    public final Object X(td.c cVar) throws Throwable {
        Object obj;
        do {
            obj = d1.f7686u.get(this);
            if (!(obj instanceof s0)) {
                if (obj instanceof o) {
                    throw ((o) obj).f7717a;
                }
                return x.o(obj);
            }
        } while (T(obj) < 0);
        a1 a1Var = new a1(a.a.w(cVar), this);
        a1Var.v();
        a1Var.y(new i0(x.i(this, true, new i(3, a1Var))));
        return a1Var.u();
    }
}
