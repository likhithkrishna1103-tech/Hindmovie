package com.google.firebase;

import ab.h;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import gb.c;
import gb.d;
import hb.a;
import hb.b;
import hb.j;
import hb.r;
import java.util.List;
import java.util.concurrent.Executor;
import pe.s;
import sd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        a aVarA = b.a(new r(gb.a.class, s.class));
        aVarA.a(new j(new r(gb.a.class, Executor.class), 1, 0));
        aVarA.f5875g = h.f398w;
        b bVarB = aVarA.b();
        a aVarA2 = b.a(new r(c.class, s.class));
        aVarA2.a(new j(new r(c.class, Executor.class), 1, 0));
        aVarA2.f5875g = h.f399x;
        b bVarB2 = aVarA2.b();
        a aVarA3 = b.a(new r(gb.b.class, s.class));
        aVarA3.a(new j(new r(gb.b.class, Executor.class), 1, 0));
        aVarA3.f5875g = h.f400y;
        b bVarB3 = aVarA3.b();
        a aVarA4 = b.a(new r(d.class, s.class));
        aVarA4.a(new j(new r(d.class, Executor.class), 1, 0));
        aVarA4.f5875g = h.f401z;
        return i.a(new b[]{bVarB, bVarB2, bVarB3, aVarA4.b()});
    }
}
