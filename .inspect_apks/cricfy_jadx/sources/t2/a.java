package t2;

import b2.o;
import nb.w;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends k {
    public final long F;
    public final long G;
    public w H;
    public int[] I;

    public a(b2.h hVar, o oVar, p pVar, int i, Object obj, long j4, long j7, long j10, long j11, long j12) {
        super(hVar, oVar, pVar, i, obj, j4, j7, j12);
        this.F = j10;
        this.G = j11;
    }

    public final int e(int i) {
        int[] iArr = this.I;
        y1.d.h(iArr);
        return iArr[i];
    }
}
