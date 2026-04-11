package t2;

import b2.o;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends e {
    public final long E;

    public k(b2.h hVar, o oVar, p pVar, int i, Object obj, long j4, long j7, long j10) {
        super(hVar, oVar, 1, pVar, i, obj, j4, j7);
        pVar.getClass();
        this.E = j10;
    }

    public long b() {
        long j4 = this.E;
        if (j4 != -1) {
            return j4 + 1;
        }
        return -1L;
    }

    public abstract boolean c();
}
