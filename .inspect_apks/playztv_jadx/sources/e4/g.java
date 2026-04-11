package e4;

import e6.j;
import p1.n0;
import s1.u;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f4421a = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f4422b = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean a(p pVar) {
        u uVar = new u(8);
        int i = f.b(pVar, uVar).f4419a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        pVar.w(uVar.f11709a, 0, 4);
        uVar.J(0);
        int iJ = uVar.j();
        if (iJ == 1463899717) {
            return true;
        }
        s1.b.g("WavHeaderReader", "Unsupported form type: " + iJ);
        return false;
    }

    public static f b(int i, p pVar, u uVar) throws n0 {
        f fVarB = f.b(pVar, uVar);
        while (true) {
            int i10 = fVarB.f4419a;
            if (i10 == i) {
                return fVarB;
            }
            j.p(i10, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j5 = fVarB.f4420b;
            long j8 = 8 + j5;
            if (j5 % 2 != 0) {
                j8 = 9 + j5;
            }
            if (j8 > 2147483647L) {
                throw n0.c("Chunk is too large (~2GB+) to skip; id: " + i10);
            }
            pVar.m((int) j8);
            fVarB = f.b(pVar, uVar);
        }
    }
}
