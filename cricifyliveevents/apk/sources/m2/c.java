package m2;

import java.util.ArrayList;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f8047c = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x3.e f8048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8049b;

    public static void a(int i, ArrayList arrayList) {
        if (com.bumptech.glide.d.v(f8047c, i, 0, 7) == -1 || arrayList.contains(Integer.valueOf(i))) {
            return;
        }
        arrayList.add(Integer.valueOf(i));
    }

    public final v1.p b(v1.p pVar) {
        if (!this.f8049b || !this.f8048a.e(pVar)) {
            return pVar;
        }
        v1.o oVarA = pVar.a();
        String str = pVar.f12943k;
        oVarA.f12893m = m0.p("application/x-media3-cues");
        oVarA.K = this.f8048a.b(pVar);
        StringBuilder sb = new StringBuilder();
        sb.append(pVar.f12946n);
        sb.append(str != null ? " ".concat(str) : "");
        oVarA.f12890j = sb.toString();
        oVarA.f12898r = Long.MAX_VALUE;
        return new v1.p(oVarA);
    }
}
