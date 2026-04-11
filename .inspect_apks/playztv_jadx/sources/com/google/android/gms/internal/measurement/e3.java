package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e3 extends i5 {
    public final void g(h3 h3Var) {
        e();
        f3.t((f3) this.f3052v, (i3) h3Var.c());
    }

    public final void h(i3 i3Var) {
        e();
        f3.t((f3) this.f3052v, i3Var);
    }

    public final long i() {
        return ((f3) this.f3052v).y();
    }

    public final i3 j(int i) {
        return ((f3) this.f3052v).o(i);
    }

    public final long k() {
        return ((f3) this.f3052v).z();
    }

    public final String l() {
        return ((f3) this.f3052v).B();
    }

    public final List m() {
        return Collections.unmodifiableList(((f3) this.f3052v).C());
    }
}
