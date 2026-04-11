package aa;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends d0 {
    @Override // aa.d0
    public final d0 c(Object obj) {
        obj.getClass();
        a(obj);
        return this;
    }

    public final o0 g() {
        int i = this.f658b;
        if (i == 0) {
            int i10 = o0.f718w;
            return i1.D;
        }
        if (i != 1) {
            o0 o0VarN = o0.n(i, this.f657a);
            this.f658b = o0VarN.size();
            this.f659c = true;
            return o0VarN;
        }
        Object obj = this.f657a[0];
        Objects.requireNonNull(obj);
        int i11 = o0.f718w;
        return new o1(obj);
    }
}
