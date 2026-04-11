package e6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q6.a f4532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p0.c f4533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4534e;

    public l(Class cls, Class cls2, Class cls3, List list, q6.a aVar, kc.b bVar) {
        this.f4530a = cls;
        this.f4531b = list;
        this.f4532c = aVar;
        this.f4533d = bVar;
        this.f4534e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final b0 a(int i, int i10, c6.i iVar, com.bumptech.glide.load.data.g gVar, i iVar2) {
        b0 b0VarA;
        c6.m mVar;
        int iK;
        boolean z2;
        boolean z10;
        boolean z11;
        boolean z12;
        Object eVar;
        p0.c cVar = this.f4533d;
        Object objI = cVar.i();
        x6.f.c(objI, "Argument must not be null");
        List list = (List) objI;
        try {
            b0 b0VarB = b(gVar, i, i10, iVar, list);
            cVar.b(list);
            k kVar = (k) iVar2.f4523v;
            int i11 = iVar2.f4522u;
            h hVar = kVar.f4524u;
            Class<?> cls = b0VarB.get().getClass();
            c6.l lVarB = null;
            if (i11 != 4) {
                c6.m mVarE = hVar.e(cls);
                mVar = mVarE;
                b0VarA = mVarE.a(kVar.B, b0VarB, kVar.F, kVar.G);
            } else {
                b0VarA = b0VarB;
                mVar = null;
            }
            if (!b0VarB.equals(b0VarA)) {
                b0VarB.d();
            }
            if (hVar.f4508c.b().f2788d.b(b0VarA.c()) != null) {
                lVarB = hVar.f4508c.b().f2788d.b(b0VarA.c());
                if (lVarB == null) {
                    throw new com.bumptech.glide.h(b0VarA.c());
                }
                iK = lVarB.k(kVar.I);
            } else {
                iK = 3;
            }
            c6.l lVar = lVarB;
            c6.f fVar = kVar.O;
            ArrayList arrayListB = hVar.b();
            int size = arrayListB.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z2 = false;
                    break;
                }
                if (((i6.q) arrayListB.get(i12)).f6420a.equals(fVar)) {
                    z2 = true;
                    break;
                }
                i12++;
            }
            switch (kVar.H.f4538a) {
                default:
                    z10 = true;
                    if (((z2 || i11 != 3) && i11 != 1) || iK != 2) {
                    }
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 1:
                    z10 = false;
                    break;
            }
            if (z10) {
                if (lVar == null) {
                    throw new com.bumptech.glide.h(b0VarA.get().getClass());
                }
                int iC = v.e.c(iK);
                if (iC == 0) {
                    z11 = false;
                    z12 = true;
                    eVar = new e(kVar.O, kVar.C);
                } else {
                    if (iC != 1) {
                        throw new IllegalArgumentException("Unknown strategy: ".concat(iK != 1 ? iK != 2 ? iK != 3 ? "null" : "NONE" : "TRANSFORMED" : "SOURCE"));
                    }
                    z11 = false;
                    z12 = true;
                    eVar = new d0(hVar.f4508c.f2772a, kVar.O, kVar.C, kVar.F, kVar.G, mVar, cls, kVar.I);
                }
                a0 a0Var = (a0) a0.f4468y.i();
                a0Var.f4472x = z11;
                a0Var.f4471w = z12;
                a0Var.f4470v = b0VarA;
                a7.b bVar = kVar.f4529z;
                bVar.f618v = eVar;
                bVar.f619w = lVar;
                bVar.f620x = a0Var;
                b0VarA = a0Var;
            }
            return this.f4532c.f(b0VarA, iVar);
        } catch (Throwable th) {
            cVar.b(list);
            throw th;
        }
    }

    public final b0 b(com.bumptech.glide.load.data.g gVar, int i, int i10, c6.i iVar, List list) throws x {
        List list2 = this.f4531b;
        int size = list2.size();
        b0 b0VarB = null;
        for (int i11 = 0; i11 < size; i11++) {
            c6.k kVar = (c6.k) list2.get(i11);
            try {
                if (kVar.a(gVar.a(), iVar)) {
                    b0VarB = kVar.b(gVar.a(), i, i10, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e10);
                }
                list.add(e10);
            }
            if (b0VarB != null) {
                break;
            }
        }
        if (b0VarB != null) {
            return b0VarB;
        }
        throw new x(this.f4534e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f4530a + ", decoders=" + this.f4531b + ", transcoder=" + this.f4532c + '}';
    }
}
