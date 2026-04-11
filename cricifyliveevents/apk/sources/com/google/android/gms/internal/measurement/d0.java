package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nc.p f2358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b6.f f2359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.emoji2.text.v f2360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f2361d;

    public d0() {
        nc.p pVar = new nc.p(3);
        this.f2358a = pVar;
        this.f2359b = ((b6.f) pVar.f9070b).w();
        this.f2360c = new androidx.emoji2.text.v(5);
        this.f2361d = new t(3);
        final int i = 1;
        Callable callable = new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f2311b;

            {
                this.f2311b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return new k4(this.f2311b.f2360c);
                    default:
                        return new k4(this.f2311b.f2361d);
                }
            }
        };
        w5 w5Var = (w5) pVar.f9072d;
        ((HashMap) w5Var.f2709a).put("internal.registerCallback", callable);
        final int i10 = 0;
        ((HashMap) w5Var.f2709a).put("internal.eventLogger", new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f2311b;

            {
                this.f2311b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return new k4(this.f2311b.f2360c);
                    default:
                        return new k4(this.f2311b.f2361d);
                }
            }
        });
    }

    public final boolean a(b bVar) throws p0 {
        androidx.emoji2.text.v vVar = this.f2360c;
        try {
            vVar.f888w = bVar;
            vVar.f889x = bVar.clone();
            ((ArrayList) vVar.f890y).clear();
            ((b6.f) this.f2358a.f9071c).y("runtime.counter", new g(Double.valueOf(0.0d)));
            this.f2361d.d(this.f2359b.w(), vVar);
            if (((b) vVar.f889x).equals((b) vVar.f888w)) {
                return !((ArrayList) vVar.f890y).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new p0(th);
        }
    }

    public final void b(v3 v3Var) throws p0 {
        h hVar;
        try {
            nc.p pVar = this.f2358a;
            this.f2359b = ((b6.f) pVar.f9070b).w();
            if (pVar.D(this.f2359b, (w3[]) v3Var.p().toArray(new w3[0])) instanceof f) {
                throw new IllegalStateException("Program loading failed");
            }
            for (u3 u3Var : v3Var.q().p()) {
                List listQ = u3Var.q();
                String strP = u3Var.p();
                Iterator it = listQ.iterator();
                while (it.hasNext()) {
                    n nVarD = pVar.D(this.f2359b, (w3) it.next());
                    if (!(nVarD instanceof k)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    b6.f fVar = this.f2359b;
                    if (fVar.x(strP)) {
                        n nVarA = fVar.A(strP);
                        if (!(nVarA instanceof h)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strP)));
                        }
                        hVar = (h) nVarA;
                    } else {
                        hVar = null;
                    }
                    if (hVar == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strP)));
                    }
                    hVar.e(this.f2359b, Collections.singletonList(nVarD));
                }
            }
        } catch (Throwable th) {
            throw new p0(th);
        }
    }
}
