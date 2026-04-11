package pf;

import c2.o;
import com.bumptech.glide.l;
import java.util.ArrayList;
import kf.q;
import kf.r;
import kf.z;
import of.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f10296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f10299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f10300e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10302h;
    public int i;

    public h(n nVar, ArrayList arrayList, int i, l lVar, o oVar, int i10, int i11, int i12) {
        this.f10296a = nVar;
        this.f10297b = arrayList;
        this.f10298c = i;
        this.f10299d = lVar;
        this.f10300e = oVar;
        this.f = i10;
        this.f10301g = i11;
        this.f10302h = i12;
    }

    public static h a(h hVar, int i, l lVar, o oVar, int i10) {
        if ((i10 & 1) != 0) {
            i = hVar.f10298c;
        }
        int i11 = i;
        if ((i10 & 2) != 0) {
            lVar = hVar.f10299d;
        }
        l lVar2 = lVar;
        if ((i10 & 4) != 0) {
            oVar = hVar.f10300e;
        }
        o oVar2 = oVar;
        int i12 = hVar.f;
        int i13 = hVar.f10301g;
        int i14 = hVar.f10302h;
        ge.i.e(oVar2, "request");
        return new h(hVar.f10296a, hVar.f10297b, i11, lVar2, oVar2, i12, i13, i14);
    }

    public final z b(o oVar) {
        ge.i.e(oVar, "request");
        ArrayList arrayList = this.f10297b;
        int size = arrayList.size();
        int i = this.f10298c;
        if (i >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.i++;
        l lVar = this.f10299d;
        if (lVar != null) {
            if (!((of.h) lVar.f2224x).l().f((q) oVar.f2035b)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must retain the same host and port").toString());
            }
            if (this.i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i10 = i + 1;
        h hVarA = a(this, i10, null, oVar, 58);
        r rVar = (r) arrayList.get(i);
        z zVarA = rVar.a(hVarA);
        if (zVarA == null) {
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        if (lVar == null || i10 >= arrayList.size() || hVarA.i == 1) {
            return zVarA;
        }
        throw new IllegalStateException(("network interceptor " + rVar + " must call proceed() exactly once").toString());
    }
}
