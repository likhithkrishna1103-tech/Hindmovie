package z6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f15283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l7.b f15285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0.c f15286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15287e;

    public l(Class cls, Class cls2, Class cls3, List list, l7.b bVar, l7.a aVar) {
        this.f15283a = cls;
        this.f15284b = list;
        this.f15285c = bVar;
        this.f15286d = aVar;
        this.f15287e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final b0 a(int i, int i10, ag.o oVar, com.bumptech.glide.load.data.f fVar, x6.h hVar) {
        b0 b0VarB;
        x6.l lVar;
        int iL;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Object dVar;
        s0.c cVar = this.f15286d;
        List list = (List) cVar.i();
        s7.f.c(list, "Argument must not be null");
        try {
            b0 b0VarB2 = b(fVar, i, i10, hVar, list);
            cVar.b(list);
            k kVar = (k) oVar.f455x;
            int i11 = oVar.f454w;
            h hVar2 = kVar.f15278v;
            Class<?> cls = b0VarB2.get().getClass();
            x6.k kVarF = null;
            if (i11 != 4) {
                x6.l lVarE = hVar2.e(cls);
                lVar = lVarE;
                b0VarB = lVarE.b(kVar.C, b0VarB2, kVar.G, kVar.H);
            } else {
                b0VarB = b0VarB2;
                lVar = null;
            }
            if (!b0VarB2.equals(b0VarB)) {
                b0VarB2.e();
            }
            if (hVar2.f15261c.b().f2217d.f(b0VarB.d()) != null) {
                kVarF = hVar2.f15261c.b().f2217d.f(b0VarB.d());
                if (kVarF == null) {
                    throw new com.bumptech.glide.j(b0VarB.d());
                }
                iL = kVarF.l(kVar.J);
            } else {
                iL = 3;
            }
            x6.k kVar2 = kVarF;
            x6.e eVar = kVar.R;
            ArrayList arrayListB = hVar2.b();
            int size = arrayListB.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z10 = false;
                    break;
                }
                if (((d7.s) arrayListB.get(i12)).f3507a.equals(eVar)) {
                    z10 = true;
                    break;
                }
                i12++;
            }
            switch (kVar.I.f15291a) {
                default:
                    z11 = true;
                    if (((z10 || i11 != 3) && i11 != 1) || iL != 2) {
                    }
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 1:
                    z11 = false;
                    break;
            }
            if (z11) {
                if (kVar2 == null) {
                    throw new com.bumptech.glide.j(b0VarB.get().getClass());
                }
                int iC = y.e.c(iL);
                if (iC == 0) {
                    z12 = false;
                    z13 = true;
                    dVar = new d(kVar.R, kVar.D);
                } else {
                    if (iC != 1) {
                        throw new IllegalArgumentException("Unknown strategy: ".concat(iL != 1 ? iL != 2 ? iL != 3 ? "null" : "NONE" : "TRANSFORMED" : "SOURCE"));
                    }
                    z12 = false;
                    z13 = true;
                    dVar = new d0(hVar2.f15261c.f2201a, kVar.R, kVar.D, kVar.G, kVar.H, lVar, cls, kVar.J);
                }
                a0 a0Var = (a0) a0.f15227z.i();
                a0Var.f15231y = z12;
                a0Var.f15230x = z13;
                a0Var.f15229w = b0VarB;
                e eVar2 = kVar.A;
                eVar2.f15251a = dVar;
                eVar2.f15252b = kVar2;
                eVar2.f15253c = a0Var;
                b0VarB = a0Var;
            }
            return this.f15285c.e(b0VarB, hVar);
        } catch (Throwable th) {
            cVar.b(list);
            throw th;
        }
    }

    public final b0 b(com.bumptech.glide.load.data.f fVar, int i, int i10, x6.h hVar, List list) throws x {
        List list2 = this.f15284b;
        int size = list2.size();
        b0 b0VarB = null;
        for (int i11 = 0; i11 < size; i11++) {
            x6.j jVar = (x6.j) list2.get(i11);
            try {
                if (jVar.a(fVar.c(), hVar)) {
                    b0VarB = jVar.b(fVar.c(), i, i10, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e9) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e9);
                }
                list.add(e9);
            }
            if (b0VarB != null) {
                break;
            }
        }
        if (b0VarB != null) {
            return b0VarB;
        }
        throw new x(this.f15287e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f15283a + ", decoders=" + this.f15284b + ", transcoder=" + this.f15285c + '}';
    }
}
