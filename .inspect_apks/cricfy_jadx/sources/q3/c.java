package q3;

import a3.k0;
import f9.a0;
import f9.b0;
import f9.c0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v1.l0;
import y1.t;
import y1.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends u8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f10360e = new t();
    public final k0 f = new k0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y f10361g;

    @Override // u8.a
    public final l0 p(j3.a aVar, ByteBuffer byteBuffer) {
        v1.k0 dVar;
        long j4;
        y yVar = this.f10361g;
        if (yVar == null || aVar.f6587v != yVar.e()) {
            y yVar2 = new y(aVar.timeUs);
            this.f10361g = yVar2;
            yVar2.a(aVar.timeUs - aVar.f6587v);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        t tVar = this.f10360e;
        tVar.H(iLimit, bArrArray);
        k0 k0Var = this.f;
        k0Var.o(iLimit, bArrArray);
        k0Var.t(39);
        long jI = (((long) k0Var.i(1)) << 32) | ((long) k0Var.i(32));
        k0Var.t(20);
        int i = k0Var.i(12);
        int i10 = k0Var.i(8);
        tVar.K(14);
        if (i10 == 0) {
            dVar = new d();
        } else if (i10 == 255) {
            long jZ = tVar.z();
            int i11 = i - 4;
            tVar.h(new byte[i11], 0, i11);
            dVar = new a(0, jZ, jI);
        } else if (i10 == 4) {
            int iX = tVar.x();
            ArrayList arrayList = new ArrayList(iX);
            for (int i12 = 0; i12 < iX; i12++) {
                tVar.z();
                boolean z10 = (tVar.x() & 128) != 0;
                ArrayList arrayList2 = new ArrayList();
                if (!z10) {
                    int iX2 = tVar.x();
                    boolean z11 = (iX2 & 64) != 0;
                    boolean z12 = (iX2 & 32) != 0;
                    if (z11) {
                        tVar.z();
                    }
                    if (!z11) {
                        int iX3 = tVar.x();
                        ArrayList arrayList3 = new ArrayList(iX3);
                        for (int i13 = 0; i13 < iX3; i13++) {
                            tVar.x();
                            tVar.z();
                            arrayList3.add(new b0(22));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z12) {
                        tVar.x();
                        tVar.z();
                    }
                    tVar.D();
                    tVar.x();
                    tVar.x();
                }
                c0 c0Var = new c0(22);
                Collections.unmodifiableList(arrayList2);
                arrayList.add(c0Var);
            }
            dVar = new d();
            Collections.unmodifiableList(arrayList);
        } else if (i10 == 5) {
            y yVar3 = this.f10361g;
            tVar.z();
            boolean z13 = (tVar.x() & 128) != 0;
            List list = Collections.EMPTY_LIST;
            if (z13) {
                j4 = -9223372036854775807L;
            } else {
                int iX4 = tVar.x();
                boolean z14 = (iX4 & 64) != 0;
                boolean z15 = (iX4 & 32) != 0;
                boolean z16 = (iX4 & 16) != 0;
                long jD = (!z14 || z16) ? -9223372036854775807L : a.d(jI, tVar);
                if (!z14) {
                    int iX5 = tVar.x();
                    ArrayList arrayList4 = new ArrayList(iX5);
                    for (int i14 = 0; i14 < iX5; i14++) {
                        tVar.x();
                        yVar3.b(!z16 ? a.d(jI, tVar) : -9223372036854775807L);
                        arrayList4.add(new a0(22));
                    }
                    list = arrayList4;
                }
                if (z15) {
                    tVar.x();
                    tVar.z();
                }
                tVar.D();
                tVar.x();
                tVar.x();
                j4 = jD;
            }
            dVar = new a(j4, yVar3.b(j4), list);
        } else if (i10 != 6) {
            dVar = null;
        } else {
            y yVar4 = this.f10361g;
            long jD2 = a.d(jI, tVar);
            dVar = new a(2, jD2, yVar4.b(jD2));
        }
        return dVar == null ? new l0(new v1.k0[0]) : new l0(dVar);
    }
}
