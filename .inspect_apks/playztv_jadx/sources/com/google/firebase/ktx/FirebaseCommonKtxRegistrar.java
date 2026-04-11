package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import ma.c;
import ma.d;
import na.a;
import na.b;
import na.j;
import na.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        a aVarB = b.b(new r(ma.a.class, ke.r.class));
        aVarB.a(new j(new r(ma.a.class, Executor.class), 1, 0));
        aVarB.f8878g = tb.a.f12440v;
        b bVarB = aVarB.b();
        a aVarB2 = b.b(new r(c.class, ke.r.class));
        aVarB2.a(new j(new r(c.class, Executor.class), 1, 0));
        aVarB2.f8878g = tb.a.f12441w;
        b bVarB2 = aVarB2.b();
        a aVarB3 = b.b(new r(ma.b.class, ke.r.class));
        aVarB3.a(new j(new r(ma.b.class, Executor.class), 1, 0));
        aVarB3.f8878g = tb.a.f12442x;
        b bVarB3 = aVarB3.b();
        a aVarB4 = b.b(new r(d.class, ke.r.class));
        aVarB4.a(new j(new r(d.class, Executor.class), 1, 0));
        aVarB4.f8878g = tb.a.f12443y;
        return od.j.S(bVarB, bVarB2, bVarB3, aVarB4.b());
    }
}
