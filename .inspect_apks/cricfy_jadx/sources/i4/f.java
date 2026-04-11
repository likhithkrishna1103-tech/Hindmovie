package i4;

import a3.q;
import v1.n0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f6208a = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f6209b = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean a(q qVar) {
        t tVar = new t(8);
        int i = e.b(qVar, tVar).f6206a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        qVar.z(tVar.f14609a, 0, 4);
        tVar.J(0);
        int iJ = tVar.j();
        if (iJ == 1463899717) {
            return true;
        }
        y1.b.g("WavHeaderReader", "Unsupported form type: " + iJ);
        return false;
    }

    public static e b(int i, q qVar, t tVar) throws n0 {
        e eVarB = e.b(qVar, tVar);
        while (true) {
            int i10 = eVarB.f6206a;
            if (i10 == i) {
                return eVarB;
            }
            l0.e.p(i10, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j4 = eVarB.f6207b;
            long j7 = 8 + j4;
            if (j4 % 2 != 0) {
                j7 = 9 + j4;
            }
            if (j7 > 2147483647L) {
                throw n0.c("Chunk is too large (~2GB+) to skip; id: " + i10);
            }
            qVar.n((int) j7);
            eVarB = e.b(qVar, tVar);
        }
    }
}
