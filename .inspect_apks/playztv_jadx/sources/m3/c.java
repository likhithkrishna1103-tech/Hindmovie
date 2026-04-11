package m3;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k8.a0;
import k8.c0;
import p1.k0;
import p1.l0;
import s1.t;
import s1.u;
import s1.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f8305d = new u();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f8306e = new t();
    public z f;

    @Override // com.bumptech.glide.c
    public final l0 i(f3.a aVar, ByteBuffer byteBuffer) {
        k0 dVar;
        long j5;
        z zVar = this.f;
        if (zVar == null || aVar.f4757u != zVar.e()) {
            z zVar2 = new z(aVar.timeUs);
            this.f = zVar2;
            zVar2.a(aVar.timeUs - aVar.f4757u);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        u uVar = this.f8305d;
        uVar.H(iLimit, bArrArray);
        t tVar = this.f8306e;
        tVar.o(iLimit, bArrArray);
        tVar.t(39);
        long jI = (((long) tVar.i(1)) << 32) | ((long) tVar.i(32));
        tVar.t(20);
        int i = tVar.i(12);
        int i10 = tVar.i(8);
        uVar.K(14);
        if (i10 == 0) {
            dVar = new d();
        } else if (i10 == 255) {
            long jZ = uVar.z();
            int i11 = i - 4;
            uVar.h(new byte[i11], 0, i11);
            dVar = new a(0, jZ, jI);
        } else if (i10 == 4) {
            int iX = uVar.x();
            ArrayList arrayList = new ArrayList(iX);
            for (int i12 = 0; i12 < iX; i12++) {
                uVar.z();
                boolean z2 = (uVar.x() & 128) != 0;
                ArrayList arrayList2 = new ArrayList();
                if (!z2) {
                    int iX2 = uVar.x();
                    boolean z10 = (iX2 & 64) != 0;
                    boolean z11 = (iX2 & 32) != 0;
                    if (z10) {
                        uVar.z();
                    }
                    if (!z10) {
                        int iX3 = uVar.x();
                        ArrayList arrayList3 = new ArrayList(iX3);
                        for (int i13 = 0; i13 < iX3; i13++) {
                            uVar.x();
                            uVar.z();
                            arrayList3.add(new k8.z(19));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z11) {
                        uVar.x();
                        uVar.z();
                    }
                    uVar.D();
                    uVar.x();
                    uVar.x();
                }
                a0 a0Var = new a0(19);
                Collections.unmodifiableList(arrayList2);
                arrayList.add(a0Var);
            }
            d dVar2 = new d();
            Collections.unmodifiableList(arrayList);
            dVar = dVar2;
        } else if (i10 == 5) {
            z zVar3 = this.f;
            uVar.z();
            boolean z12 = (uVar.x() & 128) != 0;
            List list = Collections.EMPTY_LIST;
            if (z12) {
                j5 = -9223372036854775807L;
            } else {
                int iX4 = uVar.x();
                boolean z13 = (iX4 & 64) != 0;
                boolean z14 = (iX4 & 32) != 0;
                boolean z15 = (iX4 & 16) != 0;
                long jD = (!z13 || z15) ? -9223372036854775807L : a.d(jI, uVar);
                if (!z13) {
                    int iX5 = uVar.x();
                    ArrayList arrayList4 = new ArrayList(iX5);
                    for (int i14 = 0; i14 < iX5; i14++) {
                        uVar.x();
                        zVar3.b(!z15 ? a.d(jI, uVar) : -9223372036854775807L);
                        arrayList4.add(new c0(18));
                    }
                    list = arrayList4;
                }
                if (z14) {
                    uVar.x();
                    uVar.z();
                }
                uVar.D();
                uVar.x();
                uVar.x();
                j5 = jD;
            }
            dVar = new a(j5, zVar3.b(j5), list);
        } else if (i10 != 6) {
            dVar = null;
        } else {
            z zVar4 = this.f;
            long jD2 = a.d(jI, uVar);
            dVar = new a(2, jD2, zVar4.b(jD2));
        }
        return dVar == null ? new l0(new k0[0]) : new l0(dVar);
    }
}
